package com.use_case.open_favourites;

import com.entity.building.Building;

import java.util.List;

public class OpenFavouritesOutputData {
    private final List<Building> favouriteBuildings;

    public OpenFavouritesOutputData(List<Building> favouriteBuildings) {
        this.favouriteBuildings = favouriteBuildings;
    }
    public List<Building> getFavouriteBuildings() {
        return favouriteBuildings;
    }

}
