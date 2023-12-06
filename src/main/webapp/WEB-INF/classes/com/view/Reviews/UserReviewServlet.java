package com.view.Reviews;

import com.app.UserReviewSetup;
import com.entity.review.Review;
import com.interface_adapter.user_reviews.UserReviewsController;
import com.use_case.open_myreviews.OpenReviewOutputData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserReviewServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;

        System.out.println("UReviewServlet");

        HttpSession session = request.getSession();
        int userid;
        try {
            userid = Integer.parseInt(session.getAttribute("id").toString());
        } catch (NullPointerException e) {
            System.out.println("user not signed in");
            response.sendRedirect("index.jsp");
            return;
        }

        System.out.println("Got id");

        // Initialize the loop for the use_case
        UserReviewsController userReviewsController = UserReviewSetup.setup(this);

        // call the controller passing it the inputs
        userReviewsController.execute(userid);
    }

    public void displayReviews(OpenReviewOutputData userReviewsOutputData) {
        List<Review> reviews = userReviewsOutputData.getReviews();
        StringBuilder reviewsJson = new StringBuilder("[");
        for (Review review: reviews) {
            reviewsJson.append(review.getJsonRepresentation()).append(",");
        }
        if (!reviews.isEmpty()) {
            reviewsJson.delete(reviewsJson.length() - 1, reviewsJson.length());
        }
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
