package com.entity.review;

import com.entity.user.User;

import java.util.Date;

public class ReviewBuilder {
    // TODO maybe need to change User to LoggedInUser
    public Review create(int userId, Date timeWritten, String title, String content, float rating) {
        return new Review(userId, timeWritten, title, content, rating);
    }
}
