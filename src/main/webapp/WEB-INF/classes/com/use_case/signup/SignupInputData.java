package com.use_case.signup;

public class SignupInputData {
    private final String username;
    private final String password;
    private final String repeatPassword;
    private final int id;

    public SignupInputData(String username, String password, String repeatPassword, int id) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public int getId() {return id;}
}
