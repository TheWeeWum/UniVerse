package com.entity.building;

import com.entity.Reviewable;
import com.entity.map.Pin;
import com.entity.review.Review;
import com.entity.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Building extends Reviewable {
    private final String name;
    private final String shortname;
    private final String address;
    private final List<Room> rooms;
    private final List<String> floors;
    private final Location location;
    private final Pin pin;

    /**
     * @param name the name of the building.
     * @param shortname the abbreviation of the building's name
     * @param address the address of the building.
     * @param rooms the list of ooms of the building.
     * @param floors the list of floors of the building.
     * @param location the location object to be attatched to the building
     * @param pin of the building on the main map
     * @param reviews the list of reviews for the building.
     */
    public Building(String name, String shortname, String address, List<Room> rooms, List<String> floors, Location location, Pin pin, List<Review> reviews) {
        super(reviews);
        this.name = name;
        this.shortname = shortname;
        this.address = address;
        this.rooms = rooms;
        this.floors = floors;
        this.location = location;
        this.pin = pin;

    }

    /**
     * Gets the name of the building.
     * @return the name of the building.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the address of the building.
     * @return the address of the building.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the location object of the building.
     * @return the location object of the building.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets the list of rooms of the building.
     * @return the list of rooms of the building.
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Gets the list of rooms on the specified floor of the building.
     *
     * @param floor the floor which we want the rooms from.
     * @return the list of rooms on the specified floor of the building.
     */
    public List<Room> getRooms(String floor) {
        List<Room> roomsOnFloor = new ArrayList<Room>();
        for (Room room : rooms) {
            if (room.getFloor().equals(floor)) {
                roomsOnFloor.add(room);
            }
        }
        return roomsOnFloor;
    }

    /**
     * Gets the room of the specified room number.
     *
     * @param roomNumber the room number associated with the room.
     * @return the room with the specified room number.
     */
    public Room getRoom(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Gets the list of floors of the building.
     * @return the list of floors of the building.
     */
    public List<String> getFloors() {
        return floors;
    }

    /**
     * Gets the pin attached to the building.
     * @return the pin attached to the building.
     */
    public Pin getPin() {
        return pin;
    }


}
