package com.use_case.login;

import com.use_case.signup.SignupInputData;

public interface LoginInputBoundary {
    void execute(LoginInputData inputData);
}
