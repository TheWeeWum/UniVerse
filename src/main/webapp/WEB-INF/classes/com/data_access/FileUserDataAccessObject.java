package com.data_access;

import com.entity.user.LoggedInUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import com.entity.user.User;
import com.use_case.signup.SignupUserDataAccessInterface;
import com.use_case.login.LoginUserDataAccessInterface;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface {

    private final Map<Integer, User> accounts;

    // THE ABSOLUTE PATH IS DIFFERENT FOR EVERYONE. TO FIND IT, RIGHT CLICK ON THE UserData.json FILE,
    // CLICK ON "COPY PATH/REFERENCE",
    // Pick "ABSOLUTE PATH" and paste it below.
    private final String filePath = Path.path + "external-data/UserDataBase.json";

    public FileUserDataAccessObject() {
        accounts = new HashMap<>();
        populateAccountsFromJson();

    }
    // The populate method works correctly.
    public void populateAccountsFromJson()
    {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("UserDataBase.json");
            // Use the inputStream to read the file content
            // Example: You can use libraries like Gson or Jackson to parse the JSON content

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            Gson gson = new Gson();
            Type userType = new TypeToken<Map<Integer, LoggedInUser>>() {}.getType();

            // Parse JSON into Map<Integer, User>
            Map<Integer, LoggedInUser> users = gson.fromJson(reader, userType);

            // Populate the 'accounts' map with data from JSON
            accounts.putAll(users);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getId(), user);
        // UserData.json is our main file where users will be stored, so there's no reason
        // to pass an additional variable to the addUserToJsonFile method
        addUserToJsonFile();
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
            System.out.println("Error writing to file:" + e.getMessage());
        }
    }

    public Map<Integer, User> getAccounts() {
        return accounts;
    }
}
