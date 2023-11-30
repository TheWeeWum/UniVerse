package com.app;

import com.data_access.BuildingDataAccessObject;
import com.data_access.Path;
import com.entity.building.BuildingBuilder;
import com.entity.event.EventBuilder;
import com.interface_adapter.open_building.OpenBuildingController;
import com.interface_adapter.open_building.OpenBuildingPresenter;
import com.use_case.open_building.OpenBuildingDataAccessInterface;
import com.use_case.open_building.OpenBuildingInputBoundary;
import com.use_case.open_building.OpenBuildingInteractor;
import com.use_case.open_building.OpenBuildingOutputBoundary;
import com.view.Building.BuildingInfoServlet;

public class BuildingSetup {
    public static OpenBuildingController setup(BuildingInfoServlet buildingInfoServlet) {
        OpenBuildingOutputBoundary presenter = new OpenBuildingPresenter(buildingInfoServlet);

        BuildingBuilder buildingBuilder = new BuildingBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = Path.path + "external-data\\events.json";
        OpenBuildingDataAccessInterface dataAccess = new BuildingDataAccessObject(buildingPath,eventPath, buildingBuilder, eventBuilder);

        OpenBuildingInputBoundary interactor = new OpenBuildingInteractor(dataAccess, presenter);
        return new OpenBuildingController(interactor);
    }
}
