package com.use_case.building_reviews;

import com.entity.review.Review;

import java.util.List;

public interface BuildingReviewsDataAccessInterface {
    public List<Review> getReviews(String buildingCode);

    void saveReview(Review review, String buildingCode);
}
