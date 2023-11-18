package com.use_case.open_buildings_list;

public class OpenBuildingsListInteractor implements OpenBuildingsListInputBoundary{

    final OpenBuildingsListDataAccessInterface openBuildingsListDataAccessObject;
    final OpenBuildingsListOutputBoundary openBuildingsListPresenter;

    public OpenBuildingsListInteractor(OpenBuildingsListDataAccessInterface openBuildingsListDataAccessInterface,
                                       OpenBuildingsListOutputBoundary openBuildingsListOutputBoundary) {
        this.openBuildingsListDataAccessObject = openBuildingsListDataAccessInterface;
        this.openBuildingsListPresenter = openBuildingsListOutputBoundary;
    }
    @Override
    public void execute(OpenBuildingsListInputData openBuildingsListInputData) {
    // TODO: implement execute() for open buildings list
    }
}
