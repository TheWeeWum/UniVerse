package com.use_case.add_to_favourites;

import java.util.Date;

public class AddToFavouritesInteractor implements AddToFavouritesInputBoundary{

    private AddToFavouritesDataAccessInterface addToFavouritesDataAccessObject;

    public AddToFavouritesInteractor(AddToFavouritesDataAccessInterface addToFavouritesDataAccessObject) {
        this.addToFavouritesDataAccessObject = addToFavouritesDataAccessObject;
    }

    @Override
    public void execute(AddToFavouritesInputData inputData) {
        // get information from inputData
        int userId = inputData.getUserId();
        String buildingCode = inputData.getBuildingCode();

        // call dao to add event to the json files
        addToFavouritesDataAccessObject.addFavourite(userId, buildingCode);

    }
}
