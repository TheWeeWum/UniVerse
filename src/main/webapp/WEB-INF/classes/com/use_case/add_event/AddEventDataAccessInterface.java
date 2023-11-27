package com.use_case.add_event;

import java.util.Date;

public interface AddEventDataAccessInterface {
    void addEvent(String title, String organizer, Date time, String description);
}
