package com.use_case.open_myreviews;

import com.entity.review.Review;
import com.entity.user.User;

import java.util.Date;
import java.util.List;

public class OpenReviewOutputData {
    private final List<Review> reviews;
    public OpenReviewOutputData(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }

}
