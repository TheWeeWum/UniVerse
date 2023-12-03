package com.use_case.building_events;

import com.entity.event.Event;

import java.util.List;

public class BuildingEventsInteractor implements BuildingEventsInputBoundary {
    BuildingEventsOutputBoundary buildingEventsPresenter;
    BuildingEventsDataAccessInterface dataAccess;

    public BuildingEventsInteractor(BuildingEventsOutputBoundary buildingEventsPresenter, BuildingEventsDataAccessInterface dataAccess) {
        this.buildingEventsPresenter = buildingEventsPresenter;
        this.dataAccess = dataAccess;
    }

    @Override
    public void execute(BuildingEventsInputData inputData) {
        // No input data

        // get the events from the database (They do not contain the building objects)
        List<Event> events = dataAccess.getEvents(inputData.getBuildingCode());

        // compile into an output data object
        BuildingEventsOutputData outputData = new BuildingEventsOutputData(events);

        // set back up the chain
        buildingEventsPresenter.execute(outputData);
    }
}
