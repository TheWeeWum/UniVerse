package com.interface_adapter.event;

import com.use_case.add_event.AddEventOutputBoundary;
import com.use_case.add_event.AddEventOutputData;
import com.use_case.building_events.BuildingEventsOutputBoundary;
import com.use_case.building_events.BuildingEventsOutputData;
import com.view.Events.AddEventServlet;
import com.view.Events.BuildingEventsServlet;

public class AddEventPresenter implements AddEventOutputBoundary {
    AddEventServlet servlet;

    public AddEventPresenter(AddEventServlet servlet) {
        this.servlet = servlet;
    }

    @Override
    public void execute(AddEventOutputData outputData) {
        servlet.successView(outputData);
    }
}
