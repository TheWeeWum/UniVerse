package com.entity.event;

import com.entity.Reviewable;

import java.util.Date;

public class EventFactory {
    public Event create(String name, String organizer, Reviewable location, Date date) {
        return new Event(name, organizer, location, date);
    }
}
