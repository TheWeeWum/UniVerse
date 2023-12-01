package src.classes.com.entity;

import com.entity.event.Event;
import com.entity.review.Review;
import com.entity.room.Bathroom;
import com.entity.room.Lecture;
import com.entity.room.Tutorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomTest {
    private Bathroom bathroom;
    private Lecture lecture;
    private Tutorial tutorial;

    private List<Review> testReview;


    @BeforeEach
    public void init() {
        testReview = new ArrayList<>();
        String dateStr = "2004-09-18 00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("DIDNT PARSE IN TEST RoomTest");
        }
        testReview.add(new Review(null, date, "NullReview", "This is a blank review.", 4.5f));

        bathroom = new Bathroom("101", "1", 100, testReview, new ArrayList<Event>(), "genderNeutral");
        lecture = new Lecture("101", "1", 100, testReview, new ArrayList<Event>());
        tutorial = new Tutorial("101", "1", 100, testReview, new ArrayList<Event>(), true);
    }

    @Test
    public void contructorCallsTest() {
        new Bathroom("101", "1", 100, testReview, new ArrayList<Event>(), true, "genderNeutral");
        new Lecture("101", "1", 100, testReview, new ArrayList<Event>(), false);
        new Tutorial("101", "1", 100, testReview, new ArrayList<Event>());
    }

    @Test
    public void getRoomNumberTest() {
        Assertions.assertEquals("101", bathroom.getRoomNumber());
        Assertions.assertEquals("101", lecture.getRoomNumber());
        Assertions.assertEquals("101", tutorial.getRoomNumber());
    }

    @Test
    public void getFloorTest() {
        Assertions.assertEquals("1", bathroom.getFloor());
        Assertions.assertEquals("1", lecture.getFloor());
        Assertions.assertEquals("1", tutorial.getFloor());
    }

    @Test
    public void getCapacityTest() {
        Assertions.assertEquals(100, bathroom.getCapacity());
        Assertions.assertEquals(100, lecture.getCapacity());
        Assertions.assertEquals(100, tutorial.getCapacity());
    }

    @Test
    public void getOutletAvailabilityTest() {
        Assertions.assertFalse(bathroom.getOutletAvailable());
        Assertions.assertFalse(lecture.getOutletAvailable());
        Assertions.assertTrue(tutorial.getOutletAvailable());
    }

    @Test
    public void getEventsTest() {
        Assertions.assertEquals(new ArrayList<Event>(), bathroom.getEvents());
        Assertions.assertEquals(new ArrayList<Event>(), lecture.getEvents());
        Assertions.assertEquals(new ArrayList<Event>(), tutorial.getEvents());
    }

    @Test
    public void getReviewsTest() {
        Assertions.assertEquals(testReview, bathroom.reviews);
        Assertions.assertEquals(testReview, lecture.reviews);
        Assertions.assertEquals(testReview, tutorial.reviews);
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals("101", bathroom.toString());
        Assertions.assertEquals("101", lecture.toString());
        Assertions.assertEquals("101", tutorial.toString());
    }

    @Test
    public void getJsonRepresentationTest() {
        String expectedBathroom = "{" +
                "\"room_number\": \"101\"," +
                "\"floor\": \"1\"," +
                "\"capacity\": \"100\"," +
                "\"reviews\": " +
                    "[" +
                        "{" +
                            "\"user\": " +
                                "{" +
                                    "username: Guest, id: 0" +
                                "}," +
                            "\"date\": \"Sat Sep 18 00:00:00 EDT 2004\"," +
                            "\"title\": \"NullReview\"," +
                            "\"rating\": 4.5," +
                            "\"content\": \"This is a blank review.\"" +
                        "}" +
                    "]," +
                "\"events\": []" +
                "}";
        String expectedLecture = "{" +
                "\"room_number\": \"101\"," +
                "\"floor\": \"1\"," +
                "\"capacity\": \"100\"," +
                "\"reviews\": " +
                "[" +
                "{" +
                "\"user\": " +
                "{" +
                "username: Guest, id: 0" +
                "}," +
                "\"date\": \"Sat Sep 18 00:00:00 EDT 2004\"," +
                "\"title\": \"NullReview\"," +
                "\"rating\": 4.5," +
                "\"content\": \"This is a blank review.\"" +
                "}" +
                "]," +
                "\"events\": []" +
                "}";;
        String expectedTutorial = "{" +
                "\"room_number\": \"101\"," +
                "\"floor\": \"1\"," +
                "\"capacity\": \"100\"," +
                "\"reviews\": " +
                "[" +
                "{" +
                "\"user\": " +
                "{" +
                "username: Guest, id: 0" +
                "}," +
                "\"date\": \"Sat Sep 18 00:00:00 EDT 2004\"," +
                "\"title\": \"NullReview\"," +
                "\"rating\": 4.5," +
                "\"content\": \"This is a blank review.\"" +
                "}" +
                "]," +
                "\"events\": []" +
                "}";;

        Assertions.assertEquals(expectedBathroom, bathroom.getJsonRepresentation());
        Assertions.assertEquals(expectedLecture, lecture.getJsonRepresentation());
        Assertions.assertEquals(expectedTutorial, tutorial.getJsonRepresentation());
    }

    @Test
    public void getDeadEndJson() {
        String expectedBathroom = "{" +
                "\"room_number\": \"101\"," +
                "\"floor\": \"1\"," +
                "\"capacity\": \"100\"" +
                "}";
        String expectedLecture = expectedBathroom;
        String expectedTutorial = expectedLecture;

        Assertions.assertEquals(expectedBathroom, bathroom.getDeadEndJson());
        Assertions.assertEquals(expectedLecture, lecture.getDeadEndJson());
        Assertions.assertEquals(expectedTutorial, tutorial.getDeadEndJson());
    }

    @Test
    public void getGenderTest() {
        Assertions.assertEquals(bathroom.getGender(), "genderNeutral");
    }
}
