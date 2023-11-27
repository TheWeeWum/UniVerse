package com.use_case.open_profile;
import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.room.Room;
import com.entity.user.LoggedInUser;
import com.entity.user.User;

import java.util.List;


public interface ProfileUserDataAccessInterface {
    LoggedInUser getUser();

    String getUsername();
    List<Reviewable> getFavourites();

    List<Building> getFavouriteBuildings();

    List<Room> getFavouriteRooms();
}
