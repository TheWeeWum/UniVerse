package com.use_case.open_myreviews;

import com.entity.building.Building;
import com.entity.review.Review;
import com.use_case.building_reviews.BuildingReviewsOutputData;


import java.util.List;

public class OpenReviewInteractor implements OpenReviewInputBoundary{
    final OpenReviewDataAccessInterface openReviewDataAccessObject;
    final OpenReviewOutputBoundary openReviewPresenter;

    public OpenReviewInteractor(OpenReviewDataAccessInterface openReviewDataAccessObject,
                                OpenReviewOutputBoundary openReviewPresenter) {
        this.openReviewDataAccessObject = openReviewDataAccessObject;
        this.openReviewPresenter = openReviewPresenter;
    }
    @Override
    public void execute(OpenReviewInputData userReviewInputData) {
        System.out.println("ORI");

        // get reviews from the database
        List<Review> reviews = openReviewDataAccessObject.getReviews(userReviewInputData.getUserID());

        System.out.println(reviews);
        // compile into an output data object
        OpenReviewOutputData userReviewsOutputData = new OpenReviewOutputData(reviews);

        // set back up the chain
        openReviewPresenter.prepareSuccessView(userReviewsOutputData);
    }
}
