package com.interface_adapter.event;

import com.use_case.buildingEvents.BuildingEventsInputBoundary;
import com.use_case.buildingEvents.BuildingEventsInputData;
import com.use_case.display_markers.MarkerInputBoundary;

public class BuildingEventsController {
    BuildingEventsInputBoundary interactor;
    public BuildingEventsController(BuildingEventsInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String buildingCode) {
        BuildingEventsInputData inputData = new BuildingEventsInputData(buildingCode);
        interactor.execute(inputData);
    }
}
