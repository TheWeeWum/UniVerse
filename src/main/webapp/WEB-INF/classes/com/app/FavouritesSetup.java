package com.app;

import com.data_access.BuildingDataAccessObject;
import com.data_access.Path;
import com.entity.building.BuildingBuilder;
import com.entity.event.EventBuilder;
import com.interface_adapter.open_favourites.OpenFavouritesController;
import com.interface_adapter.open_favourites.OpenFavouritesPresenter;
import com.use_case.open_favourites.OpenFavouritesDataAccessInterface;
import com.use_case.open_favourites.OpenFavouritesInputBoundary;
import com.use_case.open_favourites.OpenFavouritesInteractor;
import com.use_case.open_favourites.OpenFavouritesOutputBoundary;
import com.view.Favourites.FavouritesInfoServlet;

public class FavouritesSetup {
    public static OpenFavouritesController setup(FavouritesInfoServlet favouritesInfoServlet) {
        OpenFavouritesOutputBoundary presenter = new OpenFavouritesPresenter(favouritesInfoServlet);

        BuildingBuilder buildingFactory = new BuildingBuilder();
        EventBuilder eventFactory = new EventBuilder();

        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = Path.path + "external-data\\events.json";
        String userPath = Path.path + "external-data\\UserDataBase.json";

        OpenFavouritesDataAccessInterface dataAccess = new BuildingDataAccessObject(buildingPath, eventPath, userPath, buildingFactory, eventFactory);

        OpenFavouritesInputBoundary interactor = new OpenFavouritesInteractor(dataAccess, presenter);
        return new OpenFavouritesController(interactor);
    }
}
