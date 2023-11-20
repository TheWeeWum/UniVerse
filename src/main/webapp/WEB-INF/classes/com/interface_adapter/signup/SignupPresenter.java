package com.interface_adapter.signup;

import com.use_case.signup.SignupOutputBoundary;
import com.use_case.signup.SignupOutputData;
import com.view.User.SignupServlet;

import java.io.IOException;

public class SignupPresenter implements SignupOutputBoundary {
    SignupServlet signupServlet;

    public SignupPresenter(SignupServlet signupServlet) {
        this.signupServlet = signupServlet;
    }

    @Override
    public void execute(SignupOutputData outputData) {
        // TODO: decide whether to go to the profile page
        // or to send the user back to the signup page
        // may require changes to the use_case interactor
        try {
            signupServlet.sendToProfileScreen(outputData);
        } catch (IOException e) {
            System.out.println("Error in sending user to ProfileScreen");
        }
    }
}
