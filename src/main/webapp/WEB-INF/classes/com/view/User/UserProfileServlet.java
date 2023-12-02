package com.view.User;

import com.app.ProfileSetup;
import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.review.Review;
import com.entity.room.Room;
import com.entity.user.LoggedInUser;
import com.interface_adapter.open_profile.ProfileController;
import com.use_case.open_profile.ProfileInteractor;
import com.use_case.open_profile.ProfileOutputData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserProfileServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here
        HttpSession session = request.getSession();
        this.request = request;
        this.response = response;

        if (session.getAttribute("loggedIn") == null) {
            // If the user is not logged in, set a default message
            session.setAttribute("username", "You are not signed in");
        } else if (session.getAttribute("loggedIn").equals(false)) {
            // If the user is not logged in, set a default message
            session.setAttribute("username", "You are not signed in");
        }

        // Redirect to the profile.jsp page
        response.sendRedirect("profile.jsp");
    }


    public void writeProfile(ProfileOutputData profileOutputData) {
        // Prepare JSON for reviews
        StringBuilder reviewsJson = new StringBuilder("[");

        for (Review review : profileOutputData.getReviews()) {
            String title = review.getTitle();
            String content = review.getContent();
            float rating = review.getRating();

            reviewsJson.append(String.format("{ " + "\"title\": \"%s\", " + "\"content\": \"%s\", " + "\"rating\": %d " + "},",
                    title, content, rating));
        }
        if (profileOutputData.getReviews().size() > 0) {
            // delete comma at the end
            reviewsJson.delete(reviewsJson.length() - 1, reviewsJson.length());
        }
        reviewsJson.append("]");

        // Prepare JSON for favorites
        StringBuilder favoritesJson = new StringBuilder("[");

        for (Reviewable favorite : profileOutputData.getFavourites()) {
            if (favorite instanceof Building) {
                Building building = (Building) favorite;
                String name = building.getName();
                String code = building.getCode();

                favoritesJson.append(String.format("{ " + "\"name\": \"%s\", " + "\"code\": \"%s\" " + "},", name, code));
            } else if (favorite instanceof Room) {
                Room room = (Room) favorite;
                String roomNumber = room.getRoomNumber();
                String code = room.getFloor();

                favoritesJson.append(String.format("{ " + "\"name\": \"%s\", " + "\"code\": \"%s\" " + "},", roomNumber, code));
            }
            // Add more conditions for other types if necessary
        }
        if (profileOutputData.getFavourites().size() > 0) {
            // delete comma at the end
            favoritesJson.delete(favoritesJson.length() - 1, favoritesJson.length());
        }
        favoritesJson.append("]");

        // Print or write JSON for reviews and favorites as needed
        System.out.println("Reviews JSON: " + reviewsJson);
        System.out.println("Favorites JSON: " + favoritesJson);

        try {
            // Set content type and write JSON response
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{ \"reviews\": " + reviewsJson + ", \"favorites\": " + favoritesJson + "}");
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write profile data");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // save the request and response for use later in
        // sendToProfileScreen and signupFailed
        this.request = request;
        this.response = response;
        // Initialize the loop for the use_case

    }
}
