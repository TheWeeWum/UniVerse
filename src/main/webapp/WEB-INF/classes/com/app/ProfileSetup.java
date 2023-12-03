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
        ReviewBuilder reviewFactory = new ReviewBuilder();
        String userPath = Path.path + "external-data/UserDataBase.json";
        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();
        BuildingBuilder buildingFactory = new BuildingBuilder();
        EventBuilder eventFactory = new EventBuilder();
        String buildingPath = Path.path + "external-data/buildings.json";
        String eventPath = "events.json";
        ReviewBuilder reviewBuilder = new ReviewBuilder();
        String reviewPath = Path.path + "external-data/buildingreviews.json";
        BuildingReviewsDataAccessInterface reviewdataAccess = new BuildingReviewDataAccessObject(reviewPath, reviewBuilder, userDAO);
        BuildingDataAccessObject dataAccessBuilding = new BuildingDataAccessObject(buildingPath, eventPath, buildingFactory, eventFactory, reviewdataAccess);
        ProfileUserDataAccessInterface dataAccess = new ProfileDataAccessObject(userPath, userDAO, reviewFactory, dataAccessBuilding);
        ProfileInputBoundary interactor = new ProfileInteractor(dataAccess, presenter);
        return new ProfileController(interactor);
    }
}
