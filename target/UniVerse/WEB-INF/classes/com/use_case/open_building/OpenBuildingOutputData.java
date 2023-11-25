package com.use_case.open_building;

import com.entity.building.Building;

import java.util.List;

public class OpenBuildingOutputData {
    private final Building building;

    public OpenBuildingOutputData(Building building) {
        this.building = building;
    }
    public Building getBuilding() {
        return building;
    }
}
