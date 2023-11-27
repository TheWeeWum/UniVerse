package com.use_case.add_event;

import org.w3c.dom.html.HTMLImageElement;

import java.util.Date;

public class AddEventInputData {
    private String title;
    private String organizer;
    private Date time;
    private String description;

    public AddEventInputData(String title, String organizer, Date time, String description) {
        this.title = title;
        this.organizer = organizer;
        this.time = time;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public String getOrganizer() {
        return organizer;
    }
    public Date getTime() {
        return time;
    }
    public String getDescription() {
        return description;
    }

}
