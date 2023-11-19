package com.entity.map;

import com.entity.building.Building;

public class MarkerFactory {
    public Marker create(Building building, float latitude, float longitude) {
        return new Marker(building, latitude, longitude);
    }
}
