package com.entity.map;

import com.entity.building.Building;
import com.entity.building.Location;

import java.util.ArrayList;
import java.util.List;

public class Map {
    // TODO: add image to map
    private final List<Building> buildings;

    /**
     * @param buildings the list of buildings on the map.
     */
    public Map(List<Building> buildings) {
        this.buildings = buildings;
    }

    /**
     * Gets the list of buildings on the map.
     * @return the list of buildings on the map.
     */
    public List<Building> getBuildings() {
        return buildings;
    }

    /**
     * Gets the building at the specified name.
     *
     * @param name the name of the building.
     * @return the building at that name.
     */
    public Building getBuilding(String name) {
        for (Building building : buildings) {
            if (building.getName().equals(name)) {
                return building;
            }
        }
        return null;
    }
}
