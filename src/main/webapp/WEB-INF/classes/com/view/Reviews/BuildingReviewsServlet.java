package com.view.Reviews;

import com.app.BuildingReviewsSetup;
import com.entity.review.Review;
import com.entity.user.User;
import com.interface_adapter.building_reviews.BuildingReviewsController;
import com.use_case.building_reviews.BuildingReviewsOutputData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class BuildingReviewsServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;

        HttpSession session = request.getSession();
        String buildingCode = session.getAttribute("buildingCode").toString();

        // Initialize the loop for the use_case
        BuildingReviewsController buildingReviewsController = BuildingReviewsSetup.setup(this);

        // call the SignupController passing it the inputs
        buildingReviewsController.execute(buildingCode);
    }

    public void displayReviews(BuildingReviewsOutputData buildingReviewsOutputData) {
        StringBuilder reviewsJson = new StringBuilder("[");
        System.out.println(reviewsJson);
        for (Review review: buildingReviewsOutputData.getReviews()) {
            int user = review.getUser();
            Date date = review.getDate();
            float rating = review.getRating();
            String title = review.getTitle();
            String content = review.getContent();

            reviewsJson.append(String.format("{" +
                            "\"username\": \"%s\", " +
                            "\"date\": \"%s\", " +
                            "\"rating\": \"%s\", " +
                            "\"title\": \"%s\", " +
                            "\"content\": \"%s\" " +
                            "},",
                    user, date, rating, title, content));
            System.out.println(reviewsJson);
        }
        reviewsJson.delete(reviewsJson.length() - 1, reviewsJson.length());
        reviewsJson.append("]");

        System.out.println(reviewsJson);

        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(reviewsJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write reviews");
        }
    }
}
