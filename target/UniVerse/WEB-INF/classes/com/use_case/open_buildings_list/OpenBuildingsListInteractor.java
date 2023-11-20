package com.use_case.open_buildings_list;

import com.entity.building.Building;

import java.util.List;

public class OpenBuildingsListInteractor implements OpenBuildingsListInputBoundary{

    final OpenBuildingsListDataAccessInterface openBuildingsListDataAccessObject;
    final OpenBuildingsListOutputBoundary openBuildingsListPresenter;

    public OpenBuildingsListInteractor(OpenBuildingsListDataAccessInterface openBuildingsListDataAccessInterface,
                                       OpenBuildingsListOutputBoundary openBuildingsListOutputBoundary) {
        this.openBuildingsListDataAccessObject = openBuildingsListDataAccessInterface;
        this.openBuildingsListPresenter = openBuildingsListOutputBoundary;
    }
    @Override
    public void execute() {
        // no input data
        // get buildings from database
        List<Building> buildings = openBuildingsListDataAccessObject.getBuildings();

        // compile into output data
        OpenBuildingsListOutputData openBuildingsListOutputData = new OpenBuildingsListOutputData(buildings);
        openBuildingsListPresenter.prepareSuccessView(openBuildingsListOutputData);
    }
}
