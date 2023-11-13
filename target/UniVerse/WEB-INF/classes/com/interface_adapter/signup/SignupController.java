package com.interface_adapter.signup;

import com.use_case.signup.SignupInputBoundary;
import com.use_case.signup.SignupInputData;

public class SignupController {
    private final SignupInputBoundary userSignupUserCaseInteracter;

    public SignupController(SignupInputBoundary userSignupUserCaseInteracter) {
        this.userSignupUserCaseInteracter = userSignupUserCaseInteracter;
    }

    public void execute(String username, String password1, String password2) {
        // create the input data to send to the use_case
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2);

        // call the use_case interactor sending the input data
        userSignupUserCaseInteracter.execute(signupInputData);
    }
}
