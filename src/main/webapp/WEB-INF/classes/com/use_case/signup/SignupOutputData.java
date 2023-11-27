package com.use_case.signup;

public class SignupOutputData {
    private final String username;
    private final int id;

    public SignupOutputData(String username, int id) {
            this.username = username;
            this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Object getID() {
        return id;
    }
}
