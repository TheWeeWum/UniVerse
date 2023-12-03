package com.app;

import com.data_access.EventDataAccessObject;
import com.data_access.Path;
import com.interface_adapter.event.AddEventController;
import com.interface_adapter.event.AddEventPresenter;
import com.use_case.add_event.AddEventDataAccessInterface;
import com.use_case.add_event.AddEventInputBoundary;
import com.use_case.add_event.AddEventInteractor;
import com.use_case.add_event.AddEventOutputBoundary;
import com.view.Events.AddEventServlet;

public class AddEventSetup {
    public static AddEventController setup(AddEventServlet servlet) {
        AddEventOutputBoundary presenter = new AddEventPresenter(servlet);

        String eventPath = Path.path + "external-data/events.json";
        AddEventDataAccessInterface dataAccess = new EventDataAccessObject(eventPath);

        AddEventInputBoundary interactor = new AddEventInteractor(presenter, dataAccess);
        return new AddEventController(interactor);
    }
}
