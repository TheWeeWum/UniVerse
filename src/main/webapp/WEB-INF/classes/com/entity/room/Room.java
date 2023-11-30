package com.entity.room;

import com.entity.JsonRepresentation;
import com.entity.Reviewable;
import com.entity.event.Event;
import com.entity.review.Review;

import java.util.List;

public class Room extends Reviewable implements JsonRepresentation {

    private final String roomNumber;
    private final String floor;
    private final int capacity;
    private final boolean outletsAvailable;
    // private List<Review> reviews;
    // private float rating;
    private List<Event> events;


    /**
     * @param roomNumber the room number on the room (String)
     * @param floor the floor the room is on (String)
     * @param capacity the capacity of the room
     * @param reviews the list of reviews that people have left for the room
     * @param outletsAvailable whether the room has outlets available or not
     *                         (If you don't include this it will default to false)
     * @param events the list of events taking place in this room
     */
    public Room(String roomNumber, String floor, int capacity, List<Review> reviews, List<Event> events, boolean outletsAvailable) {
        super(reviews);
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
        this.outletsAvailable = outletsAvailable;
        this.events = events;
    }

    /**
     * @param roomNumber the room number on the room (String)
     * @param floor the floor the room is on (String)
     * @param capacity the capacity of the room
     * @param reviews the list of reviews that people have left for the room
     * @param events the list of events taking place in this room
     */
    public Room(String roomNumber, String floor, int capacity, List<Review> reviews, List<Event> events) {
        super(reviews);
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
        this.outletsAvailable = false;
        this.events = events;
    }

    /**
     * @return the rooms room number as a String
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * @return the rooms floor as a String
     */
    public String getFloor() {
        return floor;
    }

    /**
     * @return the rooms capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return whether the room has outlets
     */
    public boolean getOutletAvailable() {
        return outletsAvailable;
    }

    /**
     * Gets the list of events taking place in this room.
     * @return the list of events taking place in this room.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Gets the string representation of the Room object.
     * @return the string representation of the Room object.
     */
    public String toString() {
        return roomNumber;
    }

    /**
     * Gets the Json representation of the Room Object in the following format.
     * <pre>
     * {
     *      room_number: String
     *      floor: String
     *      capacity: int
     *      reviews: [
     *                  {
     *
     *                  }
     *               ]
     *      events: [
     *                  {
     *
     *                  }
     *              ]
     * }
     * </pre>
     * @return String in Json format:
     */
    @Override
    public String getJsonRepresentation() {
        StringBuilder reviewsJson = new StringBuilder("[");
        for (Review review : reviews) {
            reviewsJson.append(review.getJsonRepresentation()).append(",");
        }
        if (!reviews.isEmpty()) {
            reviewsJson.deleteCharAt(reviewsJson.length() - 1);
        }
        reviewsJson.append("]");

        StringBuilder eventsJson = new StringBuilder("[");
        for (Event event : events) {
            eventsJson.append(event.getJsonRepresentation()).append(",");
        }
        if (!events.isEmpty()) {
            eventsJson.deleteCharAt(eventsJson.length() - 1);
        }
        eventsJson.append("]");

        return "{" +
                "room_number: " + roomNumber +
                "," +
                "floor: " + floor +
                "," +
                "capacity: " + capacity +
                "," +
                "reviews: " + reviewsJson +
                "," +
                "events: " + eventsJson +
                "}";

    }

    /**
     * Gets the Json representation of the Room Object in the following format.
     * <pre>
     * {
     *      room_number: String
     *      floor: String
     *      capacity: int
     * }
     * </pre>
     * @return String in Json format:
     */
    @Override
    public String getDeadEndJson() {
        return "{" +
                "room_number: " + roomNumber +
                "," +
                "floor: " + floor +
                "," +
                "capacity: " + capacity +
                "}";
    }
}
