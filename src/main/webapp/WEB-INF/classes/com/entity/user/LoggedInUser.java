package com.entity.user;

import com.entity.JsonRepresentation;
import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.review.Review;
import com.entity.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LoggedInUser implements User, JsonRepresentation {
    private String username;
    private String password;
    private final int id;
    private final List<Review> reviews;
    private final List<Building> favouriteBuildings;
    private final List<Room> favouriteRooms;
    // private final List<Reviewable> favourites;

    /**
     * @param username the users username
     * @param password the users password
     * @param id the users ID
     * @param reviews the list of reviews the user has left
     * @param favouriteBuildings the list of the users favourite buildings
     * @param favouriteRooms the list of the users favourite rooms
     */
    public LoggedInUser(String username, String password, Integer id, List<Review> reviews, List<Building> favouriteBuildings, List<Room> favouriteRooms) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.reviews = reviews;
        this.favouriteBuildings = favouriteBuildings;
        this.favouriteRooms = favouriteRooms;
        // this.favourites = getFavourites(favouriteBuildings, favouriteRooms);
    }


    // This constructor exists for a sign-up case, so that when we create a user in the interactor, we could pass
    //only 2 arguments.
    public LoggedInUser(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.reviews = new ArrayList<>();
        this.favouriteBuildings = new ArrayList<>();
        this.favouriteRooms = new ArrayList<>();
        // this.favourites = getFavourites(favouriteBuildings, favouriteRooms);
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
        return id == expectedID;
    }

    /**
     * Returns all the users reviews.
     *
     * @return all the users reviews.
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * Returns any of the users favourites. This includes anything which inherits from the Reviewable Parent.
     * @return any of the users favourites
     */
    public List<Reviewable> getFavourites(List<Building> favouriteBuildings, List<Room> favouriteRooms) {
        List<Reviewable> favorites = new ArrayList<>();
        favorites.addAll(favouriteBuildings); // Add all favorite buildings
        favorites.addAll(favouriteRooms); // Add all favorite rooms
        return favorites;
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
//    public void addFavourite(Building favourite) {
//        favourites.add(favourite);
//        favouriteBuildings.add(favourite);
//    }

    /**
     * Adds the favourite Room object to the users favourite rooms.
     *
     * @param favourite the favourite object to be saved to the users favourite rooms
     */
//    public void addFavourite(Room favourite) {
//        favourites.add(favourite);
//        favouriteRooms.add(favourite);
//    }

    /**
     * Adds the general favourite object to the users favourites.
     *
     * @param favourite the favourite object to be saved to the users favourites
     */
//    public void addFavourite(Reviewable favourite) {
//        favourites.add(favourite);
//    }


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


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Gets the Json representation of the User Object in the following format.
     * <pre>
     * {
     *      username: String
     *      id: String
     *      reviews: []
     *      favourite_buildings: []
     *      favourite_rooms: []
     * }
     * </pre>
     * @return String in Json format:
     */
    @Override
    public String getJsonRepresentation() {
        StringBuilder reviewsJson = new StringBuilder("[");
        for (Review review : reviews) {
            reviewsJson.append(review.getJsonRepresentation()).append(",");
        }
        if (!reviews.isEmpty()) {
            reviewsJson.deleteCharAt(reviewsJson.length() - 1);
        }
        reviewsJson.append("]");

        StringBuilder favBuildingsJson = new StringBuilder("[");
        for (Building building : favouriteBuildings) {
            favBuildingsJson.append(building.getJsonRepresentation()).append(",");
        }
        if (!favouriteBuildings.isEmpty()) {
            favBuildingsJson.deleteCharAt(favBuildingsJson.length() - 1);
        }
        favBuildingsJson.append("]");

        StringBuilder favRoomsJson = new StringBuilder("[");
        for (Room room : favouriteRooms) {
            favRoomsJson.append(room.getJsonRepresentation()).append(",");
        }
        if (!favouriteRooms.isEmpty()) {
            favRoomsJson.deleteCharAt(favRoomsJson.length() - 1);
        }
        favRoomsJson.append("]");

        return "{" +
                "\"username\": \"" + username + "\"" +
                "," +
                "\"id\": " + id +
                "," +
                "\"reviews\": " + reviewsJson +
                "," +
                "\"favourite_buildings\": " + favBuildingsJson +
                "," +
                "\"favourite_rooms\": " + favRoomsJson +
                "}";
    }

    /**
     * Gets the Json representation of the User Object in the following format.
     * <pre>
     * {
     *      username: String
     *      id: String
     * }
     * </pre>
     * @return String in Json format:
     */
    @Override
    public String getDeadEndJson() {
        return "{" +
                "\"username\": \"" + username + "\"" +
                "," +
                "\"id\": \"" + id +
                "}";
    }
}
