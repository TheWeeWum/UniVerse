package com.use_case.open_building;

import com.entity.building.Building;

import java.util.List;

public class OpenBuildingOutputData {
    private final Building building;
    private final boolean isFavourited;

    public OpenBuildingOutputData(Building building, boolean isFavourited) {
        this.building = building;
        this.isFavourited = isFavourited;
    }
    public Building getBuilding() {
        return building;
    }
    public boolean getIsFavourited() { return isFavourited; }
}
