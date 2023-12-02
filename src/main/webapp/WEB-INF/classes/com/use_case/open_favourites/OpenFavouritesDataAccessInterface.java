package com.use_case.open_favourites;

import com.entity.building.Building;

import java.util.List;

public interface OpenFavouritesDataAccessInterface {
    List<Building> getFavouriteBuildings(int userId);

}
