package com.use_case.login;

import com.use_case.signup.SignupInputData;

import javax.servlet.ServletException;
import java.io.IOException;

public interface LoginInputBoundary {
    void execute(LoginInputData inputData) throws ServletException, IOException;
}
