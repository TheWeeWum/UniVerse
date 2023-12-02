package com.use_case.add_event;

import java.util.Date;

public interface AddEventDataAccessInterface {
    void addEvent(String buildingCode, String title, String organizer, String room, Date time, String description);
}
