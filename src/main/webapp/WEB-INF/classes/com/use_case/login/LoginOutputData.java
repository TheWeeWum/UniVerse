package com.use_case.login;

public class LoginOutputData {

    private final String username;
    private final int id;

    public LoginOutputData(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public Object getId() {
        return id;
    }
}
