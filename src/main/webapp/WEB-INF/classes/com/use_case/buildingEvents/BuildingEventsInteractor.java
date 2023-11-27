package com.use_case.buildingEvents;

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

        // get the markers from the database
        List<Event> events = dataAccess.getEvents(inputData.getBuildingCode());

        // compile into a output data object
        BuildingEventsOutputData outputData = new BuildingEventsOutputData(events);

        // set back up the chain
        buildingEventsPresenter.execute(outputData);
    }
}
