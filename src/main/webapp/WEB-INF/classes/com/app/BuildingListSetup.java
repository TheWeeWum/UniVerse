package com.app;

import com.data_access.BuildingDataAccessObject;
import com.entity.building.BuildingFactory;
import com.entity.event.EventFactory;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.interface_adapter.open_buildings_list.OpenBuildingsListPresenter;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListInputBoundary;
import com.use_case.open_buildings_list.OpenBuildingsListInteractor;
import com.use_case.open_buildings_list.OpenBuildingsListOutputBoundary;
import com.view.Buildings.BuildingsListServlet;

public class BuildingListSetup {
    public static OpenBuildingsListController setup(BuildingsListServlet buildingsListServlet) {
        OpenBuildingsListOutputBoundary presenter = new OpenBuildingsListPresenter(buildingsListServlet);

        BuildingFactory buildingFactory = new BuildingFactory();
        EventFactory eventFactory = new EventFactory();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = Path.path + "external-data\\events.json";
        OpenBuildingsListDataAccessInterface dataAccess = new BuildingDataAccessObject(buildingPath,eventPath, buildingFactory, eventFactory);

        OpenBuildingsListInputBoundary interactor = new OpenBuildingsListInteractor(dataAccess, presenter);
        return new OpenBuildingsListController(interactor);
    }
}
