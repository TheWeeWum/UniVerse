package com.app;

import com.data_access.EventDataAccessObject;
import com.entity.event.EventFactory;
import com.interface_adapter.event.BuildingEventsController;
import com.interface_adapter.event.BuildingEventsPresenter;
import com.use_case.building_events.BuildingEventsDataAccessInterface;
import com.use_case.building_events.BuildingEventsInputBoundary;
import com.use_case.building_events.BuildingEventsInteractor;
import com.use_case.building_events.BuildingEventsOutputBoundary;
import com.view.Events.BuildingEventsServlet;

public class BuildingEventsSetup {
    public static BuildingEventsController setup(BuildingEventsServlet buildingsEventsServlet) {
        BuildingEventsOutputBoundary presenter = new BuildingEventsPresenter(buildingsEventsServlet);

        EventFactory eventFactory = new EventFactory();
        String eventPath = "C:\\Users\\evan_\\Documents\\UofT\\year2\\csc207\\IdeaProjects\\UniVerse\\src\\main\\webapp\\js\\events.js";
        BuildingEventsDataAccessInterface dataAccess = new EventDataAccessObject(eventPath, eventFactory);

        BuildingEventsInputBoundary interactor = new BuildingEventsInteractor(presenter, dataAccess);
        return new BuildingEventsController(interactor);
    }
}
