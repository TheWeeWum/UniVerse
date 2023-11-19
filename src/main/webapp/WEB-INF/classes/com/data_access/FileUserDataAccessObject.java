package com.data_access;

import com.entity.user.LoggedInUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import com.entity.user.User;
import com.use_case.signup.SignupUserDataAccessInterface;
import com.entity.user.UserFactory;
import com.use_case.login.LoginUserDataAccessInterface;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface {

    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<Integer, User> accounts;
    private final String filePath = "UserData.json";
    File file = new File("UserData.json");
    /**
     * The filePath must lead a json file with the right format suitable for gson to parse.
     * */
    public FileUserDataAccessObject() throws IOException {
        accounts = new HashMap<>();
        populateAccountsFromJson();

    }
    // The populate method works correctly.
    public void populateAccountsFromJson()
    {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("UserDataBase.json");
            // Use the inputStream to read the file content
            // Example: You can use libraries like Gson or Jackson to parse the JSON content

        try (Reader reader = new InputStreamReader(inputStream))
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

    // TODO I still have to fix it, as even though the code works when I test it locally,
    //  it has trouble finding the file, and savig the user in it once I run it on the server, which is very weird.
    //  Like, it works completely fine when you test ut from IntelliJ,
    //  but refuses to save the user once you are on the server.

    @Override
    public void save(User user) {
        System.out.println("Saving user: " + user.getUsername() + " " + user.getPassword());
        accounts.put(user.getId(), user);
        // UserData.json is our main file where users will be stored, so there's no reason
        // to pass an additional variable to the addUserToJsonFile method
//        URL resourceUrl = getClass().getResource("/UserData.json");
//        String filePath = resourceUrl != null ? resourceUrl.getPath() : null;
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("UserData.json");
//        System.out.println("File Path: " + inputStream); // Check the retrieved file path
        //print every id of every user
        //accounts.keySet().forEach(System.out::println);


        addUserToJsonFile();
    }

    @Override
    public User get(Integer id) {
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

        try (Writer writer = new FileWriter(file)) {
            Gson gson = new Gson();
            gson.toJson(accounts, writer);
        } catch (IOException e) {
            System.out.println("Error writing to file Vania: " + e.getMessage());
        }
    }

    public Map<Integer, User> getAccounts() {
        return accounts;
    }
}
