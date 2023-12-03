package com.app;

import com.data_access.*;
import com.entity.building.BuildingBuilder;
import com.entity.event.EventBuilder;
import com.entity.review.ReviewBuilder;
import com.interface_adapter.open_profile.ProfileController;
import com.interface_adapter.open_profile.ProfilePresenter;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.use_case.open_profile.ProfileInputBoundary;
import com.use_case.open_profile.ProfileInteractor;
import com.use_case.open_profile.ProfileOutputBoundary;
import com.use_case.open_profile.ProfileUserDataAccessInterface;
import com.view.User.UserProfileServlet;

public class ProfileSetup {

    public static ProfileController setup(UserProfileServlet userProfileServlet) {
        ProfileOutputBoundary presenter = new ProfilePresenter(userProfileServlet);

        String userPath = Path.path + "external-data\\UserDataBase.json";
        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = "external-data\\events.json";
        String reviewPath = Path.path + "external-data\\buildingreviews.json";

        BuildingBuilder buildingBuilder = new BuildingBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        ReviewBuilder reviewBuilder = new ReviewBuilder();

        BuildingReviewsDataAccessInterface reviewdataAccess = new BuildingReviewDataAccessObject(reviewPath, reviewBuilder, userDAO);
        BuildingDataAccessObject dataAccessBuilding = new BuildingDataAccessObject(buildingPath, eventPath, buildingBuilder, eventBuilder, reviewdataAccess);
        ProfileUserDataAccessInterface dataAccess = new ProfileDataAccessObject(userPath, userDAO, reviewBuilder, dataAccessBuilding);

        ProfileInputBoundary interactor = new ProfileInteractor(dataAccess, presenter);
        return new ProfileController(interactor);
    }
}
