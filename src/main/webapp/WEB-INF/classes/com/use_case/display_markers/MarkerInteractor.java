package com.use_case.display_markers;

import com.data_access.BuildingDataAccessObject;
import com.use_case.signup.SignupOutputBoundary;
import com.entity.map.Marker;

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
        List<Marker> markers = dataAccess.getMarkers();

        // compile into a output data object
        MarkerOutputData outputData = new MarkerOutputData(markers);

        // set back up the chain
        markerPresenter.execute(outputData);
    }
}
