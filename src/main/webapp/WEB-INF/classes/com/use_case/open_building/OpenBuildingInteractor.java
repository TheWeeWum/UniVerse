package com.use_case.open_building;

import com.entity.building.Building;

import java.awt.*;
import java.util.List;
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
        List<Building> favouriteBuildings = openBuildingDataAccessObject.getFavouriteBuildings(inputData.getUserId());

        Building building = openBuildingDataAccessObject.getBuilding(inputData.getBuildingCode());

        boolean isFavourited = false;
        if (favouriteBuildings.contains(building)) {
            isFavourited = true;
        }

        // compile into output data
        OpenBuildingOutputData openBuildingOutputData = new OpenBuildingOutputData(building, isFavourited);

        openBuildingPresenter.prepareSuccessView(openBuildingOutputData);
    }
}
