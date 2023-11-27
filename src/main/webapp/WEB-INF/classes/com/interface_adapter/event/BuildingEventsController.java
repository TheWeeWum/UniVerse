package com.interface_adapter.event;

import com.use_case.building_events.BuildingEventsInputBoundary;
import com.use_case.building_events.BuildingEventsInputData;

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
