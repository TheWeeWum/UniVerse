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
        System.out.println("interactor");
        // TODO: add favourite building getter so that we can display the favourites
        // button as clicked or unclicked
//        List<Building> favouriteBuildings = openBuildingDataAccessObject.getFavouriteBuildings(inputData.getUserId());
        Building building = openBuildingDataAccessObject.getBuilding(inputData.getBuildingCode());
        System.out.println("got buildings");

        boolean isFavourited = false;
//        if (favouriteBuildings.contains(building)) {
//            isFavourited = true;
//        }

        // compile into output data
        OpenBuildingOutputData openBuildingOutputData = new OpenBuildingOutputData(building, isFavourited);
        System.out.println("sending to presenter");
        openBuildingPresenter.prepareSuccessView(openBuildingOutputData);
    }
}
