package entity.room;

public class Lecture extends Room {
    public Lecture(String roomNumber, String floor, int capacity, boolean outletsAvailable) {
        super(roomNumber, floor, capacity, outletsAvailable);
    }

    public Lecture(String roomNumber, String floor, int capacity) {
        super(roomNumber, floor, capacity);
    }
}
