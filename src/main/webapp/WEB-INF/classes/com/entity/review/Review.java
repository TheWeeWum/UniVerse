package com.entity.review;

import com.entity.JsonRepresentation;
import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.room.Room;
import com.entity.user.Guest;
import com.entity.user.LoggedInUser;
import com.entity.user.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Date;

public class Review implements JsonRepresentation {
    private final int userId;
    private final Date date;
    private String title;
    private String content;
    private float rating;

    /**
     * @param userId the userId who wrote the review
     * @param date the time the review was written
     * @param title the title of the review
     * @param content the content of the review (String format only)
     * @param rating the rating of the review
     */
    public Review(int userId, Date date, String title, String content, float rating) {
        this.userId = userId;
        this.date = date;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    // TODO: add images if we want

    /**
     * @return the user who wrote the review
     */
    public int getUser() {
        return userId;
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
        if (user != null) {
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
        } else {
            return "{" +
                    "\"user\": " + new Guest().getJsonRepresentation() +
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
        if (user != null) {
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
        } else {
            return "{" +
                    "\"user\": " + new Guest().getDeadEndJson() +
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
    }
}
