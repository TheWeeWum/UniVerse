package com.app;

import com.data_access.BuildingDataAccessObject;
import com.entity.building.BuildingFactory;
import com.entity.event.EventFactory;
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

        BuildingFactory buildingFactory = new BuildingFactory();
        EventFactory eventFactory = new EventFactory();
        String buildingPath = "C:\\Users\\evan_\\Documents\\UofT\\year2\\csc207\\IdeaProjects\\UniVerse\\src\\main\\webapp\\js\\buildings.js";
        String eventPath = "C:\\Users\\evan_\\Documents\\UofT\\year2\\csc207\\IdeaProjects\\UniVerse\\src\\main\\webapp\\js\\events.js";
        BuildingMarkerDataAccessInterface dataAccess = new BuildingDataAccessObject(buildingPath, eventPath, buildingFactory, eventFactory);

        MarkerInputBoundary interactor = new MarkerInteractor(presenter, dataAccess);
        return new MarkerController(interactor);
    }
}
