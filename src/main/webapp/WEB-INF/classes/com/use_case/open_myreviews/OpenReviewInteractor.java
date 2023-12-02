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
    public void execute(OpenReviewInputData userReviewInputData) {

        // get reviews from database
        int userID= userReviewInputData.getUserID();

        // compile into output data
        OpenReviewOutputData openReviewOutputData = new OpenReviewOutputData(userID);
        openReviewPresenter.prepareSuccessView(openReviewOutputData);
    }
}
