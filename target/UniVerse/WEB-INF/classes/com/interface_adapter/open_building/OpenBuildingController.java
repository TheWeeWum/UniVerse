package com.interface_adapter.open_building;

import com.use_case.open_building.OpenBuildingInputBoundary;

public class OpenBuildingController {
    final OpenBuildingInputBoundary openBuildingUseCaseInteractor;

    public OpenBuildingController(OpenBuildingInputBoundary openBuildingUseCaseInteractor) {
        this.openBuildingUseCaseInteractor = openBuildingUseCaseInteractor;
    }


    public void execute(String buildingCode) {
        openBuildingUseCaseInteractor.execute();
    }
}
