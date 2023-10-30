package entity.map;

import entity.building.Building;
import entity.building.Location;

import java.util.List;

public class Map {
    // TODO: add image to map
    private final List<Building> buildings;
    private final List<Pin> pins;

    public Map(List<Building> buildings, List<Pin> pins) {
        this.buildings = buildings;
        this.pins = pins;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public Building getBuilding(Location loc) {
        for (Building building : buildings) {
            if (loc.contains(building.getLocation())) {
                return building;
            }
        }
        return null;
    }

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

    public List<Pin> getPins() {
        return pins;
    }

    // TODO: add get image to map
}
