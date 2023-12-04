package com.use_case.login;

import javax.servlet.ServletException;
import java.io.IOException;

public class LoginInteractor implements LoginInputBoundary{

    private LoginOutputBoundary presenter;
    private LoginUserDataAccessInterface userDataAccessObject;

    public LoginInteractor(LoginOutputBoundary presenter, LoginUserDataAccessInterface userDataAccessObject) {
        this.presenter = presenter;
        this.userDataAccessObject = userDataAccessObject;
    }


    @Override
    public void execute(LoginInputData inputData) throws ServletException, IOException {
        // check if the username already exists
        Integer userId = userDataAccessObject.existsByUsernameAndPassword(inputData.getUsername(), inputData.getPassword());
        if (userId == null)
        {
            presenter.prepareFailView("User with the following credentials doesn't exist.");
        }
        else
        {
            LoginOutputData outputData = new LoginOutputData(inputData.getUsername(), userId);
            presenter.prepareSuccessView(outputData);
        }
    }
}
