package com.app;

import com.data_access.BuildingDataAccessObject;
import com.data_access.BuildingReviewDataAccessObject;
import com.data_access.FileUserDataAccessObject;
import com.interface_adapter.leave_review.ReviewController;
import com.interface_adapter.leave_review.ReviewPresenter;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.use_case.leave_review.ReviewDataAccessInterface;
import com.use_case.leave_review.ReviewInputBoundary;
import com.use_case.leave_review.ReviewInteractor;
import com.use_case.leave_review.ReviewOutputBoundary;
import com.view.Building.BuildingPageServlet;

public class ReviewSetup {
    public static ReviewController setup(BuildingPageServlet buildingPageServlet) {
        ReviewDataAccessInterface userDataAccessObject = new FileUserDataAccessObject();
        BuildingReviewsDataAccessInterface buildingReviewsDataAccessObject = new BuildingReviewDataAccessObject((FileUserDataAccessObject) userDataAccessObject);

        ReviewOutputBoundary presenter = new ReviewPresenter(buildingPageServlet);
        ReviewInputBoundary interactor = new ReviewInteractor(presenter, userDataAccessObject, buildingReviewsDataAccessObject);

        return new ReviewController(interactor);
    }
}
