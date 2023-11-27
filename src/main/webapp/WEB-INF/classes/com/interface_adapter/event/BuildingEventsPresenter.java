package com.interface_adapter.event;

import com.use_case.building_events.BuildingEventsOutputBoundary;
import com.use_case.building_events.BuildingEventsOutputData;
import com.view.Events.BuildingEventsServlet;

public class BuildingEventsPresenter implements BuildingEventsOutputBoundary {
    BuildingEventsServlet buildingEventsServlet;

    public BuildingEventsPresenter(BuildingEventsServlet buildingEventsServlet) {
        this.buildingEventsServlet = buildingEventsServlet;
    }

    @Override
    public void execute(BuildingEventsOutputData outputData) {
        buildingEventsServlet.displayEvents(outputData);
    }
}
