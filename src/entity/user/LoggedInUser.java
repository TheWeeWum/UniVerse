package entity.user;

import entity.Reviewable;
import entity.building.Building;
import entity.review.Review;
import entity.room.Room;

import java.util.List;

public class LoggedInUser implements User {
    private String username;
    private String password;
    private final Integer id;
    private final List<Review> reviews;
    private final List<Reviewable> favourites;
    private final List<Building> favouriteBuildings;
    private final List<Room> favouriteRooms;

    public LoggedInUser(String username, String password, Integer id, List<Review> reviews, List<Building> favouriteBuildings, List<Room> favouriteRooms) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.reviews = reviews;
        this.favouriteBuildings = favouriteBuildings;
        this.favouriteRooms = favouriteRooms;
    }

    // READ
    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String expectedPassword) {
        return password.equals(expectedPassword);
    }

    public boolean checkID(Integer expectedID) {
        return id.equals(expectedID);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Reviewable> getFavourites() {
        // TODO: might need to change this to return the favourite buildings + the favourite rooms
        return favourites;
    }

    public List<Building> getFavouriteBuildings() {
        return favouriteBuildings;
    }

    public List<Room> getFavouriteRooms() {
        return favouriteRooms;
    }


    // UPDATE
    /**
     *
     *
     * @param  url  an absolute URL giving the base location of the image
     * @param  name the location of the image, relative to the url argument
     * @return      the image at the specified URL
     */
    public void ChangeUsername(String newUsername) {
        this.username = username;
    }


}
