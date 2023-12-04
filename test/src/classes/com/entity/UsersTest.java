package src.classes.com.entity;

import com.entity.Reviewable;
import com.entity.building.Address;
import com.entity.building.Building;
import com.entity.building.Location;
import com.entity.event.Event;
import com.entity.review.Review;
import com.entity.room.Room;
import com.entity.user.AdminUser;
import org.junit.Test;
import com.entity.user.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void testAdminUserConstructor() {
        AdminUser adminUser = new AdminUser("admin", "adminpass", 1, null, null, null);
        assertEquals("admin", adminUser.getUsername());
        assertEquals("adminpass", adminUser.getPassword());
        assertEquals(1, adminUser.getId());
        // Additional assertions for reviews, favoriteBuildings, favoriteRooms
    }

    @Test
    public void testCreate() {
        CommonUserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create("testuser", "testpass", 123);
        assertEquals("testuser", user.getUsername());
        assertEquals("testpass", user.getPassword());
        assertEquals(123, user.getId());
    }

    @Test
    public void testGuestDefaultConstructor() {
        Guest guest = new Guest();
        assertEquals("Guest", guest.getUsername());
        assertEquals(-1, guest.getId());
        // Additional assertions for getPassword(), getJsonRepresentation(), etc.
    }

    @Test
    public void testTempLoggedInUserConstructor() {
        TempLoggedInUser tempLoggedInUser = new TempLoggedInUser("user1", "pass123", 1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        assertEquals("user1", tempLoggedInUser.username);
        assertEquals("pass123", tempLoggedInUser.password);
        assertEquals(1, tempLoggedInUser.id);
        // Additional assertions for reviews, favouriteBuildings, favouriteRooms
    }
    @Test
    public void testUserInterfaceImplementation() {
        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, null, null, null);
        assertTrue(loggedInUser instanceof User);
        assertEquals("user1", loggedInUser.getUsername());
        // Additional assertions for getId(), getPassword()
    }

    @Test
    public void testUserFactoryCreate() {
        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create("testuser", "testpass", 123);
        assertEquals("testuser", user.getUsername());
        assertEquals("testpass", user.getPassword());
        assertEquals(123, user.getId());
    }


    @Test
    public void testGetId() {
        Guest guest = new Guest();
        assertEquals(-1, guest.getId());
    }

    @Test
    public void testGetUsername() {
        Guest guest = new Guest();
        assertEquals("Guest", guest.getUsername());
    }

    @Test
    public void testGetPassword() {
        Guest guest = new Guest();
        assertNull(guest.getPassword());
    }

    @Test
    public void testGetJsonRepresentation2() {
        Guest guest = new Guest();
        assertEquals("{\"username\": \"Guest\", \"id\": -1}", guest.getJsonRepresentation());
    }

    @Test
    public void testGetDeadEndJson2() {
        Guest guest = new Guest();
        assertEquals("{\"username\": \"Guest\", \"id\": -1}", guest.getDeadEndJson());
    }

    @Test
    public void testLoggedInUserConstructor() {
        List<Review> reviews = new ArrayList<>();
        List<Building> favouriteBuildings = new ArrayList<>();
        List<Room> favouriteRooms = new ArrayList<>();

        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, reviews, favouriteBuildings, favouriteRooms);
        assertEquals("user1", loggedInUser.getUsername());
        assertEquals("pass123", loggedInUser.getPassword());
        assertEquals(1, loggedInUser.getId());
        assertEquals(reviews, loggedInUser.getReviews());
        assertEquals(favouriteBuildings, loggedInUser.getFavouriteBuildings());
        assertEquals(favouriteRooms, loggedInUser.getFavouriteRooms());
        // Additional assertions for reviews, favoriteBuildings, favoriteRooms
    }

    @Test
    public void testChangeUsername() {
        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, null, null, null);
        loggedInUser.ChangeUsername("newUser");
        assertEquals("newUser", loggedInUser.getUsername());
    }

    @Test
    public void testCheckPassword() {
        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, null, null, null);
        assertTrue(loggedInUser.checkPassword("pass123"));
        assertFalse(loggedInUser.checkPassword("wrongpass"));
    }

    @Test
    public void testCheckID() {
        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, null, null, null);
        assertTrue(loggedInUser.checkID(1));
        assertFalse(loggedInUser.checkID(2));
    }

    @Test
    public void testDeleteReview() {
        List<Review> reviews = new ArrayList<>();
        Date date = new Date();
        Review review = new Review(5, "TestAuthor", date, "testTitle", "testContent", 3); // Create a sample review
        reviews.add(review);

        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, reviews, null, null);
        assertTrue(loggedInUser.deleteReview(review));
    }

    @Test
    public void testGetJsonRepresentation() {
        List<Review> reviews = new ArrayList<>();
        List<Building> favouriteBuildings = new ArrayList<>();
        List<Room> favouriteRooms = new ArrayList<>();

        // Add some sample data to lists

        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, reviews, favouriteBuildings, favouriteRooms);

        String expectedJson = "{\"username\": \"user1\"," +
                "\"id\": 1," +
                "\"reviews\": []," +
                "\"favourite_buildings\": []," +
                "\"favourite_rooms\": []}";

        assertEquals(expectedJson, loggedInUser.getJsonRepresentation());
    }

    @Test
    public void testGetDeadEndJson() {
        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, null, null, null);

        String expectedDeadEndJson = "{\"username\": \"user1\",\"id\": \"1}";

        assertEquals(expectedDeadEndJson, loggedInUser.getDeadEndJson());
    }
    @Test
    public void testGetFavourites() {
        List<Building> favouriteBuildings = new ArrayList<>();
        List<Room> favouriteRooms = new ArrayList<>();
        //creates a random address object
        Address address = new Address("1", "2", "3", "4", "5");
        //create a simple location object
        Location location = new Location(1, 2);


        Room room1 = new Room("12", "5", 30, new ArrayList<Review>(), new ArrayList<Event>(), true);
        Room room2 = new Room("13", "4", 30, new ArrayList<Review>(), new ArrayList<Event>(), true);

        Date date = new Date();
        Review review1 = new Review(5, "TestAuthor1", date, "testTitle1", "testContent1", 1); // Create a sample review
        Review review2 = new Review(5, "TestAuthor2", date, "testTitle2", "testContent2", 2); // Create a sample review
        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);


        // Create sample buildings and rooms
        //A building
        Building building1 = new Building(
                "SS", // Code
                "Main Building", // Name
                "Main", // Shortname
                "Campus A", // Campus
                address, // Address object
                favouriteRooms, // List of rooms
                List.of("1st Floor", "2nd Floor"), // List of floors
                location, // Location object
                reviews // List of reviews
        );
        Building building2 = new Building(
                "BA", // Code
                "Bahen", // Name
                "Main", // Shortname
                "Campus A", // Campus
                address, // Address object
                favouriteRooms, // List of rooms
                List.of("1st Floor", "2nd Floor"), // List of floors
                location, // Location object
                reviews // List of reviews
        );
        favouriteBuildings.add(building1);
        favouriteBuildings.add(building2);

        favouriteRooms.add(room1);
        favouriteRooms.add(room2);

        LoggedInUser loggedInUser = new LoggedInUser("user1", "pass123", 1, null, favouriteBuildings, favouriteRooms);

        List<Reviewable> expectedFavourites = new ArrayList<>();
        expectedFavourites.addAll(favouriteBuildings);
        expectedFavourites.addAll(favouriteRooms);

        List<Reviewable> actualFavourites = loggedInUser.getFavourites(favouriteBuildings, favouriteRooms);

        assertEquals(expectedFavourites.size(), actualFavourites.size());
        assertTrue(expectedFavourites.containsAll(actualFavourites));
        assertTrue(actualFavourites.containsAll(expectedFavourites));
    }
}
