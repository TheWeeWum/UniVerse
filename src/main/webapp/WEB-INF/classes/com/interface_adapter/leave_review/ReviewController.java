package com.interface_adapter.leave_review;

import com.use_case.leave_review.ReviewInputBoundary;
import com.use_case.leave_review.ReviewInputData;
import com.use_case.signup.SignupInputData;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class ReviewController {
    ReviewInputBoundary interactor;
    public ReviewController(ReviewInputBoundary interactor) {
        this.interactor = interactor;
}

    public void execute(HttpServletRequest request) {
        // get current date of type Date
        LocalDate localDate = LocalDate.now();
        Date currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        float rating = Float.parseFloat(request.getParameter("rating"));
        // if user is not loggen in, then the userId is -1.
        if (request.getAttribute("id") == null) {
            request.setAttribute("id", -1);
        }
        int userId = Integer.parseInt(request.getAttribute("id").toString());

        String reviewContent = request.getParameter("reviewContent");
        String title = request.getParameter("reviewTitle");
        String buildingCode = request.getAttribute("buildingCode").toString();


        ReviewInputData reviewInputData = new ReviewInputData(currentDate, rating, reviewContent, title, userId, buildingCode);

        interactor.execute(reviewInputData);
    }
}


