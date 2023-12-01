package com.entity.review;

import com.entity.JsonRepresentation;
import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.room.Room;
import com.entity.user.LoggedInUser;
import com.entity.user.User;

import java.util.Date;

public class Review implements JsonRepresentation {
    private final LoggedInUser user;
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
        LoggedInUser user1;
        try {
            user1 = (LoggedInUser) user;
        } catch (ClassCastException e) {
            user1 = null;
            System.out.println("Non logged in user tried to create review");
        }
        this.user = user1;
        this.date = date;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    // TODO: add images if we want

    /**
     * @return the user who wrote the review
     */
    public LoggedInUser getUser() {
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

    /**
     * Gets the Json representation of the Review Object in the following format.
     * <pre>
     * {
     *      username: String
     *      userid: String
     *      date: String
     *      title: String
     *      content: String
     *      rating: float
     * }
     * </pre>
     * @return String in Json format:
     */
    @Override
    public String getJsonRepresentation() {
        return "{" +
                "\"user\": " + user.getJsonRepresentation() +
                "," +
                "\"date\": \"" + date.toString() + "\"" +
                "," +
                "\"title\": \"" + title + "\"" +
                "," +
                "\"rating\": " + rating +
                "," +
                "\"content\": \"" + content + "\"" +
                "}";
    }

    /**
     * Gets the Json representation of the Review Object in the following format.
     * <pre>
     * {
     *      username: String
     *      userid: String
     *      date: String
     *      title: String
     *      content: String
     *      rating: float
     * }
     * </pre>
     * @return String in Json format:
     */
    @Override
    public String getDeadEndJson() {
        return "{" +
                "\"user\": " + user.getDeadEndJson() +
                "," +
                "\"date\": \"" + date.toString() +
                "," +
                "\"title\": \"" + title + "\"" +
                "," +
                "\"rating\": " + rating +
                "," +
                "\"content\": \"" + content + "\"" +
                "}";
    }
}
