package com.app;

import com.data_access.BuildingDataAccessObject;
import com.data_access.BuildingReviewDataAccessObject;
import com.data_access.FileUserDataAccessObject;
import com.data_access.Path;
import com.entity.building.BuildingBuilder;
import com.entity.event.Event;
import com.entity.event.EventBuilder;
import com.entity.review.ReviewBuilder;
import com.interface_adapter.open_building.OpenBuildingController;
import com.interface_adapter.open_building.OpenBuildingPresenter;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.use_case.open_building.OpenBuildingDataAccessInterface;
import com.use_case.open_building.OpenBuildingInputBoundary;
import com.use_case.open_building.OpenBuildingInteractor;
import com.use_case.open_building.OpenBuildingOutputBoundary;
import com.view.Building.BuildingInfoServlet;

public class BuildingSetup {
    public static OpenBuildingController setup(BuildingInfoServlet buildingInfoServlet) {
        OpenBuildingOutputBoundary presenter = new OpenBuildingPresenter(buildingInfoServlet);

        BuildingBuilder buildingBuilder = new BuildingBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        ReviewBuilder reviewBuilder = new ReviewBuilder();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = Path.path + "external-data\\events.json";
        String reviewPath = Path.path + "external-data\\buildingreviews.json";

        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();

        BuildingReviewsDataAccessInterface reviewDataAccessObject = new BuildingReviewDataAccessObject(reviewPath, reviewBuilder, userDAO);
        OpenBuildingDataAccessInterface dataAccess = new BuildingDataAccessObject(buildingPath,eventPath, buildingBuilder, eventBuilder, reviewDataAccessObject);

        OpenBuildingInputBoundary interactor = new OpenBuildingInteractor(dataAccess, presenter);
        return new OpenBuildingController(interactor);
    }
}
