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
     * Gets the building at the specified address or name.
     *
     * @param addressOrName the address or name of the building.
     * @return the building at that address or name.
     */
    public Building getBuilding(String addressOrName) {
        for (Building building : buildings) {
            if (building.getAddress().equals(addressOrName)) {
                return building;
            }
            if (building.getName().equals(addressOrName)) {
                return building;
            }
        }
        return null;
    }
}
