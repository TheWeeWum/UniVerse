package com.app;

import com.data_access.AddToFavouritesDataAccessObject;
import com.entity.building.BuildingFactory;
import com.entity.user.CommonUserFactory;
import com.entity.user.UserFactory;
import com.interface_adapter.add_to_favourites.AddToFavouritesController;

import com.use_case.add_to_favourites.AddToFavouritesDataAccessInterface;
import com.use_case.add_to_favourites.AddToFavouritesInputBoundary;
import com.use_case.add_to_favourites.AddToFavouritesInteractor;

import com.view.Building.BuildingPageServlet;

public class AddToFavouritesSetup {

    public static AddToFavouritesController setup(BuildingPageServlet buildingPageServlet) {


        String buildingPath = Path.path + "external-data\\buildings.json";
        BuildingFactory buildingFactory = new BuildingFactory();

        String userPath = Path.path + "external-data\\UserDataBase.json";
        UserFactory userFactory = new CommonUserFactory();

        AddToFavouritesDataAccessInterface dataAccess = new AddToFavouritesDataAccessObject(buildingPath, buildingFactory, userPath, userFactory);

        AddToFavouritesInputBoundary interactor = new AddToFavouritesInteractor(dataAccess);
        return new AddToFavouritesController(interactor);
    }
}
