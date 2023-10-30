package entity.building;

import entity.Reviewable;
import entity.map.Pin;
import entity.review.Review;
import entity.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Building extends Reviewable {
    private final String name;
    private final String address;
    private List<Room> rooms;
    private List<String> floors;
    private Location location;
    private Pin pin;

    public Building(String name, String address, List<Room> rooms, List<String> floors, Location location, Pin pin, List<Review> reviews) {
        super(reviews);
        this.name = name;
        this.address = address;
        this.rooms = rooms;
        this.floors = floors;
        this.location = location;
        this.pin = pin;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Location getLocation() {
        return location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getRooms(String floor) {
        List<Room> roomsOnFloor = new ArrayList<Room>();
        for (Room room : rooms) {
            if (room.getFloor().equals(floor)) {
                roomsOnFloor.add(room);
            }
        }
        return roomsOnFloor;
    }

    public Room getRoom(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public List<String> getFloors() {
        return floors;
    }

    public Pin getPin() {
        return pin;
    }


}
