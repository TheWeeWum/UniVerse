package com.entity.event;

import com.entity.Reviewable;

import java.util.Date;

public class EventBuilder {
    private Event event;
    public void createEvent(String name, String organizer, Date date) {
        event = new Event(name, organizer, null, date);
    }

    public void setLocation(Reviewable location) {
        event.setLocation(location);
    }

    public Event getEvent() {
        return event;
    }
}
