package com.interface_adapter.signup;

import com.use_case.signup.SignupInputBoundary;
import com.use_case.signup.SignupInputData;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class SignupController {
    private final SignupInputBoundary userSignupUserCaseInteracter;

    public SignupController(SignupInputBoundary userSignupUserCaseInteracter) {
        this.userSignupUserCaseInteracter = userSignupUserCaseInteracter;
    }

    public void execute(HttpServletRequest request) {
        // get the username password and repeatedPassword from the input
        // fields in the jsp file.
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeated password");

        //The id of the user is the exact time of the creation of the user. Since it's exact to seconds,
        // the id will always be unique (If the program is run on one machine at a time)
        LocalDateTime time = LocalDateTime.now();
        int id = convertLocalDateTimeToInt(time);

        // create the input data to send to the use_case
        SignupInputData signupInputData = new SignupInputData(
                username, password, repeatedPassword, id);

        // call the use_case interactor sending the input data
        userSignupUserCaseInteracter.execute(signupInputData);
    }

    public static int convertLocalDateTimeToInt(LocalDateTime dateTime) {
        int combinedInt = dateTime.getYear() * 100000000
                + dateTime.getMonthValue() * 1000000
                + dateTime.getDayOfMonth() * 10000
                + dateTime.getHour() * 10000
                + dateTime.getMinute() * 100
                + dateTime.getSecond(); // Adding seconds

        return combinedInt;
    }
}
