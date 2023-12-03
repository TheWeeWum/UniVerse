package com.app;

import com.data_access.BuildingDataAccessObject;
import com.data_access.BuildingReviewDataAccessObject;
import com.data_access.FileUserDataAccessObject;
import com.data_access.Path;
import com.entity.building.BuildingBuilder;
import com.entity.event.EventBuilder;
import com.entity.review.ReviewBuilder;
import com.interface_adapter.marker.MarkerController;
import com.interface_adapter.marker.MarkerPresenter;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.use_case.display_markers.MarkerInputBoundary;
import com.use_case.display_markers.MarkerInteractor;
import com.use_case.display_markers.MarkerOutputBoundary;
import com.view.MainMap.MarkerServlet;

public class MarkerSetup {
    public static MarkerController setup(MarkerServlet markerServlet) {
        MarkerOutputBoundary presenter = new MarkerPresenter(markerServlet);

        BuildingBuilder buildingBuilder = new BuildingBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = Path.path + "external-data\\events.json";
        String reviewPath = Path.path + "external-data\\buildingreviews.json";

        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();
        BuildingReviewsDataAccessInterface buildingReviewDAO = new BuildingReviewDataAccessObject(reviewPath, new ReviewBuilder(), userDAO);
        BuildingMarkerDataAccessInterface dataAccess = new BuildingDataAccessObject(buildingPath, eventPath, buildingBuilder, eventBuilder, buildingReviewDAO);

        MarkerInputBoundary interactor = new MarkerInteractor(presenter, dataAccess);
        return new MarkerController(interactor);
    }
}
