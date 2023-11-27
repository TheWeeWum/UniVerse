package com.use_case.building_events;

import com.entity.event.Event;

import java.util.List;

public interface BuildingEventsDataAccessInterface {
    public List<Event> getEvents(String buildingCode);
}
