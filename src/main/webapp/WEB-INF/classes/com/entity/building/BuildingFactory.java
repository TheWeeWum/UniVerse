package com.entity.building;

public class BuildingFactory {
    public Building create(String name, String address) {
        return new Building(name, "", address, null, null, null, null, null);
    }

}
