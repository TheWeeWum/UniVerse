package com.app;

import com.data_access.FileUserDataAccessObject;
import com.interface_adapter.login.LoginController;
import com.interface_adapter.login.LoginPresenter;
import com.use_case.login.LoginInputBoundary;
import com.use_case.login.LoginInteractor;
import com.use_case.login.LoginOutputBoundary;
import com.view.User.LoginServlet;

import java.io.IOException;

public class LoginSetup {
    public static LoginController setup(LoginServlet loginServlet) throws IOException {
        FileUserDataAccessObject userDataAccessObject = DataAccessBuilder.getFileUserDataAccessObject();

        LoginOutputBoundary presenter = new LoginPresenter(loginServlet);
        LoginInputBoundary interactor = new LoginInteractor(presenter, userDataAccessObject);

        return new LoginController(interactor);
    }
}
