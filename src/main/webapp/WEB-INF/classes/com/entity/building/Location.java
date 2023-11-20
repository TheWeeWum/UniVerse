package com.entity.building;


// This is to be the class to have the polygon
// locations of each building should we choose to do that
public class Location {
    private final float lat;
    private final float lon;

    public Location(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public float getLatitude() {
        return lat;
    }

    public float getLongitude() {
        return lon;
    }
}
