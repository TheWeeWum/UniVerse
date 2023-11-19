package com.use_case.open_profile;

import com.entity.building.Building;
import com.entity.review.Review;
import com.entity.room.Room;

import java.util.ArrayList;
import java.util.List;

public class ProfileOutputData {

    final private String username;
    // maybe implement later
    // final private Map<String,List<Building>> userFavouriteLists; // create a mapping of each users lists based off the list name
    final private List<Review> userReviews;
    final private List<Room> favouriteRooms;
    final private List<Building> favouriteBuildings;

    public ProfileOutputData(String username, ArrayList<Review> userReviews, List<Room> favouriteRooms, List<Building> favouriteBuildings) {
        this.username = username;
        this.userReviews = userReviews;
        this.favouriteRooms = favouriteRooms;
        this.favouriteBuildings = favouriteBuildings;

    }
    String getUsername() {return username;}

    // List<Building> getUserFavouriteLists(String listName) {return userFavouriteLists.get(listName);};

    List<Review> getuserReviews() {return userReviews;}

    List<Room> getFavouriteRooms(){return favouriteRooms;}

    List<Building> getFavouriteBuildings(){return  favouriteBuildings;}
}