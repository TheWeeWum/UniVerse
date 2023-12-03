package com.use_case.display_markers;

import com.entity.building.Building;

import java.util.List;

public class MarkerInteractor implements MarkerInputBoundary {

    MarkerOutputBoundary markerPresenter;
    BuildingMarkerDataAccessInterface dataAccess;
    public MarkerInteractor(MarkerOutputBoundary markerPresenter, BuildingMarkerDataAccessInterface dataAccess) {
        this.markerPresenter = markerPresenter;
        this.dataAccess = dataAccess;
    }

    @Override
    public void execute() {
        // No input data

        // get the markers from the database
        List<Building> buildings = dataAccess.getBuildings();
        // compile into a output data object
        MarkerOutputData outputData = new MarkerOutputData(buildings);

        // set back up the chain
        markerPresenter.execute(outputData);
    }
}
