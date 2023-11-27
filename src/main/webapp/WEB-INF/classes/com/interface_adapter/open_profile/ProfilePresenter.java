package com.interface_adapter.open_profile;

import com.use_case.open_profile.ProfileOutputBoundary;
import com.use_case.open_profile.ProfileOutputData;
import com.view.UserProfileServlet;

public class ProfilePresenter implements ProfileOutputBoundary {
    UserProfileServlet userProfileServlet;

    public ProfilePresenter(UserProfileServlet userProfileServlet) {

        this.userProfileServlet = userProfileServlet;
    }


    @Override
    public void prepareSuccessView(ProfileOutputData user) {

    }

    @Override
    public void prepareGuestView() {

    }
}
