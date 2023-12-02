package com.use_case.add_to_favourites;

import com.entity.user.User;

public class AddToFavouritesInputData {

    private final int userId;
    private final String buildingCode;

    public AddToFavouritesInputData(int userId, String buildingCode) {
        this.userId = userId;
        this.buildingCode = buildingCode;
    }

    public String getBuildingCode() {
        return buildingCode;
    }
    public int getUserId() { return userId; }


}
