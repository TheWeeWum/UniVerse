package com.use_case.open_building;

import com.entity.building.Building;

public class OpenBuildingInteractor implements OpenBuildingInputBoundary {
    final OpenBuildingDataAccessInterface openBuildingDataAccessObject;
    final OpenBuildingOutputBoundary openBuildingPresenter;

    public OpenBuildingInteractor(OpenBuildingDataAccessInterface openBuildingDataAccessInterface,
                                  OpenBuildingOutputBoundary openBuildingOutputBoundary) {
        this.openBuildingDataAccessObject = openBuildingDataAccessInterface;
        this.openBuildingPresenter = openBuildingOutputBoundary;
    }

    @Override
    public void execute(OpenBuildingInputData inputData) {

        Building building = openBuildingDataAccessObject.getBuilding(inputData.getBuildingCode());

        // compile into output data
        OpenBuildingOutputData openBuildingOutputData = new OpenBuildingOutputData(building);

        openBuildingPresenter.prepareSuccessView(openBuildingOutputData);
    }
}
