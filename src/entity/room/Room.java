package entity.room;

import entity.Reviewable;
import entity.review.Review;

import java.util.List;

public class Room extends Reviewable {

    private final String roomNumber;
    private final String floor;
    private final int capacity;
    private final boolean outletsAvailable;


    /**
     * @param roomNumber the room number on the room (String)
     * @param floor the floor the room is on (String)
     * @param capacity the capacity of the room
     * @param reviews the list of reviews that people have left for the room
     * @param outletsAvailable whether the room has outlets available or not
     *                         (If you don't include this it will default to false)
     */
    public Room(String roomNumber, String floor, int capacity, List<Review> reviews, boolean outletsAvailable) {
        super(reviews);
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
        this.outletsAvailable = outletsAvailable;
    }

    /**
     * @param roomNumber the room number on the room (String)
     * @param floor the floor the room is on (String)
     * @param capacity the capacity of the room
     * @param reviews the list of reviews that people have left for the room
     */
    public Room(String roomNumber, String floor, int capacity, List<Review> reviews) {
        super(reviews);
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
        this.outletsAvailable = false;
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
}
