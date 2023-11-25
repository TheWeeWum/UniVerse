package com.entity.room;

import com.entity.event.Event;
import com.entity.review.Review;

import java.util.List;

public class Tutorial extends Room {
    /**
     * @param roomNumber the room number on the room (String)
     * @param floor the floor the room is on (String)
     * @param capacity the capacity of the room
     * @param reviews the list of reviews that people have left for the room
     * @param outletsAvailable whether the room has outlets available or not
     *                         (If you don't include this it will default to false)
     */
    public Tutorial(String roomNumber, String floor, int capacity, List<Review> reviews, List<Event> events, boolean outletsAvailable) {
        super(roomNumber, floor, capacity, reviews, events, outletsAvailable);
    }

    /**
     * @param roomNumber the room number on the room (String)
     * @param floor the floor the room is on (String)
     * @param capacity the capacity of the room
     * @param reviews the list of reviews that people have left for the room
     */
    public Tutorial(String roomNumber, String floor, int capacity, List<Review> reviews, List<Event> events) {
        super(roomNumber, floor, capacity, reviews, events);
    }
}
