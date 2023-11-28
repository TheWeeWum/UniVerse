package com.use_case.login;

public interface LoginOutputBoundary {
    void prepareFailView(String s);
    void prepareSuccessView(LoginOutputData outputData);
}
