package com.entity.event;

import com.entity.Reviewable;

import java.util.Date;

public class Event {
    private final String name;
    private final String organizer;
    private Reviewable location;
    private final Date date;

    // TODO: Only if we have time
    // private List<User> attendies;

    public Event(String name, String organizer, Reviewable location, Date date) {
        this.name = name;
        this.organizer = organizer;
        this.location = location;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public Reviewable getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public void setLocation(Reviewable location) {
        this.location = location;
    }
}
