package com.interface_adapter.open_profile;

import com.use_case.open_profile.ProfileInputBoundary;

public class ProfileController {

    final ProfileInputBoundary openProfileUseCaseInteractor;

    public ProfileController(ProfileInputBoundary openProfileUseCaseInteractor) {
        this.openProfileUseCaseInteractor = openProfileUseCaseInteractor;
    }


    public void execute(int userId) {
        openProfileUseCaseInteractor.execute(userId);
    }
}
