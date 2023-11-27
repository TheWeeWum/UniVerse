package com.use_case.building_reviews;

import com.entity.review.Review;

import java.util.List;

public class BuildingReviewsInteractor implements BuildingReviewsInputBoundary {
    BuildingReviewsOutputBoundary buildingReviewsPresenter;
    BuildingReviewsDataAccessInterface dataAccessObject;

    public BuildingReviewsInteractor(BuildingReviewsOutputBoundary buildingReviewsPresenter, BuildingReviewsDataAccessInterface dataAccessObject) {
        this.buildingReviewsPresenter = buildingReviewsPresenter;
        this.dataAccessObject = dataAccessObject;
    }
    @Override
    public void execute(BuildingReviewsInputData buildingReviewsInputData) {
        // No input data

        // get reviews from the database
        List<Review> reviews = dataAccessObject.getReviews(buildingReviewsInputData.getBuildingCode());

        // compile into an output data object
        BuildingReviewsOutputData buildingReviewsOutputData = new BuildingReviewsOutputData(reviews);

        // set back up the chain
        buildingReviewsPresenter.prepareSuccessView(buildingReviewsOutputData);
    }
}
