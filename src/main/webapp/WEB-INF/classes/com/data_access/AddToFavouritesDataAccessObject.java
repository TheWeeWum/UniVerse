package com.data_access;

import com.entity.building.BuildingBuilder;
import com.entity.user.UserFactory;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.use_case.add_to_favourites.AddToFavouritesDataAccessInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddToFavouritesDataAccessObject implements AddToFavouritesDataAccessInterface {
    String buildingPath;
    BuildingBuilder buildingFactory;
    String userPath;
    UserFactory userFactory;

    public AddToFavouritesDataAccessObject(String buildingPath, BuildingBuilder buildingFactory, String userPath, UserFactory userFactory){
        this.buildingPath = buildingPath;
        this.buildingFactory = buildingFactory;
        this.userPath = userPath;
        this.userFactory = userFactory;
    }

    @Override
    public void addFavourite(int userId, String buildingCode) {
        // List<String> favouriteBuildings = new ArrayList<>();
        JsonObject user = new JsonObject();

        try {
            JsonObject jsonUsers = JsonParser.parseReader(new FileReader(userPath)).getAsJsonObject();

            // searching for user
            for (String key: jsonUsers.keySet()) {
                if (Integer.parseInt(key) == userId) {

                    // getting user's favourited buildings
                    JsonArray favouriteBuildingsJsonArray = jsonUsers.get(key).getAsJsonObject().getAsJsonArray("favouriteBuildings");

                    // checking if building already in favourites
                    boolean buildingInFavourites = false;
                    for (JsonElement element : favouriteBuildingsJsonArray) {
                        String stringValue = element.getAsString();
                        if (stringValue.equals(buildingCode)) {
                            buildingInFavourites = true;
                        }
                    }

                    if (!buildingInFavourites) {
                        favouriteBuildingsJsonArray.add(buildingCode);
                    }

                    // updating file
                    try (FileWriter fileWriter = new FileWriter(userPath)) {
                        Gson gson = new Gson();
                        gson.toJson(jsonUsers, fileWriter);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (FileNotFoundException e) {

        }
    }
}

