package com.entity.user;

import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.review.Review;
import com.entity.room.Room;

import java.util.List;

public class AdminUser extends LoggedInUser {
    /**
     * @param username the users username
     * @param password the users password
     * @param id the users ID
     * @param reviews the list of reviews the user has left
     * @param favouriteBuildings the list of the users favourite buildings
     * @param favouriteRooms the list of the users favourite rooms
     */
    public AdminUser(String username, String password, Integer id, List<String> reviews, List<Building> favouriteBuildings, List<Room> favouriteRooms) {
        super(username, password, id, reviews, favouriteBuildings, favouriteRooms);
    }
}
