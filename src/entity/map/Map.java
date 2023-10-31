package entity.map;

import entity.building.Building;
import entity.building.Location;

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
     * Gets the building at the specified location.
     *
     * @param location the location which the building resides at.
     * @return the building at that location.
     */
    public Building getBuilding(Location location) {
        for (Building building : buildings) {
            if (location.contains(building.getLocation())) {
                return building;
            }
        }
        return null;
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

    /**
     * Gets the pins on the map.
     * @return the pins on the map.
     */
    public List<Pin> getPins() {
        List<Pin> pins = new ArrayList<>();
        for (Building building : buildings) {
            pins.add(building.getPin());
        }
        return pins;
    }

    // TODO: add get image to map
}
