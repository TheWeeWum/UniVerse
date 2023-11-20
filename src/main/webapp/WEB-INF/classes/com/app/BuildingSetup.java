package com.app;

import com.data_access.BuildingDataAccessObject;
import com.entity.building.BuildingFactory;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.interface_adapter.open_buildings_list.OpenBuildingsListPresenter;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListInputBoundary;
import com.use_case.open_buildings_list.OpenBuildingsListInteractor;
import com.use_case.open_buildings_list.OpenBuildingsListOutputBoundary;
import com.view.BuildingsListServlet;

public class BuildingSetup {
    public static OpenBuildingsListController setup(BuildingsListServlet buildingsListServlet) {
        OpenBuildingsListOutputBoundary presenter = new OpenBuildingsListPresenter(buildingsListServlet);

        BuildingFactory buildingFactory = new BuildingFactory();
        OpenBuildingsListDataAccessInterface dataAccess = new BuildingDataAccessObject("C:\\Users\\evan_\\Documents\\UofT\\year2\\csc207\\IdeaProjects\\UniVerse\\external-data\\buildings.json", buildingFactory);

        OpenBuildingsListInputBoundary interactor = new OpenBuildingsListInteractor(dataAccess, presenter);
        return new OpenBuildingsListController(interactor);
    }
}
