package com.entity.building;

import com.entity.JsonRepresentation;
import com.entity.Reviewable;
import com.entity.event.Event;
import com.entity.map.Pin;
import com.entity.review.Review;
import com.entity.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Building extends Reviewable implements JsonRepresentation {
    private final String code;
    private final String name;
    private final String shortname;
    private final String campus;
    private final Address address;
    private final List<Room> rooms;
    private final List<String> floors;
    private final Location location;
    // private List<Review> reviews;
    // private float rating;
    private List<Event> events;

    /**
     * @param code the code name of the building (MB).
     * @param name the name of the building.
     * @param shortname the abbreviation of the building's name
     * @param campus the campus the buildings is on.
     * @param address the address of the building.
     * @param rooms the list of rooms of the building.
     * @param floors the list of floors of the building.
     * @param location the location object to be attached to the building
     * @param reviews the list of reviews for the building.
     */
    public Building(String code, String name, String shortname, String campus, Address address, List<Room> rooms, List<String> floors, Location location, List<Review> reviews) {
        super(reviews);
        this.code = code;
        this.name = name;
        this.shortname = shortname;
        this.campus = campus;
        this.address = address;
        this.rooms = rooms;
        this.floors = floors;
        this.location = location;
    }

    /**
     * Gets the code name of the building (ie MB).
     * @return the code name of the building.
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the name of the building.
     * @return the name of the building.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the short name of the building.
     * @return the short name of the building.
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * Gets the campus the buildings is located on.
     * @return the campus the buildings is located on.
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Gets the address of the building.
     * @return the address of the building.
     */
    public Address getAddress() {
        return address;
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
     * Gets the location object of the building.
     * @return the location object of the building.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets the list of events taking place at this building.
     * @return the list of events taking place at this building.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Gets the list of reviews for the buildings.
     * @return the list of reviews for the buildings.
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * Gets the string representation of the Building object.
     * @return the string representation of the Building object.
     */
    public String toString() {
        return name;
    }

    /**
     * Gets the Json representation of the Building Object as follows.
     * <pre>
     * {
     *     name: String,
     *     code: String,
     *     shortname: String,
     *     campus: String,
     *     address: {
     *          street: String,
     *          city: String,
     *          province: String,
     *          country: String,
     *          postal: String
     *     },
     *     rooms: [
     *              {
     *                  room_number: String,
     *                  floor: String,
     *                  capacity: int,
     *                  outlets_available: true|false
     *              }, {...}, ...
     *            ],
     *     floors: [
     *              {floor: String}, {...}, ...
     *             ],
     *     lat: float,
     *     long: float,
     *     reviews: reviews,
     *     rating: float
     *     events: events
     * }
     * </pre>
     * @return String in Json format.
     */
    @Override
    public String getJsonRepresentation() {
        // See JavaDoc for detailed representation description

        StringBuilder roomsJson = new StringBuilder("[");
        for (Room room : rooms) {
            roomsJson.append(room.getJsonRepresentation()).append(",");
        }
        if (!rooms.isEmpty()) {
            roomsJson.deleteCharAt(roomsJson.length() - 1);
        }
        roomsJson.append("]");

        StringBuilder floorsJson = new StringBuilder("[");
        for (String floor : floors) {
            floorsJson.append("{").append(floor).append("}").append(",");
        }
        if (!floors.isEmpty()) {
            floorsJson.deleteCharAt(floorsJson.length() - 1);
        }
        floorsJson.append("]");

        StringBuilder reviewsJson = new StringBuilder("[");
        for (Review review : reviews) {
            reviewsJson.append("{").append(review.getJsonRepresentation()).append("}").append(",");
        }
        if (!reviews.isEmpty()) {
            reviewsJson.deleteCharAt(reviewsJson.length() - 1);
        }
        reviewsJson.append("]");

        StringBuilder eventsJson = new StringBuilder("[");
        for (Event event : events) {
            eventsJson.append("{").append(event.getJsonRepresentation()).append("}").append(",");
        }
        if (!events.isEmpty()) {
            eventsJson.deleteCharAt(eventsJson.length() - 1);
        }
        eventsJson.append("]");

        return "{" +
                    "name: " + name +
                    "," +
                    "code: " + code +
                    "," +
                    "shortname: " + shortname +
                    "," +
                    "campus: " + campus +
                    "," +
                    "address: " + address.getJsonRepresentation() +
                    "," +
                    "rooms: " + roomsJson +
                    "," +
                    "floors: " + floorsJson +
                    "," +
                    "lat: " + location.getLatitude() +
                    "," +
                    "long: " + location.getLongitude() +
                    "," +
                    "reviews: " + reviewsJson +
                    "," +
                    "events: " + eventsJson +
                "}";

    }

    /**
     * Gets the Json representation of the Building Object as follows.
     * <pre>
     * {
     *     name: String,
     *     code: String,
     *     shortname: String,
     *     campus: String,
     *     address: {
     *          street: String,
     *          city: String,
     *          province: String,
     *          country: String,
     *          postal: String
     *     },
     *     lat: float,
     *     long: float
     * }
     * </pre>
     * @return String in Json format.
     */
    public String getDeadEndJson() {
        return "{" +
                "name: " + name +
                "," +
                "code: " + code +
                "," +
                "shortname: " + shortname +
                "," +
                "campus: " + campus +
                "," +
                "address: " + address.getJsonRepresentation() +
                "," +
                "lat: " + location.getLatitude() +
                "," +
                "long: " + location.getLongitude() +
                "}";
    }

    /**
     * @param events the list of events taking place in this building.
     */
    protected void setEvents(List<Event> events) {
        this.events = events;
    }
}
