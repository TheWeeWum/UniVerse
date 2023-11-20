package com.entity.user;

public class Guest implements User {

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
}
