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


public class EntityTest {

    private GetEntitiesTest entities;

    @Before
    public void init() {
        entities = new GetEntitiesTest();
        entities.init();
    }

    @Test
    public void testBuildingsJsonRepresentation() {
        // Create buildings
        BuildingBuilder buildingBuilder = new BuildingBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        ReviewBuilder reviewBuilder = new ReviewBuilder();
        String buildingPath = Path.path + "external-data/buildings.json";
        String eventPath = Path.path + "external-data/events.json";
        String reviewPath = Path.path + "external-data/buildingreviews.json";

        FileUserDataAccessObject userDAO = new FileUserDataAccessObject();
        BuildingReviewsDataAccessInterface reviewDataAccessObject = new BuildingReviewDataAccessObject(reviewPath, reviewBuilder, userDAO);

        OpenBuildingsListDataAccessInterface buildingDAO = new BuildingDataAccessObject(buildingPath,eventPath, buildingBuilder, eventBuilder, reviewDataAccessObject);
        List<Building> testBuildings = buildingDAO.getBuildings();

        String expectedString = "{" +
                "\"name\": \"University College\"" + "," +
                "\"code\": \"UC\"" + "," +
                "\"shortname\": \"UC\"" + "," +
                "\"campus\": \"UTSG\"" + "," +
                "\"address\": {" +
                    "\"street\": \"15 King's College Circle\"" + "," +
                    "\"city\": \"Toronto\"" + "," +
                    "\"province\": \"ON\"" + "," +
                    "\"country\": \"Canada\"" + "," +
                    "\"postal\": \"M5S 3H7\"" +
                    "}" + "," +
                "\"rooms\": []" + "," +
                "\"floors\": []" + "," +
                "\"lat\": 43.663197" + "," +
                "\"lng\": -79.39582" + "," +
                "\"reviews\": []" + "," +
                "\"events\": []" +
                "}";

        String JsonStringForBuilding = testBuildings.get(0).getJsonRepresentation();
        assertEquals(expectedString, JsonStringForBuilding);
    }

    @Test
    public void testBuildingToString() {
        Building building = entities.buildings.get(0);
        assertEquals("University College", building.toString());
    }

    @Test
    public void testBuildingGet() {
        List<Building> buildings = entities.buildings;
        assertEquals("University College", buildings.get(0).getName());
        assertEquals("UC", buildings.get(0).getCode());
        assertEquals("UC", buildings.get(0).getShortname());
        assertEquals(new ArrayList<Room>(), buildings.get(0).getRooms());
        assertEquals(new ArrayList<String>(), buildings.get(0).getFloors());
        assertEquals(43.663197, buildings.get(0).getLocation().getLatitude(), 0.001);
        assertEquals(-79.39582, buildings.get(0).getLocation().getLongitude(), 0.001);
        assertEquals(new ArrayList<Review>(), buildings.get(0).getReviews());
        assertEquals(new ArrayList<Event>(), buildings.get(0).getEvents());

        Address address = buildings.get(0).getAddress();
        assertEquals("15 King's College Circle", address.getStreet());
        assertEquals("Toronto", address.getCity());
        assertEquals("ON", address.getProvince());
        assertEquals("Canada", address.getCountry());
        assertEquals("M5S 3H7", address.getPostal());
    }
}