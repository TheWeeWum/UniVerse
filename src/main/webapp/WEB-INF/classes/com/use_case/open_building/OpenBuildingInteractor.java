package com.use_case.open_building;

import com.entity.building.Building;
import com.use_case.open_building.OpenBuildingInputBoundary;

public class OpenBuildingInteractor implements OpenBuildingInputBoundary {
    final OpenBuildingDataAccessInterface openBuildingDataAccessObject;
    final OpenBuildingOutputBoundary openBuildingPresenter;

    public OpenBuildingInteractor(OpenBuildingDataAccessInterface openBuildingDataAccessInterface,
                                  OpenBuildingOutputBoundary openBuildingOutputBoundary) {
        this.openBuildingDataAccessObject = openBuildingDataAccessInterface;
        this.openBuildingPresenter = openBuildingOutputBoundary;
    }
    @Override
    public void execute() {
        // no input data
        // get buildings from database
        Building building = openBuildingDataAccessObject.getBuilding();

        // compile into output data
        OpenBuildingOutputData openBuildingOutputData = new OpenBuildingOutputData(building);
        openBuildingPresenter.prepareSuccessView(openBuildingOutputData);
    }
}
