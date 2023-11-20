package com.data_access;

import com.entity.building.Address;
import com.entity.building.Building;
import com.entity.building.BuildingFactory;
import com.entity.building.Location;
import com.entity.map.Marker;
import com.entity.map.MarkerFactory;
import com.google.gson.*;
import com.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BuildingDataAccessObject implements BuildingMarkerDataAccessInterface, OpenBuildingsListDataAccessInterface {

    private MarkerFactory markerFactory = null;
    private BuildingFactory buildingFactory = null;

    private final String path;

    private List<Marker> markers;
    private List<Building> buildings;

    public BuildingDataAccessObject(String path, MarkerFactory markerFactory, BuildingFactory buildingFactory) {
        this.markerFactory = markerFactory;
        this.buildingFactory = buildingFactory;

        this.path = path;

        this.markers = new ArrayList<>();
        this.buildings = new ArrayList<>();
    }

    public BuildingDataAccessObject(String path, BuildingFactory buildingFactory) {
        this.buildingFactory = buildingFactory;

        this.path = path;

        this.markers = new ArrayList<>();
        this.buildings = new ArrayList<>();
    }

    @Override
    public List<Marker> getMarkers() {
        try {
            JsonObject jsonObject = JsonParser.parseReader(new FileReader(path)).getAsJsonObject();
            JsonArray jsonArr = jsonObject.getAsJsonArray("buildings");

            for (JsonElement temp : jsonArr) {
                JsonObject b = temp.getAsJsonObject();

                String code = b.get("code").getAsString();
                String name = b.get("name").getAsString();
                String shortName = b.get("short_name").getAsString();
                String campus = b.get("campus").getAsString();
                float lat = b.get("lat").getAsFloat();
                float lon = b.get("lng").getAsFloat();

                // TODO: turn into a location builder call
                Location location = new Location(lat, lon);

                JsonObject jo = b.get("address").getAsJsonObject();
                String street = jo.get("street").getAsString();
                String city = jo.get("city").getAsString();
                String province = jo.get("province").getAsString();
                String country = jo.get("country").getAsString();
                String postal = jo.get("postal").getAsString();
                Address address = new Address(street, city, province, country, postal);

                Building building = buildingFactory.create(code, name, shortName, campus, address, null, null, location, null);
                buildings.add(building);
                markers.add(markerFactory.create(building, lat, lon));
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return markers;
    }

    @Override
    public List<Building> getBuildings() {
        try {
            JsonObject jsonObject = JsonParser.parseReader(new FileReader(path)).getAsJsonObject();
            JsonArray jsonArr = jsonObject.getAsJsonArray("buildings");

            for (JsonElement temp : jsonArr) {
                JsonObject b = temp.getAsJsonObject();

                String code = b.get("code").getAsString();
                String name = b.get("name").getAsString();
                String shortName = b.get("short_name").getAsString();
                String campus = b.get("campus").getAsString();
                float lat = b.get("lat").getAsFloat();
                float lon = b.get("lng").getAsFloat();

                // TODO: turn into a location builder call
                Location location = new Location(lat, lon);

                JsonObject jo = b.get("address").getAsJsonObject();
                String street = jo.get("street").getAsString();
                String city = jo.get("city").getAsString();
                String province = jo.get("province").getAsString();
                String country = jo.get("country").getAsString();
                String postal = jo.get("postal").getAsString();
                Address address = new Address(street, city, province, country, postal);

                Building building = buildingFactory.create(code, name, shortName, campus, address, null, null, location, null);
                buildings.add(building);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return buildings;
    }
}
