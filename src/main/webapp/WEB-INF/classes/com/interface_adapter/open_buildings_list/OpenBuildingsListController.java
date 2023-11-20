package com.interface_adapter.open_buildings_list;

import com.use_case.open_buildings_list.OpenBuildingsListInputBoundary;

public class OpenBuildingsListController {

    final OpenBuildingsListInputBoundary openBuildingsListUseCaseInteractor;

    public OpenBuildingsListController(OpenBuildingsListInputBoundary openBuildingsListUseCaseInteractor) {
        this.openBuildingsListUseCaseInteractor = openBuildingsListUseCaseInteractor;
    }


    public void execute(String username, String password) {
    openBuildingsListUseCaseInteractor.execute();
    }
}
