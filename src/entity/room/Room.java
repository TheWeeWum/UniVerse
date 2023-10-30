package entity.room;

import entity.Reviewable;
import entity.review.Review;

import java.util.List;

public class Room extends Reviewable {

    private final String roomNumber;
    private final String floor;
    private final int capacity;
    private final boolean outletsAvailable;


    public Room(String roomNumber, String floor, int capacity, boolean outletsAvailable, List<Review> reviews) {
        super(reviews);
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
        this.outletsAvailable = outletsAvailable;
    }

    public Room(String roomNumber, String floor, int capacity, List<Review> reviews) {
        super(reviews);
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
        this.outletsAvailable = false;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getFloor() {
        return floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean getOutletAvailable() {
        return outletsAvailable;
    }
}
