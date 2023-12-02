package com.interface_adapter.login;

import com.use_case.login.LoginOutputBoundary;
import com.use_case.login.LoginOutputData;
import com.view.User.LoginServlet;
import com.view.User.SignupServlet;

import javax.servlet.ServletException;
import java.io.IOException;

public class LoginPresenter implements LoginOutputBoundary {
    LoginServlet loginServlet;
    public LoginPresenter(LoginServlet loginServlet) {
        this.loginServlet = loginServlet;
    }

    @Override
    public void prepareFailView(String error) {
        try {
            loginServlet.signInFailed(error);
        } catch (IOException | ServletException e) {
            System.out.println("Error in sending user to SignUp Screen");

        }
    }

    @Override
    public void prepareSuccessView(LoginOutputData outputData) {
        try {
            loginServlet.sendToProfileScreen(outputData);
        } catch (IOException e) {
            System.out.println("Error in sending user to ProfileScreen");
        }
    }
}
