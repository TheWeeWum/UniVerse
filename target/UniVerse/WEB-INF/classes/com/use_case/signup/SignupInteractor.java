package com.use_case.signup;

public class SignupInteractor implements SignupInputBoundary {

    SignupOutputBoundary profilePresenter;
    public SignupInteractor(SignupOutputBoundary profilePresenter) {
        this.profilePresenter = profilePresenter;
    }

    @Override
    public void execute(SignupInputData inputData) {
        // TODO: logic code to go here
        // Need to create the user in the database
        // get the required information on the user

        // create the output data passing the relevant user information
        SignupOutputData outputData = new SignupOutputData("DATABASE get not in yet");

        // send the output data to the presenter
        profilePresenter.execute(outputData);
    }
}
