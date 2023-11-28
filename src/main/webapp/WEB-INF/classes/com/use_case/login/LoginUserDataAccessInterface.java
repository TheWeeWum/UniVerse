package com.use_case.login;

import com.entity.user.User;

public interface LoginUserDataAccessInterface {


    User get(Integer id);

    Integer existsByUsernameAndPassword(String username, String password);
}
