package com.entity.event;

import com.entity.JsonRepresentation;
import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.review.Review;
import com.entity.room.Room;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements JsonRepresentation {
    private final String name;
    private final String organizer;
    private Reviewable location;
    private final Date date;

    // TODO: Only if we have time
    // private List<User> attendies;

    /**
     * @param name the name of the event
     * @param organizer the organizer of the event (String)
     * @param location where the Event is taking place
     * @param date the date the event is happening on
     */
    public Event(String name, String organizer, Reviewable location, Date date) {
        this.name = name;
        this.organizer = organizer;
        this.location = location;
        this.date = date;
    }

    /**
     * @return the events name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * @return the events organizer as a String
     */
    public String getOrganizer() {
        return organizer;
    }

    /**
     * @return the events location as a Building or a Room
     */
    public Reviewable getLocation() {
        return location;
    }

    /**
     * @return the events Date as a Date object
     */
    public Date getDate() {
        return date;
    }

    /**
     * sets the location of the event (for use with the data access objects only)
     */
    protected void setLocation(Reviewable location) {
        this.location = location;
    }

    /**
     * Gets the Json representation of the Event Object in the following format.
     * <pre>
     * {
     *      name: String
     *      organizer: String
     *      location:
     *              {
     *                  depends on location type
     *              }
     *      date: String
     * }
     * </pre>
     * @return String in Json format:
     */
    @Override
    public String getJsonRepresentation() {
        String time = date.toString();
        return "{" +
                "\"name\": \"" + name + "\"" +
                "," +
                "\"organizer\": \"" + organizer + "\"" +
                "," +
                "\"location\": " + location.getDeadEndJson() +
                "," +
                "\"date\": \"" + time + "\"" +
                "}";
    }

    /**
     * Gets the Json representation of the Event Object in the following format.
     * <pre>
     * {
     *      name: String
     *      organizer: String
     *      location:
     *              {
     *                  depends on location type
     *              }
     *      date: String
     * }
     * </pre>
     * @return String in Json format:
     */
    @Override
    public String getDeadEndJson() {
        return getJsonRepresentation();
    }
}
