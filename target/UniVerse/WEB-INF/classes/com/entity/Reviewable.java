package com.entity;

import com.entity.review.Review;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class Reviewable {
    private final List<Review> reviews;
    private float rating;

    /**
     * @param reviews the list of reviews
     */
    public Reviewable(List<Review> reviews) {
        this.reviews = reviews;
        this.rating = calculateRating();
    }

    // READ
    /** TODO: Is there a way to access a review specifically?
     * @param unknown
     * @return the review at the specified __unknown__
     */
    Review getReview(String unknown) {
        return null;
    }

    /**
     * @return the rating of the reviewable object
     */
    float getRating() {
        return rating;
    }

    // UPDATE
    /**
     * Takes in a new review to add to the abject. Add this review to the list of reviews
     * and recalculate the rating of the reviewable object
     * @param review the review to add to the list of reviews
     */
    void rate(Review review) {
        reviews.add(review);
        rating = calculateRating();
    }

    private float calculateRating() {
        float total = 0;
        int numOfReviews = 0;
        for (Review r : reviews) {
            total += r.getRating();
            numOfReviews++;
        }
        return total/numOfReviews;
    }

    // DELETE
    /**
     * Removes the specified review from the reviewable objects list of reviews
     *
     * @param review the review to be removed from the reviewable objects list of reviews
     * @return true if the review was removed successfully otherwise returns false
     */
    public boolean deleteReview(Review review) {
        // TODO: Might need to be changed depending on how we uniquely quantify each review
        try {
            reviews.remove(review);
            return true;
        } catch (NoSuchElementException e) {
            // review was not in the users reviews
            return false;
        }
    }
}
