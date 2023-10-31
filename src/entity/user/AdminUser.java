package entity.user;

import entity.Reviewable;
import entity.building.Building;
import entity.review.Review;
import entity.room.Room;

import java.util.List;

public class AdminUser extends LoggedInUser {
    public AdminUser(String username, String password, Integer id, List<Review> reviews, List<Reviewable> favourites, List<Building> favouriteBuildings, List<Room> favouriteRooms) {
        super(username, password, id, reviews, favourites, favouriteBuildings, favouriteRooms);
    }
}
