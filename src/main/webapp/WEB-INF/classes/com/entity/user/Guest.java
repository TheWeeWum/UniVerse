package com.entity.user;

import com.entity.JsonRepresentation;

public class Guest implements User, JsonRepresentation {

    // A constructor for the Guest class.
    String name;
    int id;
    public Guest() {
        this.name = "Guest";
        this.id = -1;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return "Guest";
    }

    @Override
    public String getPassword() {
        return null;
    }
    @Override
    public String toString() {
        return "Guest";
    }

    @Override
    public String getJsonRepresentation() {
        return "{\"username\": \"Guest\", \"id\": -1}";
    }

    @Override
    public String getDeadEndJson() {
        return "{\"username\": \"Guest\", \"id\": -1}";
    }
}
