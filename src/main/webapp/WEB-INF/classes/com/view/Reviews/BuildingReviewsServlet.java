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
import java.util.List;

public class BuildingReviewsServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;

        HttpSession session = request.getSession();
        String buildingCode = (String) session.getAttribute("buildingCode");

        if (buildingCode != null) {
            // Initialize the loop for the use_case
            BuildingReviewsController buildingReviewsController = BuildingReviewsSetup.setup(this);

            // call the SignupController passing it the inputs
            buildingReviewsController.execute(buildingCode);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Building code not found in session");
        }
    }

    public void displayReviews(BuildingReviewsOutputData buildingReviewsOutputData) {
        List<Review> reviews = buildingReviewsOutputData.getReviews();
        StringBuilder reviewsJson = new StringBuilder("[");
        for (Review review: reviews) {
            reviewsJson.append(review.getJsonRepresentation()).append(",");
        }
        if (!reviews.isEmpty()) {
            reviewsJson.delete(reviewsJson.length() - 1, reviewsJson.length());
        }
        reviewsJson.append("]");


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
