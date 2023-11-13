package com.use_case.open_profile;

public interface ProfileOutputBoundary {
    void prepareGuestView();

    void prepareUserView(ProfileOutputData user);
}
