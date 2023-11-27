package com.data_access;

import com.entity.building.Address;
import com.entity.building.Building;
import com.entity.building.BuildingFactory;
import com.entity.building.Location;
import com.entity.event.Event;
import com.entity.event.EventFactory;
import com.google.gson.*;
import com.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.use_case.open_building.OpenBuildingDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingDataAccessObject implements BuildingMarkerDataAccessInterface, OpenBuildingsListDataAccessInterface, OpenBuildingDataAccessInterface {
    private BuildingFactory buildingFactory = null;
    private EventFactory eventFactory = null;

    private final String buildingPath;
    private final String eventPath;

    private List<Building> buildings;

    public BuildingDataAccessObject(String buildingPath, String eventPath, BuildingFactory buildingFactory, EventFactory eventFactory) {
        this.buildingFactory = buildingFactory;
        this.eventFactory = eventFactory;

        this.buildingPath = buildingPath;
        this.eventPath = eventPath;

        this.buildings = new ArrayList<>();
    }

    private void getBuildingsHelper() {
        try {
            JsonObject baseJsonObj1 = JsonParser.parseReader(new FileReader(buildingPath)).getAsJsonObject();
            JsonArray buildingArr = baseJsonObj1.getAsJsonArray("buildings");

            JsonObject jsonEvents = JsonParser.parseReader(new FileReader(eventPath)).getAsJsonObject();

            for (JsonElement temp : buildingArr) {
                JsonObject b = temp.getAsJsonObject();

                // get base information
                String code = b.get("code").getAsString();
                String name = b.get("name").getAsString();
                String shortName = b.get("short_name").getAsString();
                String campus = b.get("campus").getAsString();

                // get location information
                float lat = b.get("lat").getAsFloat();
                float lon = b.get("lng").getAsFloat();;
                // TODO: turn into a location builder call
                Location location = new Location(lat, lon);

                // get address information
                JsonObject jo = b.get("address").getAsJsonObject();
                String street = jo.get("street").getAsString();
                String city = jo.get("city").getAsString();
                String province = jo.get("province").getAsString();
                String country = jo.get("country").getAsString();
                String postal = jo.get("postal").getAsString();
                // TODO: turn into builder call
                Address address = new Address(street, city, province, country, postal);

                // get events information
                List<Event> events = new ArrayList<>();
                try {
                    JsonArray eventsInBuilding = jsonEvents.get(code).getAsJsonObject().get("events").getAsJsonArray();
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
                }
                // create building
                Building building = buildingFactory.create(code, name, shortName, campus, address, null, null, location, null, events);
                // add building to event so we have 2 way connections
                for (Event event : events) {
                    event.setLocation(building);
                }

                // add finished building to list
                buildings.add(building);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Building> getBuildings() {
        // Note: The reason its in a helper was because an old version of this code
        // could return either a list of buildings or a list of markers (removed).
        // So the helper allowed the duplicate code of both to be combined.
        // But then we realized that the code was just the same and the building
        // class contained everything we needed anyways.
        getBuildingsHelper();
        return buildings;
    }

    @Override
    public Building getBuilding(String buildingCode) {
        getBuildingsHelper();
        for (int i = 0; i < buildings.size(); i ++) {
            if (buildings.get(i).getCode().equals(buildingCode)) {
                return buildings.get(i);
            }
        }
        return null;
    }
}
