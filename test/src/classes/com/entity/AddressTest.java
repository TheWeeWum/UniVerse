package src.classes.com.entity;

import com.entity.building.Address;
import com.entity.building.Building;
import com.entity.event.Event;
import com.entity.map.Map;
import com.entity.review.Review;
import com.entity.room.Room;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.*;


public class AddressTest {
    private GetEntitiesTest entities;

    @BeforeEach
    public void init() {
        entities = new GetEntitiesTest();
        entities.init();
    }

    @Test
    public void getAddressTest() {
        List<Building> buildings = entities.buildings;
        Address address = buildings.get(0).getAddress();
        Assertions.assertEquals("15 King's College Circle", address.getStreet());
        Assertions.assertEquals("Toronto", address.getCity());
        Assertions.assertEquals("ON", address.getProvince());
        Assertions.assertEquals("Canada", address.getCountry());
        Assertions.assertEquals("M5S 3H7", address.getPostal());
    }

    @Test
    public void getStreetTest() {
        Address address = entities.buildings.get(0).getAddress();
        Assertions.assertEquals("15 King's College Circle", address.getStreet());
    }

    @Test
    public void getCityTest() {
        Address address = entities.buildings.get(0).getAddress();
        Assertions.assertEquals("Toronto", address.getCity());
    }

    @Test
    public void getProvinceTest() {
        Address address = entities.buildings.get(0).getAddress();
        Assertions.assertEquals("ON", address.getProvince());
    }

    @Test
    public void getCountryTest() {
        Address address = entities.buildings.get(0).getAddress();
        Assertions.assertEquals("Canada", address.getCountry());
    }

    @Test
    public void getPostalTest() {
        Address address = entities.buildings.get(0).getAddress();
        Assertions.assertEquals("M5S 3H7", address.getPostal());
    }

    @Test
    public void getJsonRepresentationTest() {
        Address address = entities.buildings.get(0).getAddress();
        String expected = "{\"street\": \"15 King's College Circle\",\"city\": \"Toronto\",\"province\": \"ON\",\"country\": \"Canada\",\"postal\": \"M5S 3H7\"}";

        Assertions.assertEquals(expected, address.getJsonRepresentation());
    }

    @Test
    public void getDeadEndJson() {
        Address address = entities.buildings.get(0).getAddress();
        String expected = "{\"street\": \"15 King's College Circle\",\"city\": \"Toronto\",\"province\": \"ON\",\"country\": \"Canada\",\"postal\": \"M5S 3H7\"}";

        Assertions.assertEquals(expected, address.getDeadEndJson());
    }
}