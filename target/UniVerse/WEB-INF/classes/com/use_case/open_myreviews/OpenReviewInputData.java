package com.use_case.open_myreviews;

import com.entity.review.Review;

public class OpenReviewInputData {

    final private Review review;

    public OpenReviewInputData(Review review){
        this.review = review;
    }

    Review getReview() {return review;}

}
