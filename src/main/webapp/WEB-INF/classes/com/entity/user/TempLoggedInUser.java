package com.entity.user;

import com.entity.review.Review;
import com.entity.room.Room;

import java.util.List;

public class TempLoggedInUser {
    public String username;
    public String password;
    public final int id;
    public final List<Review> reviews;
    public final List<String> favouriteBuildings;
    public final List<Room> favouriteRooms;

    /**
     * @param username the users username
     * @param password the users password
     * @param id the users ID
     * @param reviews the list of reviews the user has left
     * @param favouriteBuildings the list of the users favourite buildings
     * @param favouriteRooms the list of the users favourite rooms
     */
    public TempLoggedInUser(String username, String password, Integer id, List<Review> reviews, List<String> favouriteBuildings, List<Room> favouriteRooms) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.reviews = reviews;
        this.favouriteBuildings = favouriteBuildings;
        this.favouriteRooms = favouriteRooms;
        // this.favourites = getFavourites(favouriteBuildings, favouriteRooms);
    }
}
