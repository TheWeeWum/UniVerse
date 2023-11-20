package com.use_case.signup;

import com.entity.user.User;

public interface SignupUserDataAccessInterface {

    //saves the user to the database
    void save(User user);

    // If the user exists, return his id, Integer, so that password can be checked.
    // If the user doesn't exist, return null.
    Integer existsByUsername(String username);

    User getUser(Integer id);

}
