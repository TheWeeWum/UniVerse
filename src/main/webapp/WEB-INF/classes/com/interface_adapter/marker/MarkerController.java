package com.interface_adapter.marker;

import com.use_case.display_markers.MarkerInputBoundary;

public class MarkerController {
    MarkerInputBoundary interactor;
    public MarkerController(MarkerInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute() {
        System.out.println("MarkerController");
        interactor.execute();
    }
}
