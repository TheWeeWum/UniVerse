package entity.user;

import entity.Reviewable;
import entity.building.Building;
import entity.review.Review;
import entity.room.Room;

import java.util.List;
import java.util.NoSuchElementException;

public class LoggedInUser implements User {
    private String username;
    private String password;
    private final Integer id;
    private final List<Review> reviews;
    private final List<Reviewable> favourites;
    private final List<Building> favouriteBuildings;
    private final List<Room> favouriteRooms;

    /**
     * @param username the users username
     * @param password the users password
     * @param id the users ID
     * @param reviews the list of reviews the user has left
     * @param favourites the list of all the users favorites
     * @param favouriteBuildings the list of the users favourite buildings
     * @param favouriteRooms the list of the users favourite rooms
     */
    public LoggedInUser(String username, String password, Integer id, List<Review> reviews, List<Reviewable> favourites, List<Building> favouriteBuildings, List<Room> favouriteRooms) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.reviews = reviews;
        this.favourites = favourites;
        this.favouriteBuildings = favouriteBuildings;
        this.favouriteRooms = favouriteRooms;
    }

    // READ
    /**
     * Returns the username of the user
     * @return the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Checks the received password against the actual password and returns whether it matches.
     * @param expectedPassword the expected password which is checked against the known password.
     * @return whether the password matched.
     */
    public boolean checkPassword(String expectedPassword) {
        return password.equals(expectedPassword);
    }

    /**
     * Checks the received ID against the actual ID and returns whether it matches.
     * @param expectedID the expected ID which is checked against the known ID.
     * @return whether the ID matched.
     */
    public boolean checkID(Integer expectedID) {
        return id.equals(expectedID);
    }

    /**
     * Returns all the users reviews.
     * @return all the users reviews.
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * Returns any of the users favourites. This includes anything which inherits from the Reviewable Parent.
     * @return any of the users favourites
     */
    public List<Reviewable> getFavourites() {
        // TODO: might need to change this to return the favourite buildings + the favourite rooms
        return favourites;
    }

    /**
     * Returns the users favourite Buildings.
     * @return any of the users favourite buildings
     */
    public List<Building> getFavouriteBuildings() {
        return favouriteBuildings;
    }

    /**
     * Returns the users favourite Rooms.
     * @return any of the users favourite rooms
     */
    public List<Room> getFavouriteRooms() {
        return favouriteRooms;
    }


    // UPDATE
    /**
     * Replaces the current username with newUsername
     * Precondition: username has been checked to ensure that no other user already has that username
     */
    public void ChangeUsername(String newUsername) {
        this.username = newUsername;
    }

    /**
     * Adds the new review to the users reviews.
     * @param review the expected password which is checked against the known password.
     */
    public void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Adds the favourite building object to the users favourite buildings.
     *
     * @param favourite the favourite object to be saved to the users favourite buildings
     */
    public void addFavourite(Building favourite) {
        favourites.add(favourite);
        favouriteBuildings.add(favourite);
    }

    /**
     * Adds the favourite Room object to the users favourite rooms.
     *
     * @param favourite the favourite object to be saved to the users favourite rooms
     */
    public void addFavourite(Room favourite) {
        favourites.add(favourite);
        favouriteRooms.add(favourite);
    }

    /**
     * Adds the general favourite object to the users favourites.
     *
     * @param favourite the favourite object to be saved to the users favourites
     */
    public void addFavourite(Reviewable favourite) {
        favourites.add(favourite);
    }


    // DELETE
    /**
     * Removes the specified review from the users reviews
     *
     * @param review the review to be removed from the users reviews
     * @return true if the review was removed successfully otherwise returns false
     */
    public boolean deleteReview(Review review) {
        // TODO: Might need to be changed depending on how we uniquely quantify each review
        try {
            reviews.remove(review);
            return true;
        } catch (NoSuchElementException e) {
            // review was not in the users reviews
            return false;
        }
    }


}
