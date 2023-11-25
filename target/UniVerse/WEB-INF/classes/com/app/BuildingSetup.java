package com.app;

import com.data_access.BuildingDataAccessObject;
import com.entity.building.BuildingFactory;
import com.interface_adapter.open_building.OpenBuildingController;
import com.interface_adapter.open_building.OpenBuildingPresenter;
import com.use_case.open_building.OpenBuildingDataAccessInterface;
import com.use_case.open_building.OpenBuildingInputBoundary;
import com.use_case.open_building.OpenBuildingInteractor;
import com.use_case.open_building.OpenBuildingOutputBoundary;
import com.view.BuildingInfoServlet;

public class BuildingSetup {
    public static OpenBuildingController setup(BuildingInfoServlet buildingServlet) {
        OpenBuildingOutputBoundary presenter = new OpenBuildingPresenter(buildingServlet);

        BuildingFactory buildingFactory = new BuildingFactory();
        OpenBuildingDataAccessInterface dataAccess = new BuildingDataAccessObject("C:\\Users\\evan_\\Documents\\UofT\\year2\\csc207\\IdeaProjects\\UniVerse\\external-data\\buildings.json", buildingFactory);

        OpenBuildingInputBoundary interactor = new OpenBuildingInteractor(dataAccess, presenter);
        return new OpenBuildingController(interactor);
    }
}
