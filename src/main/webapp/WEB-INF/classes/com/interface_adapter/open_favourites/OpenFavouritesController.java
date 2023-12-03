package com.interface_adapter.open_favourites;

import com.use_case.open_building.OpenBuildingInputBoundary;
import com.use_case.open_building.OpenBuildingInputData;
import com.use_case.open_favourites.OpenFavouritesInputBoundary;
import com.use_case.open_favourites.OpenFavouritesInputData;

public class OpenFavouritesController {

    final OpenFavouritesInputBoundary openFavouritesUseCaseInteractor;

    public OpenFavouritesController(OpenFavouritesInputBoundary openFavouritesUseCaseInteractor) {
        this.openFavouritesUseCaseInteractor = openFavouritesUseCaseInteractor;
    }

    public void execute(int userId) {
        System.out.println("execute in OpenFavouritesController");
        // OpenFavouritesInputData inputData = new OpenFavouritesInputData(userId);
        openFavouritesUseCaseInteractor.execute(userId);
    }
}
