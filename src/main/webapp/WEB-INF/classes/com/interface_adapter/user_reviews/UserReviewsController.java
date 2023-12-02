package com.interface_adapter.user_reviews;

import com.use_case.building_reviews.BuildingReviewsInputBoundary;
import com.use_case.building_reviews.BuildingReviewsInputData;
import com.use_case.open_myreviews.OpenReviewInputBoundary;
import com.use_case.open_myreviews.OpenReviewInputData;
import com.view.Reviews.UserReviewServlet;

public class UserReviewsController {
    OpenReviewInputBoundary userReviewsInteractor;
    public UserReviewsController(OpenReviewInputBoundary userReviewsInteractor) {
        this.userReviewsInteractor = userReviewsInteractor;
    }


    public void execute(int userID) {
        OpenReviewInputData openReviewInputData = new OpenReviewInputData(userID);
        userReviewsInteractor.execute(openReviewInputData);
    }
}
