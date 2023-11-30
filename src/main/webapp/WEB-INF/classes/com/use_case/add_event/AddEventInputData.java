package com.use_case.add_event;

import org.w3c.dom.html.HTMLImageElement;

import java.util.Date;

public class AddEventInputData {
    private final String buildingCode;
    private final String title;
    private final String organizer;
    private final String room;
    private final Date time;
    private final String description;

    public AddEventInputData(String buildingCode, String title, String organizer, String room, Date time, String description) {
        this.buildingCode = buildingCode;
        this.title = title;
        this.organizer = organizer;
        this.room = room;
        this.time = time;
        this.description = description;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public String getTitle() {
        return title;
    }

    public String getOrganizer() {
        return organizer;
    }
    public String getRoom() {
        return room;
    }

    public Date getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
}
