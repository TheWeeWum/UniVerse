package com.data_access;
import com.app.Path;
import com.entity.building.Building;
import com.entity.building.BuildingBuilder;
import com.entity.review.Review;
import com.entity.review.ReviewBuilder;
import com.entity.room.Room;
import com.entity.user.LoggedInUser;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import com.entity.user.User;
import com.use_case.leave_review.ReviewDataAccessInterface;
import com.use_case.open_favourites.OpenFavouritesDataAccessInterface;
import com.use_case.signup.SignupUserDataAccessInterface;
import com.use_case.login.LoginUserDataAccessInterface;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, ReviewDataAccessInterface, OpenFavouritesDataAccessInterface {

    private final Map<Integer, LoggedInUser> accounts;
    private final BuildingDataAccessObject buildingDAO;

    // THE ABSOLUTE PATH IS DIFFERENT FOR EVERYONE. TO FIND IT, RIGHT CLICK ON THE UserData.json FILE,
    // CLICK ON "COPY PATH/REFERENCE",
    // Pick "ABSOLUTE PATH" and paste it below.
    private final String filePath;
    public FileUserDataAccessObject(String filePath, BuildingDataAccessObject buildingDataAccessObject) {
        accounts = new HashMap<>();
        this.filePath = filePath;
        this.buildingDAO = buildingDataAccessObject;
        populateAccountsFromJson();
    }

    // The populate method works correctly.
    public void populateAccountsFromJson()
    {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("UserDataBase.json");
            // Use the inputStream to read the file content
            // Example: You can use libraries like Gson or Jackson to parse the JSON content

        try
        {
            JsonObject jsonUsers = JsonParser.parseReader(new FileReader(filePath)).getAsJsonObject();
            int id;
            for (String s : jsonUsers.keySet()) {
                JsonObject userObject = jsonUsers.get(s).getAsJsonObject();

                String username = userObject.get("username").getAsString();
                String password = userObject.get("password").getAsString();
                id = userObject.get("id").getAsInt();

                List<Review> reviews = new ArrayList<>();
                JsonArray reviewsJson = userObject.get("reviews").getAsJsonArray();
                for (JsonElement review : reviewsJson) {
                    JsonObject reviewJson = review.getAsJsonObject();
                    int reviewUserID = reviewJson.get("userID").getAsInt();
                    String reviewUsername = reviewJson.get("username").getAsString();
                    Date reviewDate = null;
                    try {
                        String dateString = reviewJson.get("date").getAsString();
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        reviewDate = df.parse(dateString);
                    } catch (ParseException e) {
                        System.out.println("Could not parse date from UserReview");
                    }
                    String reviewTitle = reviewJson.get("title").getAsString();
                    String reviewContent = reviewJson.get("content").getAsString();
                    float reviewRating = reviewJson.get("rating").getAsFloat();

                    // TODO: turn into review builder
                    reviews.add(new Review(reviewUserID, reviewUsername, reviewDate, reviewTitle, reviewContent, reviewRating));
                }

                List<Building> favouriteBuildings = new ArrayList<>();
                JsonArray favBuildingsJson = userObject.get("favouriteBuildings").getAsJsonArray();
                for (JsonElement favBuilding : favBuildingsJson) {
                    Building building = buildingDAO.getBuilding(favBuilding.getAsString());
                    favouriteBuildings.add(building);
                }

                List<Room> favouriteRooms = new ArrayList<>();
                JsonArray favRoomsJson = userObject.get("favouriteBuildings").getAsJsonArray();
                for (JsonElement favRoom : favRoomsJson) {
//                    Room favouriteRoom = ...
//                    favouriteRooms.add(favouriteRoom);
                }

                LoggedInUser loggedInUser = new LoggedInUser(username, password, id, reviews, favouriteBuildings, favouriteRooms);

                // Populate the 'accounts' map with data from JSON
                accounts.put(id, loggedInUser);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getId(), (LoggedInUser) user);
        // UserData.json is our main file where users will be stored, so there's no reason
        // to pass an additional variable to the addUserToJsonFile method
        LoggedInUser loggedInUser;
        try {
            loggedInUser = (LoggedInUser) user;
        } catch (ClassCastException e) {
            System.out.println("Tried to save Guest to UserDataBase in FileUserDataAccessObject");
            return;
        }
        try {
            JsonObject jsonUsers = JsonParser.parseReader(new FileReader(filePath)).getAsJsonObject();
            JsonObject userJson = new JsonObject();
            userJson.addProperty("username", loggedInUser.getUsername());
            userJson.addProperty("password", loggedInUser.getPassword());
            userJson.addProperty("id", loggedInUser.getId());

            JsonArray reviewsJson = new JsonArray();
            for (Review review : loggedInUser.getReviews()) {
                JsonObject reviewJson = new JsonObject();
                reviewJson.addProperty("userID", loggedInUser.getId());
                reviewJson.addProperty("username", loggedInUser.getUsername());

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String timeAsString = df.format(review.getDate());
                reviewJson.addProperty("date", timeAsString);

                reviewJson.addProperty("title", review.getTitle());
                reviewJson.addProperty("content", review.getContent());
                reviewJson.addProperty("rating", review.getRating());

                reviewsJson.add(reviewJson);
            }
            userJson.add("reviews", reviewsJson);

            JsonArray favouriteBuildingsJson = new JsonArray();
            for (Building building : loggedInUser.getFavouriteBuildings()) {
                favouriteBuildingsJson.add(building.getCode());
            }
            userJson.add("favouriteBuildings", favouriteBuildingsJson);

            // TODO: when rooms are implemented
            userJson.add("favouriteRooms", new JsonArray());

            jsonUsers.add("" + loggedInUser.getId(), userJson);

            Gson gson = new Gson();
            FileWriter file = new FileWriter(filePath);
            file.write(gson.toJson(jsonUsers));
            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // addUserToJsonFile();
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public Integer existsByUsernameAndPassword(String username, String password) {
        for (User user : accounts.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getId();
            }
        }
        return null;
    }

    @Override
    public Integer existsByUsername(String username) {
        for (User user : accounts.values()) {
            if (user.getUsername().equals(username)) {
                return user.getId();
            }
        }
        return null;
    }

    @Override
    public User getUser(Integer id) {
        return accounts.get(id);
    }

    /**
    This method assumes that the accounts Map has been updated. Basically, it rewrites the json file.
    Why? The nature of Json files makes it difficult
    to "change" them by appending the new user to the end of the file, so we rewrite it completely.
     */
    public void addUserToJsonFile() {

        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(accounts, writer);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public Map<Integer, LoggedInUser> getAccounts() {
        return accounts;
    }

    @Override
    public void saveReview(Review review) {
        try {
            // get jsonReviews object
            Object obj = JsonParser.parseReader(new FileReader(filePath));
            JsonObject mainObject = (JsonObject) obj;
            JsonObject user = mainObject.get("" + review.getUser()).getAsJsonObject();
            JsonArray reviews = user.get("reviews").getAsJsonArray();

            // create new JsonReview object
            JsonObject reviewJson = new JsonObject();
            reviewJson.addProperty("userID", review.getUser());
            reviewJson.addProperty("username", review.getUsername());

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String timeAsString = df.format(review.getDate());
            reviewJson.addProperty("date", timeAsString);

            reviewJson.addProperty("title", review.getTitle());
            reviewJson.addProperty("content", review.getContent());
            reviewJson.addProperty("rating", review.getRating());

            reviews.add(reviewJson);

            Gson gson = new Gson();
            FileWriter file = new FileWriter(filePath);
            file.write(gson.toJson(mainObject));
            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("Could not find file in saveReview FUDAO");
        }
    }

    public void addReview(String review) {

    }


    @Override
    public LoggedInUser findUser(int userId) {
        for (LoggedInUser user : accounts.values()) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<Building> getFavouriteBuildings(int userId) {
        return accounts.get(userId).getFavouriteBuildings();
    }
}
