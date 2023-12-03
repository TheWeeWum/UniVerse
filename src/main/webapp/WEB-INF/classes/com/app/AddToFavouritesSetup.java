package com.app;

import com.data_access.AddToFavouritesDataAccessObject;
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
        AddToFavouritesDataAccessInterface dataAccess = DataAccessBuilder.getAddToFavouritesDataAccessObject();

        AddToFavouritesInputBoundary interactor = new AddToFavouritesInteractor(dataAccess);
        return new AddToFavouritesController(interactor);
    }
}
