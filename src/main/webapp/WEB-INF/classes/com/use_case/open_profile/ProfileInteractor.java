package com.use_case.open_profile;

import com.entity.Reviewable;
import com.entity.user.User;

public class ProfileInteractor implements ProfileInputBoundary{

    final ProfileOutputBoundary profilePresenter;

    final ProfileUserDataAccessInterface profileDataAccessObject;

    public ProfileInteractor(ProfileUserDataAccessInterface profileDataAccessObject, ProfileOutputBoundary profileOutputBoundary){
        this.profilePresenter = profileOutputBoundary;
        this.profileDataAccessObject = profileDataAccessObject;
    }

    @Override
    public void execute() {
        // no input data

        // get output data
        User user = profileDataAccessObject.get();

        ProfileOutputData profile = new ProfileOutputData(user);

        profilePresenter.prepareSuccessView(profile);

    }
}
