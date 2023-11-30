package Entity;

import com.data_access.BuildingDataAccessObject;
import com.data_access.FileUserDataAccessObject;
import com.data_access.Path;
import com.entity.building.Building;
import com.entity.building.BuildingBuilder;
import com.entity.event.EventBuilder;
import com.entity.map.Map;
import com.entity.review.Review;
import com.entity.user.LoggedInUser;
import com.entity.user.User;
import com.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class EntityTest {

    private Map map;
    private List<Building> buildings;
    private List<User> users;
    private List<Review> reviews;

    @Before
    public void init() {
        Random rand = new Random();

        // Create buildings
        BuildingBuilder buildingBuilder = new BuildingBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = Path.path + "external-data\\events.json";
        OpenBuildingsListDataAccessInterface buildingDAO = new BuildingDataAccessObject(buildingPath,eventPath, buildingBuilder, eventBuilder);
        buildings = buildingDAO.getBuildings();

        // Create Users
        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();
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

    @Test
    public void testBuildingsDataAccess() {
        // Create buildings
        BuildingBuilder buildingBuilder = new BuildingBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        String buildingPath = Path.path + "external-data\\buildings.json";
        String eventPath = Path.path + "external-data\\events.json";
        OpenBuildingsListDataAccessInterface buildingDAO = new BuildingDataAccessObject(buildingPath,eventPath, buildingBuilder, eventBuilder);
        List<Building> testBuildings = buildingDAO.getBuildings();

        String expectedString = "{" +
                "name: University College" + "," +
                "code: UC" + "," +
                "shortname: UC" + "," +
                "campus: UTSG" + "," +
                "address: {" +
                    "street: " + "15 King's College Circle" + "," +
                    "city: Toronto" + "," +
                    "province: ON" + "," +
                    "country: Canada" + "," +
                    "postal: M5S 3H7" +
                    "}" + "," +
                "rooms: []" + "," +
                "floors: []" + "," +
                "lat: 43.663197" + "," +
                "long: -79.39582" + "," +
                "reviews: []" + "," +
                "events: []" +
                "}";

        String JsonStringForBuilding = testBuildings.get(0).getJsonRepresentation();
        assertEquals(expectedString, JsonStringForBuilding);
    }
}