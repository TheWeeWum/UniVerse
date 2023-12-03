package com.use_case.leave_review;

public interface ReviewOutputBoundary {
    void prepareSuccessView(ReviewOutputData outputData);
    void prepareFailView(String message);
}
