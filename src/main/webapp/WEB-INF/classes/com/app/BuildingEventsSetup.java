package com.app;

import com.data_access.EventDataAccessObject;
import com.entity.event.EventFactory;
import com.interface_adapter.event.BuildingEventsController;
import com.interface_adapter.event.BuildingEventsPresenter;
import com.use_case.buildingEvents.BuildingEventsDataAccessInterface;
import com.use_case.buildingEvents.BuildingEventsInputBoundary;
import com.use_case.buildingEvents.BuildingEventsInteractor;
import com.use_case.buildingEvents.BuildingEventsOutputBoundary;
import com.view.Events.BuildingEventsServlet;

public class BuildingEventsSetup {
    public static BuildingEventsController setup(BuildingEventsServlet buildingsEventsServlet) {
        BuildingEventsOutputBoundary presenter = new BuildingEventsPresenter(buildingsEventsServlet);

        EventFactory eventFactory = new EventFactory();
        String eventPath = "/Users/raonkim/IdeaProjects/UniVerse/external-data/events.json";
        BuildingEventsDataAccessInterface dataAccess = new EventDataAccessObject(eventPath, eventFactory);

        BuildingEventsInputBoundary interactor = new BuildingEventsInteractor(presenter, dataAccess);
        return new BuildingEventsController(interactor);
    }
}
