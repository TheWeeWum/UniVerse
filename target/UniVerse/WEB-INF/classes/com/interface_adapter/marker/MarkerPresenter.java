package com.interface_adapter.marker;

import com.use_case.display_markers.MarkerOutputBoundary;
import com.use_case.display_markers.MarkerOutputData;
import com.use_case.signup.SignupOutputBoundary;
import com.view.MarkerServlet;

import java.io.IOException;

public class MarkerPresenter implements MarkerOutputBoundary {
    MarkerServlet markerServlet;

    public MarkerPresenter(MarkerServlet markerServlet) {
        this.markerServlet = markerServlet;
    }

    @Override
    public void execute(MarkerOutputData outputData) {
        markerServlet.writeMarkers(outputData);
    }
}
