package com.app;

import com.data_access.BuildingDataAccessObject;
import com.data_access.BuildingReviewDataAccessObject;
import com.data_access.FileUserDataAccessObject;
import com.entity.building.BuildingBuilder;
import com.entity.event.EventBuilder;
import com.entity.review.ReviewBuilder;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.interface_adapter.open_buildings_list.OpenBuildingsListPresenter;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListInputBoundary;
import com.use_case.open_buildings_list.OpenBuildingsListInteractor;
import com.use_case.open_buildings_list.OpenBuildingsListOutputBoundary;
import com.view.Buildings.BuildingsListServlet;

public class BuildingListSetup {
    public static OpenBuildingsListController setup(BuildingsListServlet buildingsListServlet) {
        OpenBuildingsListOutputBoundary presenter = new OpenBuildingsListPresenter(buildingsListServlet);

        OpenBuildingsListDataAccessInterface dataAccess = DataAccessBuilder.getBuildingDataAccessObject();

        OpenBuildingsListInputBoundary interactor = new OpenBuildingsListInteractor(dataAccess, presenter);
        return new OpenBuildingsListController(interactor);
    }
}
