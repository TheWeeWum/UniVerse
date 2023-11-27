package com.use_case.building_reviews;

import com.entity.review.Review;

import java.util.List;

public class BuildingReviewsOutputData {
    private final List<Review> reviews;
    public BuildingReviewsOutputData(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
