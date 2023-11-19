package com.app;

import com.data_access.FileUserDataAccessObject;
import com.entity.user.CommonUserFactory;
import com.entity.user.LoggedInUser;
import com.entity.user.UserFactory;
import com.interface_adapter.signup.SignupController;
import com.interface_adapter.signup.SignupPresenter;
import com.use_case.signup.SignupInputBoundary;
import com.use_case.signup.SignupInteractor;
import com.use_case.signup.SignupOutputBoundary;
import com.use_case.signup.SignupUserDataAccessInterface;
import com.view.SignupServlet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

public class SignupSetup {
    public static SignupController setup(SignupServlet signupServlet) throws IOException {
        UserFactory userFactory = new CommonUserFactory();
        FileUserDataAccessObject userDataAccessObject =
                new FileUserDataAccessObject();

        // Log that the program got to this place
        System.out.println("SignupSetup.setup: userDataAccessObject = " + userDataAccessObject);
        SignupOutputBoundary presenter = new SignupPresenter(signupServlet);
        SignupInputBoundary interactor = new SignupInteractor(presenter, userFactory, userDataAccessObject);

        return new SignupController(interactor);
    }

}
