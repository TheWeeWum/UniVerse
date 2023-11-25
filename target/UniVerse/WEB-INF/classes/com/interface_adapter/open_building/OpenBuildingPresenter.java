package com.interface_adapter.open_building;

import com.use_case.open_building.OpenBuildingOutputBoundary;
import com.use_case.open_building.OpenBuildingOutputData;
import com.view.BuildingInfoServlet;

public class OpenBuildingPresenter implements OpenBuildingOutputBoundary {
    BuildingInfoServlet buildingServlet;

    public OpenBuildingPresenter(BuildingInfoServlet buildingServlet) {
        this.buildingServlet = buildingServlet;
    }

    @Override
    public void prepareSuccessView(OpenBuildingOutputData openBuildingOutputData) {
        buildingServlet.writeBuilding(openBuildingOutputData);
    }
}
