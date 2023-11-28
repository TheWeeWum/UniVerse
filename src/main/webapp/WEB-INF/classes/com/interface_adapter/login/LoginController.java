package com.interface_adapter.login;

import com.use_case.login.LoginInputBoundary;
import com.use_case.login.LoginInputData;

import javax.servlet.http.HttpServletRequest;

public class LoginController {
private final LoginInputBoundary interactor;

    public LoginController(LoginInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(HttpServletRequest request) {
        // get the username password and repeatedPassword from the input
        // fields in the jsp file.
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // create the input data to send to the use_case
        LoginInputData loginInputData = new LoginInputData(username, password);

        // call the use_case interactor sending the input data
        interactor.execute(loginInputData);
    }
}
