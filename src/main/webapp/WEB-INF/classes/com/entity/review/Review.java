package com.entity.review;

import com.entity.Reviewable;
import com.entity.user.LoggedInUser;
import com.entity.user.User;

import java.util.Date;

public class Review {
    private final User user;
    private final Date date;
    private String title;
    private String content;
    private float rating;

    /**
     * @param user the user who wrote the review
     * @param date the time the review was written
     * @param title the title of the review
     * @param content the content of the review (String format only)
     * @param rating the rating of the review
     */
    public Review(User user, Date date, String title, String content, float rating) {
        this.user = user;
        this.date = date;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    // TODO: add images if we want

    /**
     * @return the user who wrote the review
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the time the review was written
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the title of the review
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the content of the review in a String format
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the rating of the review
     */
    public float getRating() {
        return rating;
    }
}
