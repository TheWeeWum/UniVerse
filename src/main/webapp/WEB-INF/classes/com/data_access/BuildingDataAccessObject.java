package com.data_access;

import com.entity.building.Building;
import com.entity.building.BuildingFactory;
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
        // TODO Auto-generated method stub
        try {
            JsonObject jsonObject = JsonParser.parseReader(new FileReader(path)).getAsJsonObject();
            JsonArray jsonArr = jsonObject.getAsJsonArray("buildings");

            for (JsonElement temp : jsonArr) {
                JsonObject b = temp.getAsJsonObject();
                float lat = b.get("lat").getAsFloat();
                float lon = b.get("lng").getAsFloat();
                String name = b.get("name").getAsString();
                // TODO: Fix this, probably need to create an address class
                // Or at least parse this properly
                // String address = b.get("address").getAsString();;

                Building building = buildingFactory.create(name, "address");
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
                String name = b.get("name").getAsString();
                // TODO: Fix this, probably need to create an address class
                // Or at least parse this properly
                // String address = b.get("address").getAsString();;

                Building building = buildingFactory.create(name, "address");
                buildings.add(building);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return buildings;
    }
}
