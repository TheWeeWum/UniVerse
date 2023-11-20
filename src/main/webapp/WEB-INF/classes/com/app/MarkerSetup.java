package com.app;

import com.data_access.BuildingDataAccessObject;
import com.entity.building.BuildingFactory;
import com.entity.map.MarkerFactory;
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

        MarkerFactory markerFactory = new MarkerFactory();
        BuildingFactory buildingFactory = new BuildingFactory();
        BuildingMarkerDataAccessInterface dataAccess = new BuildingDataAccessObject("/Users/raonkim/IdeaProjects/UniVerse/external-data/buildings.json", markerFactory, buildingFactory);

        MarkerInputBoundary interactor = new MarkerInteractor(presenter, dataAccess);
        return new MarkerController(interactor);
    }
}
