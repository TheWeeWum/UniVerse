package com.app;

import com.data_access.EventDataAccessObject;
import com.data_access.Path;
import com.entity.event.EventBuilder;
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

        EventBuilder eventBuilder = new EventBuilder();
        String eventPath = Path.path + "external-data\\events.json";
        BuildingEventsDataAccessInterface dataAccess = new EventDataAccessObject(eventPath, eventBuilder);

        BuildingEventsInputBoundary interactor = new BuildingEventsInteractor(presenter, dataAccess);
        return new BuildingEventsController(interactor);
    }
}
