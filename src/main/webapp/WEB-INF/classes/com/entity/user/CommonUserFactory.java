package com.entity.user;

public class CommonUserFactory implements UserFactory {
    public User create(String name, String password, int id)
    {
        return new LoggedInUser(name, password, id);
    }
}
