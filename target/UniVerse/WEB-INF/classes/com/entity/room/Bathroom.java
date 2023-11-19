package com.entity.room;

import com.entity.review.Review;

import java.util.List;

public class Bathroom extends Room {

    private final String gender;

    /**
     * @param roomNumber the room number on the room (String).
     * @param floor the floor the room is on (String).
     * @param capacity the capacity of the room.
     * @param reviews the list of reviews that people have left for the room.
     * @param outletsAvailable whether the room has outlets available or not
     *                         (If you don't include this it will default to false).
     * @param gender the gender prescribed to the bathroom. Should be in 1 of 3 states (male, female, unisex).
     */
    public Bathroom(String roomNumber, String floor, int capacity, List<Review> reviews, boolean outletsAvailable, String gender) {
        super(roomNumber, floor, capacity, reviews, outletsAvailable);
        this.gender = gender;
    }

    /**
     * @param roomNumber the room number on the room (String).
     * @param floor the floor the room is on (String).
     * @param capacity the capacity of the room.
     * @param reviews the list of reviews that people have left for the room.
     *  @param gender the gender prescribed to the bathroom. Should be in 1 of 3 states (male, female, unisex).
     */
    public Bathroom(String roomNumber, String floor, int capacity, List<Review> reviews, String gender) {
        super(roomNumber, floor, capacity, reviews);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
