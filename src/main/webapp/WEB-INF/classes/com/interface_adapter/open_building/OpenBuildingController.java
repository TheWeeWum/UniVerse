package com.interface_adapter.open_building;

import com.use_case.open_building.OpenBuildingInputBoundary;
import com.use_case.open_building.OpenBuildingInputData;

public class OpenBuildingController {

    final OpenBuildingInputBoundary openBuildingUseCaseInteractor;

    public OpenBuildingController(OpenBuildingInputBoundary openBuildingUseCaseInteractor) {
        this.openBuildingUseCaseInteractor = openBuildingUseCaseInteractor;
    }

    public void execute(int userId, String buildingCode) {
        OpenBuildingInputData inputData = new OpenBuildingInputData(userId, buildingCode);

        openBuildingUseCaseInteractor.execute(inputData);
    }
}
