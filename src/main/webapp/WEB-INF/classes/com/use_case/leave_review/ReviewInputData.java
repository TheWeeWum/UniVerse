package com.use_case.leave_review;

import java.util.Date;

public class ReviewInputData {
    Date dateTime;
    float rating;
    String reviewContent;
    String title;
    int userId;
    String buildingCode;
    public ReviewInputData(Date dateTime, float rating, String reviewContent, String title, int userId, String buildingCode)
    {
        this.dateTime = dateTime;
        this.rating = rating;
        this.reviewContent = reviewContent;
        this.title = title;
        this.userId = userId;
        this.buildingCode = buildingCode;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public float getRating() {
        return rating;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

}
