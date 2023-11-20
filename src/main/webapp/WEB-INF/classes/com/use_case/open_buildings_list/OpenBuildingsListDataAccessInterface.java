package com.use_case.open_buildings_list;
import com.entity.building.Building;

import java.util.List;

public interface OpenBuildingsListDataAccessInterface {
    List<Building> getBuildings();
}
