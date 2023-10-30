package entity.room;

public class Bathroom extends Room {

    private final String gender;

    public Bathroom(String roomNumber, String floor, int capacity, boolean outletsAvailable, String gender) {
        super(roomNumber, floor, capacity, outletsAvailable);
        this.gender = gender;
    }

    public Bathroom(String roomNumber, String floor, int capacity, String gender) {
        super(roomNumber, floor, capacity);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
