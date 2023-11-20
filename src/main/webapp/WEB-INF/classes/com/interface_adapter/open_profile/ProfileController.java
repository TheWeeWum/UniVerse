package com.interface_adapter.open_profile;

import com.use_case.open_profile.ProfileInputBoundary;

public class ProfileController {
    final ProfileInputBoundary profileUseCaseInteractor;

    public ProfileController(ProfileInputBoundary profileUseCaseInteractor){
        this.profileUseCaseInteractor = profileUseCaseInteractor;
    }
    public void execute() {

    }
}
