package com.interface_adapter.open_building;

import com.use_case.open_building.OpenBuildingOutputBoundary;
import com.use_case.open_building.OpenBuildingOutputData;
import com.view.Building.BuildingInfoServlet;

public class OpenBuildingPresenter implements OpenBuildingOutputBoundary {

    BuildingInfoServlet buildingInfoServlet;

    public OpenBuildingPresenter(BuildingInfoServlet buildingInfoServlet) {
        this.buildingInfoServlet = buildingInfoServlet;
    }

    @Override
    public void prepareSuccessView(OpenBuildingOutputData openBuildingOutputData) {
        buildingInfoServlet.writeBuilding(openBuildingOutputData);
    }
}
