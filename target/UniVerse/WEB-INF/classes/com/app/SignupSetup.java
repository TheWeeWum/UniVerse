package com.app;

import com.interface_adapter.signup.SignupController;
import com.interface_adapter.signup.SignupPresenter;
import com.use_case.signup.SignupInputBoundary;
import com.use_case.signup.SignupInteractor;
import com.use_case.signup.SignupOutputBoundary;
import com.view.SignupServlet;

public class SignupSetup {
    public static SignupController setup(SignupServlet signupServlet) {
        SignupOutputBoundary presenter = new SignupPresenter(signupServlet);
        SignupInputBoundary interactor = new SignupInteractor(presenter);
        return new SignupController(interactor);
    }
}
