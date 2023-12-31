package com.use_case.building_events;

import com.entity.event.Event;

import java.util.List;

public class BuildingEventsOutputData {
    private final List<Event> events;

    public BuildingEventsOutputData(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
