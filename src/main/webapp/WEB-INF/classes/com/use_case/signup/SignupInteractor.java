package com.use_case.signup;

import com.entity.user.User;
import com.entity.user.UserFactory;

public class SignupInteractor implements SignupInputBoundary {

    final SignupOutputBoundary presenter;
    final UserFactory userFactory;
    final SignupUserDataAccessInterface userDataAccessObject;


    public SignupInteractor(SignupOutputBoundary presenter,
                            UserFactory userFactory,
                            SignupUserDataAccessInterface userDataAccessObject) {
        this.presenter = presenter;
        this.userFactory = userFactory;
        this.userDataAccessObject = userDataAccessObject;
    }

    @Override
    public void execute(SignupInputData inputData) {

        // check if the username already exists
        Integer user = userDataAccessObject.existsByUsername(inputData.getUsername());
        // If passwords are different, then it's easy.
        if (!inputData.getPassword().equals(inputData.getRepeatPassword()))
        {
            presenter.prepareFailView("Passwords don't match.");
        }
        else if (user != null) // username like that already exists. Check if password is the same.
        {
            // if passwords are the same, the user already exists, hence a fail. Otherwise, create another user
            if (userDataAccessObject.getUser(user).getPassword().equals(inputData.getPassword()))
            {
                presenter.prepareFailView("User already exists.");
            }
            else
            {
                createUser(inputData);
                prepareSuccess(inputData);
            }
        }
        else
        {
            // creates the user
            createUser(inputData);
            prepareSuccess(inputData);
        }
    }
    private void createUser(SignupInputData inputData)
    {
        User user = userFactory.create(inputData.getUsername(), inputData.getPassword(), inputData.getId());
        userDataAccessObject.save(user);
    }
    private void prepareSuccess(SignupInputData inputData)
    {
        SignupOutputData outputData = new SignupOutputData(inputData.getUsername(), inputData.getId());
        // send the output data to the presenter
        presenter.prepareSuccessView(outputData);
    }
}

