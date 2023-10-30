package entity;

import entity.review.Review;

import java.util.List;

public class Reviewable {
    private final List<Review> reviews;
    private float rating;

    public Reviewable(List<Review> reviews) {
        this.reviews = reviews;
        this.rating = calculateRating();
    }

    // READ
    // TODO: Is there a way to access a review specifically?
    Review getReview(String unknown) {
        return null;
    }
    float getRating() {
        return rating;
    }

    // UPDATE
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
    void deleteReview(Review review) {
        // TODO: implement this
    }
}
