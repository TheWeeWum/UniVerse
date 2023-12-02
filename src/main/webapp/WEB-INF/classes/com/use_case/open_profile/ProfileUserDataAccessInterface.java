package com.use_case.open_profile;
import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.room.Room;
import com.entity.user.LoggedInUser;
import com.entity.user.User;

import java.util.List;


public interface ProfileUserDataAccessInterface {
    LoggedInUser getUser(int userID);

    String getUsername(int userID);
    List<Reviewable> getFavourites(int userID);

    List<Building> getFavouriteBuildings(int userID);

    List<Room> getFavouriteRooms(int userID);
}
