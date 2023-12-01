package com.app;


import com.data_access.BuildingReviewDataAccessObject;
import com.data_access.FileUserDataAccessObject;
import com.data_access.Path;
import com.entity.review.ReviewBuilder;
import com.interface_adapter.building_reviews.BuildingReviewsController;
import com.interface_adapter.building_reviews.BuildingReviewsPresenter;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.use_case.building_reviews.BuildingReviewsInputBoundary;
import com.use_case.building_reviews.BuildingReviewsInteractor;
import com.use_case.building_reviews.BuildingReviewsOutputBoundary;
import com.view.Reviews.BuildingReviewsServlet;

public class BuildingReviewsSetup {
    public static BuildingReviewsController setup(BuildingReviewsServlet buildingsReviewsServlet) {
        BuildingReviewsOutputBoundary presenter = new BuildingReviewsPresenter(buildingsReviewsServlet);

        ReviewBuilder reviewBuilder = new ReviewBuilder();
        String reviewPath = Path.path + "external-data/buildingreviews.json";
        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();
        BuildingReviewsDataAccessInterface dataAccess = new BuildingReviewDataAccessObject(reviewPath, reviewBuilder, userDAO);

        BuildingReviewsInputBoundary interactor = new BuildingReviewsInteractor(presenter, dataAccess);
        return new BuildingReviewsController(interactor);
    }
}
