package src.classes.com.entity;

import com.data_access.BuildingDataAccessObject;
import com.data_access.BuildingReviewDataAccessObject;
import com.data_access.FileUserDataAccessObject;
import com.data_access.Path;
import com.entity.building.Address;
import com.entity.building.Building;
import com.entity.building.BuildingBuilder;
import com.entity.event.Event;
import com.entity.event.EventBuilder;
import com.entity.map.Map;
import com.entity.review.Review;
import com.entity.review.ReviewBuilder;
import com.entity.room.Room;
import com.entity.user.LoggedInUser;
import com.entity.user.User;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java.nio.file.FileSystems.getDefault;
import static org.junit.Assert.*;


public class BaseTest {
    private GetEntitiesTest entities;

    @Before
    public void init() {
        entities = new GetEntitiesTest();
        entities.init();
    }

}