package entity.review;

import entity.user.LoggedInUser;
import entity.user.User;

import java.util.Date;

public class Review {
    private final User user;
    private final Date timeWritten;
    private String title;
    private String content;
    private float rating;

    public Review(LoggedInUser user, Date timeWritten, String title, String content, float rating) {
        this.user = user;
        this.timeWritten = timeWritten;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    // TODO: add images if we want

    public User getUser() {
        return user;
    }

    public Date timeWritten() {
        return timeWritten;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public float getRating() {
        return rating;
    }
}
