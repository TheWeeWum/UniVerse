package com.use_case.open_profile;


import com.entity.user.LoggedInUser;

public class ProfileInteractor implements ProfileInputBoundary{

    final ProfileOutputBoundary profilePresenter;

    final ProfileUserDataAccessInterface profileDataAccessObject;

    public ProfileInteractor(ProfileUserDataAccessInterface profileDataAccessObject, ProfileOutputBoundary profileOutputBoundary){
        this.profilePresenter = profileOutputBoundary;
        this.profileDataAccessObject = profileDataAccessObject;
    }

    @Override
    public void execute(int userID) {
        // no input data

        // get output data
        LoggedInUser user = profileDataAccessObject.getUser(userID);

        // create output object
        ProfileOutputData profile = new ProfileOutputData(user);
        profilePresenter.prepareSuccessView(profile);
    }
}
