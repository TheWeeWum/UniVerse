package com.use_case.open_myreviews;

import com.entity.review.Review;

import java.util.List;

public interface OpenReviewDataAccessInterface {
    public List<Review> getReviews(int userID);

}
