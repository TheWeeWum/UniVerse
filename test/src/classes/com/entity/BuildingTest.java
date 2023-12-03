package src.classes.com.entity;

import com.entity.building.Address;
import com.entity.building.Building;
import com.entity.event.Event;
import com.entity.review.Review;
import com.entity.room.Room;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;


public class BuildingTest {

    private GetEntitiesTest entities;

    @BeforeEach
    public void setUp() {
        this.entities = new GetEntitiesTest();
        this.entities.init();
    }

    @Test
    public void buildingToStringTest() {
        Building building = entities.buildings.get(0);
        Assertions.assertEquals("University College", building.toString());
    }

    @Test
    void getCodeTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals("UC", buildings.get(0).getCode());

    }

    @Test
    void getNameTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals("University College", buildings.get(0).getName());
    }

    @Test
    void getShortnameTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals("UC", buildings.get(0).getShortname());
    }

    @Test
    void getCampusTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals("UTSG", buildings.get(0).getCampus());
    }

    @Test
    void getAddressTest() {
        List<Building> buildings = entities.buildings;
        Address address = buildings.get(0).getAddress();
        Assertions.assertEquals("15 King's College Circle", address.getStreet());
        Assertions.assertEquals("Toronto", address.getCity());
        Assertions.assertEquals("ON", address.getProvince());
        Assertions.assertEquals("Canada", address.getCountry());
        Assertions.assertEquals("M5S 3H7", address.getPostal());
    }

    @Test
    void getRoomsTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals(new ArrayList<Room>(), buildings.get(0).getRooms());
    }

    @Test
    void getFloorsTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals(new ArrayList<String>(), buildings.get(0).getFloors());
    }

    @Test
    void getLocationTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals(43.663197, buildings.get(0).getLocation().getLatitude(), 0.001);
        Assertions.assertEquals(-79.39582, buildings.get(0).getLocation().getLongitude(), 0.001);
    }

    @Test
    void getEventsTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals(new ArrayList<Event>(), buildings.get(0).getEvents());
    }

    @Test
    void getReviewsTest() {
        List<Building> buildings = entities.buildings;
        Assertions.assertEquals(new ArrayList<Review>(), buildings.get(0).getReviews());
    }

    @Test
    void testToStringTest() {
        List<Building> buildings = entities.buildings;
    }

    @Test
    public void buildingsJsonRepresentationTest() {
        List<Building> buildings = entities.buildings;
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

        String JsonStringForBuilding = buildings.get(0).getJsonRepresentation();
        Assertions.assertEquals(expectedString, JsonStringForBuilding);
    }

    @Test
    void getDeadEndJsonTest() {
        List<Building> buildings = entities.buildings;

    }

    @AfterEach
    void tearDown() {
    }
}