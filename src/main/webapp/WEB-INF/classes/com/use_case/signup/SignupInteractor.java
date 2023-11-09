package com.use_case.signup;

public class SignupInteractor implements SignupInputBoundary {

    SignupOutputBoundary profilePresenter;
    public SignupInteractor(SignupOutputBoundary profilePresenter) {
        this.profilePresenter = profilePresenter;
    }

    @Override
    public void execute(SignupInputData inputData) {
        // TODO: logic code to go here
        SignupOutputData outputData = new SignupOutputData("DATABASE get not in yet");
        profilePresenter.execute(outputData);
    }
}
