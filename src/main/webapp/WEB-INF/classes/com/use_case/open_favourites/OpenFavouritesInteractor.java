package com.use_case.open_favourites;

import com.entity.building.Building;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListOutputBoundary;
import com.use_case.open_buildings_list.OpenBuildingsListOutputData;

import java.util.List;

public class OpenFavouritesInteractor implements OpenFavouritesInputBoundary {

    final OpenFavouritesDataAccessInterface openFavouritesDataAccessObject;
    final OpenFavouritesOutputBoundary openFavouritesPresenter;

    public OpenFavouritesInteractor(OpenFavouritesDataAccessInterface openFavouritesDataAccessInterface,
                                       OpenFavouritesOutputBoundary openFavouritesOutputBoundary) {
        this.openFavouritesDataAccessObject = openFavouritesDataAccessInterface;
        this.openFavouritesPresenter = openFavouritesOutputBoundary;
    }
    @Override
    public void execute(int userId) {
        // no input data
        // get buildings from database
        List<Building> favouriteBuildings = openFavouritesDataAccessObject.getFavouriteBuildings(userId);
        // compile into output data
        OpenFavouritesOutputData openFavouritesOutputData = new OpenFavouritesOutputData(favouriteBuildings);
        openFavouritesPresenter.execute(openFavouritesOutputData);
    }
}
