package com.use_case.leave_review;

import com.entity.review.Review;
import com.entity.user.LoggedInUser;
import com.entity.user.User;

public interface ReviewDataAccessInterface {
    void saveReview(Review reviewInputData);
    LoggedInUser findUser(int userId);
}
