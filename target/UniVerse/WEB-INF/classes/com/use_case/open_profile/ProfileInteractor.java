package com.use_case.open_profile;

public class ProfileInteractor implements ProfileInputBoundary{

    final ProfileOutputBoundary profilePresenter;

    final ProfileUserDataAccessInterface profileDataAccessObject;

    public ProfileInteractor(ProfileUserDataAccessInterface profileDataAccessObject, ProfileOutputBoundary profileOutputBoundary){
        this.profilePresenter = profileOutputBoundary;
        this.profileDataAccessObject = profileDataAccessObject;
    }

    @Override
    public void execute(){

    }
}
