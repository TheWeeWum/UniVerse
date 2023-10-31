package entity.user;

import entity.Reviewable;
import entity.building.Building;
import entity.review.Review;
import entity.room.Room;

import java.util.List;

public class AdminUser extends LoggedInUser {
    /**
     * @param username the users username
     * @param password the users password
     * @param id the users ID
     * @param reviews the list of reviews the user has left
     * @param favourites the list of all the users favorites
     * @param favouriteBuildings the list of the users favourite buildings
     * @param favouriteRooms the list of the users favourite rooms
     */
    public AdminUser(String username, String password, Integer id, List<Review> reviews, List<Reviewable> favourites, List<Building> favouriteBuildings, List<Room> favouriteRooms) {
        super(username, password, id, reviews, favourites, favouriteBuildings, favouriteRooms);
    }
}
