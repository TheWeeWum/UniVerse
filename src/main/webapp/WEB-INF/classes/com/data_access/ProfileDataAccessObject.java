package com.data_access;

import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.review.Review;
import com.entity.review.ReviewBuilder;
import com.entity.review.ReviewBuilder;
import com.entity.room.Room;
import com.entity.user.LoggedInUser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.entity.user.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.use_case.open_profile.ProfileUserDataAccessInterface;

public class ProfileDataAccessObject implements ProfileUserDataAccessInterface {
    private final String profilePath;
    private final FileUserDataAccessObject userDao;
    private final ReviewBuilder reviewFactory;
    private final BuildingDataAccessObject buildingDAO; // Add the building DAO

    public ProfileDataAccessObject(String profilePath, FileUserDataAccessObject userDao, ReviewBuilder reviewFactory, BuildingDataAccessObject buildingDAO) {
        this.profilePath = profilePath;
        this.userDao = userDao;
        this.reviewFactory = reviewFactory;
        this.buildingDAO = buildingDAO;
    }
    // TODO: Not sure if this violates CA
    private Building findBuildingByCode(String buildingCode) {
        Building building = buildingDAO.getBuilding(buildingCode);
        return building;
    }


    public Map<String, Object> getProfile(int userId) {
        try {
            JsonObject jsonProfiles = JsonParser.parseReader(new FileReader(profilePath)).getAsJsonObject();

            JsonObject userProfileJson = jsonProfiles.getAsJsonObject(String.valueOf(userId));
            if (userProfileJson != null) {
                List<Review> reviews = extractReviews(userProfileJson);
                List<Reviewable> favourites = extractFavorites(userProfileJson);
                List<String> favouriteBuildings = extractFavouriteBuildings(userProfileJson);
                List<String> favouriteRooms = extractFavouriteRooms(userProfileJson);

                Map<String, Object> profileInfo = new HashMap<>();
                profileInfo.put("username", userProfileJson.get("username").getAsString());
                profileInfo.put("password", userProfileJson.get("password").getAsString());
                profileInfo.put("userId", userId);
                profileInfo.put("reviews", reviews);
                profileInfo.put("favourites", favourites);
                profileInfo.put("favouriteBuildings", favouriteBuildings);
                profileInfo.put("favouriteRooms", favouriteRooms);

                return profileInfo;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null; // Return null if the profile is not found
    }

    private List<String> extractFavouriteBuildings(JsonObject userProfileJson) {
        JsonArray favouriteBuildingsJson = userProfileJson.getAsJsonArray("favouriteBuildings");
        List<String> favouriteBuildings = new ArrayList<>();

        if (favouriteBuildingsJson != null) {
            for (JsonElement buildingElement : favouriteBuildingsJson) {
                favouriteBuildings.add(buildingElement.getAsString());
            }
        }

        return favouriteBuildings;
    }

    private List<String> extractFavouriteRooms(JsonObject userProfileJson) {
        JsonArray favouriteRoomsJson = userProfileJson.getAsJsonArray("favouriteRooms");
        List<String> favouriteRooms = new ArrayList<>();

        if (favouriteRoomsJson != null) {
            for (JsonElement roomElement : favouriteRoomsJson) {
                favouriteRooms.add(roomElement.getAsString());
            }
        }

        return favouriteRooms;
    }


    private List<Review> extractReviews(JsonObject userProfileJson) {
        JsonArray reviewsJson = userProfileJson.getAsJsonArray("reviews");
        List<Review> reviews = new ArrayList<>();

        if (reviewsJson != null) {
            for (JsonElement reviewElement : reviewsJson) {
                // Assuming the "reviews" array directly contains the review objects
                Review review = createReviewFromJson(reviewElement.getAsJsonObject());
                reviews.add(review);
            }
        }

        return reviews;
    }

    private List<Reviewable> extractFavorites(JsonObject userProfileJson) {
        JsonArray favoritesJson = userProfileJson.getAsJsonArray("favorites");
        List<Reviewable> favorites = new ArrayList<>();

        if (favoritesJson != null) {
            for (JsonElement favoriteElement : favoritesJson) {
                String buildingCode = favoriteElement.getAsString();
                Building building = findBuildingByCode(buildingCode);
                if (building != null) {
                    favorites.add(building);
                }
            }
        }

        return favorites;
    }
    private Review createReviewFromJson(JsonObject reviewJson) {
        try {
            Integer userId = reviewJson.get("userid").getAsInt();
            userDao.populateAccountsFromJson();
            User user = userDao.getUser(userId);

            String dateStr = reviewJson.get("date").getAsString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dateStr);

            float rating = reviewJson.get("rating").getAsFloat();
            String title = reviewJson.get("title").getAsString();
            String content = reviewJson.get("content").getAsString();

            // Create and return the Review object
            return reviewFactory.create(user.getId(), user.getUsername(), date, title, content, rating);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date from JSON", e);
        }
    }


    public LoggedInUser getUser(int userID) {
        Map<String, Object> profileInfo = getProfile(userID);
        if (profileInfo != null) {
            List<Review> reviews = (List<Review>) profileInfo.get("reviews");
            List<Reviewable> favourites = (List<Reviewable>) profileInfo.get("favourites");
            List<Building> favouriteBuildings = (List<Building>) profileInfo.get("favouriteBuildings");
            List<Room> favouriteRooms = (List<Room>) profileInfo.get("favouriteRooms");

            // Assuming you have a constructor in LoggedInUser to create an instance
            // by passing the required information
            return new LoggedInUser(
                    (String) profileInfo.get("username"),
                    (String) profileInfo.get("password"),
                    (int) profileInfo.get("userId"),
                    reviews,
                    favouriteBuildings,
                    favouriteRooms);
        }
        return null;
    }

    @Override
    public String getUsername(int userID) {
        Map<String, Object> profileInfo = getProfile(userID);
        return (profileInfo != null) ? (String) profileInfo.get("username") : null;
    }

    @Override
    public List<Reviewable> getFavourites(int userID) {
        Map<String, Object> profileInfo = getProfile(userID);
        return (profileInfo != null) ? (List<Reviewable>) profileInfo.get("favourites") : null;
    }

    @Override
    public List<Building> getFavouriteBuildings(int userID) {
        Map<String, Object> profileInfo = getProfile(userID);
        List<String> favouriteBuildings = (profileInfo != null) ? (List<String>) profileInfo.get("favouriteBuildings") : null;

        if (favouriteBuildings != null) {
            List<Building> buildings = new ArrayList<>();
            for (String buildingCode : favouriteBuildings) {
                Building building = buildingDAO.getBuilding(buildingCode);
                if (building != null) {
                    buildings.add(building);
                }
            }
            return buildings;
        }
        return null;
    }
    // TODO: Don't know how rooms will be implemented
    @Override
    public List<Room> getFavouriteRooms(int userID) {
        Map<String, Object> profileInfo = getProfile(userID);
//        List<String> favouriteRooms = (profileInfo != null) ? (List<String>) profileInfo.get("favouriteRooms") : null;
//
//        // Assuming you have a method to get a Room by room number in RoomDataAccessObject
//        // Example: RoomDataAccessObject.getRoom(roomNumber);
//        if (favouriteRooms != null) {
//            List<Room> rooms = new ArrayList<>();
//            for (String roomNumber : favouriteRooms) {
//                Room room = RoomDataAccessObject.getRoom(roomNumber);
//                if (room != null) {
//                    rooms.add(room);
//                }
//            }
//            return rooms;
//        }
        return null;
    }
}
