package com.interface_adapter.add_to_favourites;

import com.use_case.add_to_favourites.AddToFavouritesInputBoundary;
import com.use_case.add_to_favourites.AddToFavouritesInputData;

import javax.servlet.http.HttpServletRequest;


public class AddToFavouritesController {

    final AddToFavouritesInputBoundary addToFavouritesUseCaseInteractor;

    public AddToFavouritesController(AddToFavouritesInputBoundary addToFavouritesUseCaseInteractor) {
        this.addToFavouritesUseCaseInteractor = addToFavouritesUseCaseInteractor;
    }

    public void execute(int userId, String buildingCode) {

        AddToFavouritesInputData inputData = new AddToFavouritesInputData(userId, buildingCode);
        addToFavouritesUseCaseInteractor.execute(inputData);
    }
}
