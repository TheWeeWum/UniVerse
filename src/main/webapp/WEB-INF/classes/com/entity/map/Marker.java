package com.entity.map;

import com.entity.building.Building;

public class Marker {
    private final float longitude;
    private final float latitude;
    private final Building building;

    public Marker(Building building, float latitude, float longitude) {
        this.building = building;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public Building getBuilding() {
        return building;
    }
}
