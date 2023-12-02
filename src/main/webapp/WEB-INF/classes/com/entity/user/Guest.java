package com.entity.user;

public class Guest implements User {

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

}
