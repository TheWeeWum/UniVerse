package com.use_case.open_myreviews;

import com.entity.building.Building;
import com.entity.review.Review;


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
    public void execute() {
        // no input data
        // get reviews from database
        List<Review> reviews = openReviewDataAccessObject.getReviews();

        // compile into output data
        OpenReviewOutputData openReviewOutputData = new OpenReviewOutputData();
        openReviewPresenter.prepareSuccessView(openReviewOutputData);
    }
}
