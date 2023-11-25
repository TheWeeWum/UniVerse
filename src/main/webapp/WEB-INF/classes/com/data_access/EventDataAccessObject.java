package com.data_access;

import com.entity.building.Address;
import com.entity.building.Building;
import com.entity.building.BuildingFactory;
import com.entity.building.Location;
import com.entity.event.Event;
import com.entity.event.EventFactory;
import com.google.gson.*;
import com.use_case.buildingEvents.BuildingEventsDataAccessInterface;
import com.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDataAccessObject implements BuildingEventsDataAccessInterface {
    private EventFactory eventFactory = null;

    private final String eventPath;

    public EventDataAccessObject(String eventPath, EventFactory eventFactory) {
        this.eventFactory = eventFactory;

        this.eventPath = eventPath;
    }

    public List<Event> getEvents(String buildingCode) {
        List<Event> events = new ArrayList<>();
        try {
            JsonObject jsonEvents = JsonParser.parseReader(new FileReader(eventPath)).getAsJsonObject();
            try {
                JsonArray eventsInBuilding = jsonEvents.get(buildingCode).getAsJsonObject().get("events").getAsJsonArray();
                for (JsonElement eventElement : eventsInBuilding) {
                    JsonObject eo = eventElement.getAsJsonObject();
                    String ename = eo.get("name").getAsString();
                    String organizer = eo.get("organizer").getAsString();
                    String dateStr = eo.get("date").getAsString();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = sdf.parse(dateStr);
                    Event event = eventFactory.create(ename, organizer, null, date);
                    events.add(event);
                }
            } catch (NullPointerException e) {
                // event list was hopefully empty
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return events;
    }
}
