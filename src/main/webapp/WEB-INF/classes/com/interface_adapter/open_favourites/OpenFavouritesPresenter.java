package com.interface_adapter.open_favourites;

import com.use_case.open_favourites.OpenFavouritesOutputBoundary;
import com.use_case.open_favourites.OpenFavouritesOutputData;
import com.view.Favourites.FavouritesInfoServlet;

public class OpenFavouritesPresenter implements OpenFavouritesOutputBoundary {

    FavouritesInfoServlet favouritesInfoServlet;

    public OpenFavouritesPresenter(FavouritesInfoServlet favouritesInfoServlet) {
        this.favouritesInfoServlet = favouritesInfoServlet;
    }

    @Override
    public void execute(OpenFavouritesOutputData openFavouritesOutputData) {
        favouritesInfoServlet.writeFavouriteBuildings(openFavouritesOutputData);
        System.out.println(openFavouritesOutputData.getFavouriteBuildings());
    }
}
