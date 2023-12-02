package com.app;

import com.data_access.BuildingDataAccessObject;
import com.data_access.FileUserDataAccessObject;
import com.data_access.Path;
import com.data_access.ProfileDataAccessObject;
import com.entity.building.BuildingFactory;
import com.entity.event.EventFactory;
import com.entity.review.ReviewFactory;
import com.interface_adapter.open_profile.ProfileController;
import com.interface_adapter.open_profile.ProfilePresenter;
import com.use_case.open_profile.ProfileInputBoundary;
import com.use_case.open_profile.ProfileInteractor;
import com.use_case.open_profile.ProfileOutputBoundary;
import com.use_case.open_profile.ProfileUserDataAccessInterface;
import com.view.User.UserProfileServlet;

public class ProfileSetup {

    public static ProfileController setup(UserProfileServlet userProfileServlet) {
        ProfileOutputBoundary presenter = new ProfilePresenter(userProfileServlet);
        ReviewFactory reviewFactory = new ReviewFactory();
        String userPath = Path.path + "external-data\\UserDataBase.json";
        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();
        BuildingFactory buildingFactory = new BuildingFactory();
        EventFactory eventFactory = new EventFactory();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = "events.json";
        BuildingDataAccessObject dataAccessBuilding = new BuildingDataAccessObject(buildingPath, eventPath, buildingFactory, eventFactory);
        ProfileUserDataAccessInterface dataAccess = new ProfileDataAccessObject(userPath, userDAO, reviewFactory, dataAccessBuilding);
        ProfileInputBoundary interactor = new ProfileInteractor(dataAccess, presenter);
        return new ProfileController(interactor);
    }
}
