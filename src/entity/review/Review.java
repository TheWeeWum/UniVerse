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

    /**
     * @param user the user who wrote the review
     * @param timeWritten the time the review was written
     * @param title the title of the review
     * @param content the content of the review (String format only)
     * @param rating the rating of the review
     */
    public Review(LoggedInUser user, Date timeWritten, String title, String content, float rating) {
        this.user = user;
        this.timeWritten = timeWritten;
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
    public Date timeWritten() {
        return timeWritten;
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
