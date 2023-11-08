package com.interface_adapter.signup;

import com.use_case.signup.SignupInputBoundary;
import com.use_case.signup.SignupInputData;
import com.use_case.signup.SignupInteractor;

public class SignupController {
    final SignupInputBoundary userSignupUserCaseInteracter;

    public SignupController(SignupInputBoundary userSignupUserCaseInteracter) {
        this.userSignupUserCaseInteracter = userSignupUserCaseInteracter;
    }

    public void execute(String username, String password1, String password2) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2);

        userSignupUserCaseInteracter.execute(signupInputData);
    }
}
