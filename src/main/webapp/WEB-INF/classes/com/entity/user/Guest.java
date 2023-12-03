package com.entity.user;

import com.entity.JsonRepresentation;

public class Guest implements User, JsonRepresentation {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getUsername() {
        return "Guest";
    }

    @Override
    public String getPassword() {
        return null;
    }
    public Guest(){

    }

    @Override
    public String getJsonRepresentation() {
        return "{username: Guest, id: 0}";
    }

    @Override
    public String getDeadEndJson() {
        return "{username: Guest, id: 0}";
    }
}
