package com.use_case.open_building;

import com.entity.building.Building;

import java.util.List;

public interface OpenBuildingDataAccessInterface {
    Building getBuilding(String buildingCode);

    public List<Building> getFavouriteBuildings(int userId);
}
