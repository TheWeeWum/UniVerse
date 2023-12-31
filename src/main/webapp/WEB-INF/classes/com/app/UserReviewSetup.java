package com.app;

import com.data_access.FileUserDataAccessObject;
import com.data_access.UserReviewDataAccessObject;
import com.entity.review.ReviewBuilder;
import com.interface_adapter.user_reviews.UserReviewsController;
import com.interface_adapter.user_reviews.UserReviewsPresenter;
import com.use_case.open_myreviews.OpenReviewDataAccessInterface;
import com.use_case.open_myreviews.OpenReviewInputBoundary;
import com.use_case.open_myreviews.OpenReviewInteractor;
import com.use_case.open_myreviews.OpenReviewOutputBoundary;
import com.view.Reviews.UserReviewServlet;

public class UserReviewSetup {
    public static UserReviewsController setup(UserReviewServlet userReviewServlet) {
        OpenReviewOutputBoundary presenter = new UserReviewsPresenter(userReviewServlet);

        OpenReviewDataAccessInterface dataAccess = DataAccessBuilder.getUserReviewDataAccessObject();

        OpenReviewInputBoundary interactor = new OpenReviewInteractor(dataAccess, presenter);
        return new UserReviewsController(interactor);
    }
}
