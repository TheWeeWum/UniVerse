package com.data_access;

import com.entity.event.Event;
import com.entity.event.EventFactory;
import com.google.gson.*;
import com.use_case.add_event.AddEventDataAccessInterface;
import com.use_case.building_events.BuildingEventsDataAccessInterface;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDataAccessObject implements BuildingEventsDataAccessInterface, AddEventDataAccessInterface {
    private EventFactory eventFactory = null;

    private final String eventPath;

    public EventDataAccessObject(String eventPath, EventFactory eventFactory) {
        this.eventFactory = eventFactory;

        this.eventPath = eventPath;
    }

    public EventDataAccessObject(String eventPath) {
        this.eventPath = eventPath;
    }

    @Override
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
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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

    @Override
    public void addEvent(String buildingCode, String title, String organizer, String room, Date time, String description) {
        try {
            Object obj = JsonParser.parseReader(new FileReader(eventPath));

            JsonObject mainObject = (JsonObject) obj;

            JsonObject event = new JsonObject();
            event.addProperty("building", buildingCode);
            event.addProperty("room", room);
            event.addProperty("name", title);
            event.addProperty("organizer", organizer);

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String timeAsString = df.format(time);
            event.addProperty("date", timeAsString);

            event.addProperty("description", description);


            JsonObject building = new JsonObject();
            try {
                building = mainObject.get("buildingCode").getAsJsonObject();
            } catch (NullPointerException e) {
                // building did not exist
                mainObject.add(buildingCode, building);
                building = mainObject.get(buildingCode).getAsJsonObject();
            }
            JsonArray events = new JsonArray();
            try {
                events = building.get("events").getAsJsonArray();
            } catch (NullPointerException e) {
                // events didn't exist
                building.add("events", events);
                events = building.get("events").getAsJsonArray();
            }
            events.add(event);

            Gson gson = new Gson();
            FileWriter file = new FileWriter(eventPath);
            file.write(gson.toJson(mainObject));
            file.flush();
            file.close();


        } catch (IOException e) {
            System.out.println("Could not read Event JsonFile in addEvent (EventDataAccessObject)");
        }
    }
}
