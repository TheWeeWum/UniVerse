package com.app;

import com.data_access.BuildingDataAccessObject;
import com.entity.building.BuildingBuilder;
import com.entity.event.EventBuilder;
import com.interface_adapter.marker.MarkerController;
import com.interface_adapter.marker.MarkerPresenter;
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
        String buildingPath = "C:\\Users\\liamc\\IdeaProjects\\UniVerse\\external-data\\buildings.json";
        String eventPath = "C:\\Users\\liamc\\IdeaProjects\\UniVerse\\external-data\\events.json";
        BuildingMarkerDataAccessInterface dataAccess = new BuildingDataAccessObject(buildingPath, eventPath, buildingBuilder, eventBuilder);

        MarkerInputBoundary interactor = new MarkerInteractor(presenter, dataAccess);
        return new MarkerController(interactor);
    }
}
