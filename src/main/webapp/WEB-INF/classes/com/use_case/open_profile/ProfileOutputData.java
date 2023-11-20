package com.use_case.open_profile;

import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.review.Review;
import com.entity.room.Room;
import com.entity.user.User;

import java.util.List;

public class ProfileOutputData {
    final private User user;

    public ProfileOutputData(User user) {
        this.user = user;

    }
    User getUser() {return user;}

}