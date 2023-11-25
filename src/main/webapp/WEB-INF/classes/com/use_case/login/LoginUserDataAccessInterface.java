package com.use_case.login;

import com.entity.user.User;

public interface LoginUserDataAccessInterface {

    void save(User user);

    User get(Integer id);
}
