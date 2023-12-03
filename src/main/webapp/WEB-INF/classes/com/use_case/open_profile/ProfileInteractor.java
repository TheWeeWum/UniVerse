package com.use_case.open_profile;


import com.data_access.FileUserDataAccessObject;
import com.entity.user.LoggedInUser;

public class ProfileInteractor implements ProfileInputBoundary{

    final ProfileOutputBoundary profilePresenter;

    final ProfileUserDataAccessInterface profileDataAccessObject;

    final FileUserDataAccessObject userDataAccessObject;
    public ProfileInteractor(ProfileUserDataAccessInterface profileDataAccessObject, ProfileOutputBoundary profileOutputBoundary, FileUserDataAccessObject userDataAccessObject){
        this.profilePresenter = profileOutputBoundary;
        this.profileDataAccessObject = profileDataAccessObject;
        this.userDataAccessObject = userDataAccessObject;
    }

    @Override
    public void execute(int userID) {
        // no input data

        // get output data
        // LoggedInUser user = profileDataAccessObject.getUser(userID);
        LoggedInUser user = userDataAccessObject.getAccounts().get(userID);

        // create output object
        ProfileOutputData profile = new ProfileOutputData(user);
        profilePresenter.prepareSuccessView(profile);
    }
}
