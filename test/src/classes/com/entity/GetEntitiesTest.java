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
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class GetEntitiesTest {
    public Map map;
    public List<Building> buildings;
    public List<User> users;
    public List<Review> reviews;

    @Before
    public void init() {
        Random rand = new Random();

        // Create buildings
        BuildingBuilder buildingBuilder = new BuildingBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        ReviewBuilder reviewBuilder = new ReviewBuilder();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = Path.path + "external-data\\events.json";
        String reviewPath = Path.path + "external-data\\buildingreviews.json";

        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();

        BuildingReviewsDataAccessInterface reviewDataAccessObject = new BuildingReviewDataAccessObject(reviewPath, reviewBuilder, userDAO);

        OpenBuildingsListDataAccessInterface buildingDAO = new BuildingDataAccessObject(buildingPath,eventPath, buildingBuilder, eventBuilder, reviewDataAccessObject);
        buildings = buildingDAO.getBuildings();

        // Create Users
        users = new ArrayList<>(userDAO.getAccounts().values());

        // Get some random reviews for each user, each user will have 0-3 reviews after this
        reviews = new ArrayList<>();
        for (User user : users) {
            int numReviews = rand.nextInt(4);
            for (int i = 0; i < numReviews; i++) {
                String title = String.format("%d, Title for %s", i, user.getUsername());
                String content = String.format("%d, Content for %s", i, user.getUsername());
                Review review = new Review((LoggedInUser) user, new Date(), title, content, rand.nextFloat()*5);
                reviews.add(review);
            }
        }

        // creates a map object, which essentially just stores the list of buildings attached to it.
        map = new Map(buildings);
    }
}