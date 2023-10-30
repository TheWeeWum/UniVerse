package entity.room;

public class Tutorial extends Room {
    public Tutorial(String roomNumber, String floor, int capacity, boolean outletsAvailable) {
        super(roomNumber, floor, capacity, outletsAvailable);
    }

    public Tutorial(String roomNumber, String floor, int capacity) {
        super(roomNumber, floor, capacity);
    }
}
