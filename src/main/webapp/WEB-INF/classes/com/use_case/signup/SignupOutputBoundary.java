package com.use_case.signup;

public interface SignupOutputBoundary {

    void prepareFailView(String s);
    void prepareSuccessView(SignupOutputData outputData);
}
