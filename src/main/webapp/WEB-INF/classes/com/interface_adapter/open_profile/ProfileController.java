package com.interface_adapter.open_profile;

import com.use_case.open_myreviews.OpenReviewInputBoundary;

public class ProfileController {

    final OpenReviewInputBoundary openReviewsUseCaseInteractor;

    public ProfileController(OpenReviewInputBoundary openReviewsUseCaseInteractor) {
        this.openReviewsUseCaseInteractor = openReviewsUseCaseInteractor;
    }


    public void execute() {
        openReviewsUseCaseInteractor.execute();
    }
}
