package com.app;

import com.data_access.AddToFavouritesDataAccessObject;
import com.data_access.Path;
import com.entity.building.BuildingBuilder;
import com.entity.user.CommonUserFactory;
import com.entity.user.UserFactory;
import com.interface_adapter.add_to_favourites.AddToFavouritesController;

import com.use_case.add_to_favourites.AddToFavouritesDataAccessInterface;
import com.use_case.add_to_favourites.AddToFavouritesInputBoundary;
import com.use_case.add_to_favourites.AddToFavouritesInteractor;

import com.view.Building.AddToFavouritesServlet;

public class AddToFavouritesSetup {

    public static AddToFavouritesController setup(AddToFavouritesServlet buildingPageServlet) {
        String buildingPath = Path.path + "external-data\\buildings.json";
        String userPath = Path.path + "external-data\\UserDataBase.json";

        BuildingBuilder buildingBuilder = new BuildingBuilder();
        UserFactory userFactory = new CommonUserFactory();

        AddToFavouritesDataAccessInterface dataAccess = new AddToFavouritesDataAccessObject(buildingPath, buildingBuilder, userPath, userFactory);

        AddToFavouritesInputBoundary interactor = new AddToFavouritesInteractor(dataAccess);
        return new AddToFavouritesController(interactor);
    }
}
