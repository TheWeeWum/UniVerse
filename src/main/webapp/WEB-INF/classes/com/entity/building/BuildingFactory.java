package com.entity.building;

import com.entity.event.Event;
import com.entity.review.Review;
import com.entity.room.Room;

import java.util.List;

public class BuildingFactory {
    public Building create(String code, String name, String shortname, String campus, Address address, List<Room> rooms, List<String> floor, Location location, List<Review> reviews, List<Event> events) {
        return new Building(code, name, shortname, campus, address, null, null, null, null, events);
    }

}
