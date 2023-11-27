package com.app;

import com.data_access.BuildingDataAccessObject;
import com.data_access.EventDataAccessObject;
import com.entity.building.BuildingFactory;
import com.entity.event.EventFactory;
import com.interface_adapter.event.AddEventController;
import com.interface_adapter.event.AddEventPresenter;
import com.interface_adapter.marker.MarkerController;
import com.interface_adapter.marker.MarkerPresenter;
import com.use_case.add_event.AddEventDataAccessInterface;
import com.use_case.add_event.AddEventInputBoundary;
import com.use_case.add_event.AddEventInteractor;
import com.use_case.add_event.AddEventOutputBoundary;
import com.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.use_case.display_markers.MarkerInputBoundary;
import com.use_case.display_markers.MarkerInteractor;
import com.use_case.display_markers.MarkerOutputBoundary;
import com.view.Events.AddEventServlet;
import com.view.MainMap.MarkerServlet;

public class AddEventSetup {
    public static AddEventController setup(AddEventServlet servlet) {
        AddEventOutputBoundary presenter = new AddEventPresenter(servlet);

        String eventPath = "C:\\Users\\liamc\\IdeaProjects\\UniVerse\\external-data\\events.json";
        AddEventDataAccessInterface dataAccess = new EventDataAccessObject(eventPath);

        AddEventInputBoundary interactor = new AddEventInteractor(presenter, dataAccess);
        return new AddEventController(interactor);
    }
}
