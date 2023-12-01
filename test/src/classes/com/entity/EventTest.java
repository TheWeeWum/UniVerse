package src.classes.com.entity;

import com.entity.event.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    private GetEntitiesTest entities;
    @BeforeEach
    void setUp() {
        entities = new GetEntitiesTest();
        entities.init();
    }

    @Test
    void getName() {
        List<Event> events = entities.buildings.get(70).getEvents();
        Assertions.assertEquals("Physics Event", events.get(0).getName());
        Assertions.assertEquals("thechristmascronicle", events.get(1).getName());
    }

    @Test
    void getOrganizer() {
        List<Event> events = entities.buildings.get(70).getEvents();
        Assertions.assertEquals("PHYSU", events.get(0).getOrganizer());
        Assertions.assertEquals("DNDClub", events.get(1).getOrganizer());
    }

    @Test
    void getLocation() {
        List<Event> events = entities.buildings.get(70).getEvents();
        Assertions.assertEquals(entities.buildings.get(70), events.get(0).getLocation());
        Assertions.assertEquals(entities.buildings.get(70), events.get(1).getLocation());
    }

    @Test
    void getDate() {
        List<Event> events = entities.buildings.get(70).getEvents();
        Assertions.assertEquals("Mon Dec 25 12:00:00 EST 2023", events.get(0).getDate().toString());
        Assertions.assertEquals("Mon Dec 25 12:00:00 EST 2023", events.get(1).getDate().toString());
    }

    @Test
    void getJsonRepresentation() {
        List<Event> events = entities.buildings.get(70).getEvents();
        String expected1 = "{" +
                    "\"name\": \"Physics Event\"," +
                    "\"organizer\": \"PHYSU\"," +
                    "\"location\": " +
                    "{" +
                        "\"name\": \"Bahen Centre for Information Technology\"," +
                        "\"code\": \"BA\"," +
                        "\"shortname\": \"Bahen Centre\"," +
                        "\"campus\": \"UTSG\"," +
                        "\"address\": {" +
                            "\"street\": \"40 St. George Street\"," +
                            "\"city\": \"Toronto\"," +
                            "\"province\": \"ON\"," +
                            "\"country\": \"Canada\"," +
                            "\"postal\": \"M5S 2E4\"" +
                        "}," +
                        "\"lat\": 43.659668," +
                        "\"lng\": -79.39738" +
                    "}," +
                    "\"date\": \"Mon Dec 25 12:00:00 EST 2023\"" +
                "}";
        String expected2 = "{" +
                "\"name\": \"thechristmascronicle\"," +
                "\"organizer\": \"DNDClub\"," +
                "\"location\": " +
                "{" +
                "\"name\": \"Bahen Centre for Information Technology\"," +
                "\"code\": \"BA\"," +
                "\"shortname\": \"Bahen Centre\"," +
                "\"campus\": \"UTSG\"," +
                "\"address\": {" +
                "\"street\": \"40 St. George Street\"," +
                "\"city\": \"Toronto\"," +
                "\"province\": \"ON\"," +
                "\"country\": \"Canada\"," +
                "\"postal\": \"M5S 2E4\"" +
                "}," +
                "\"lat\": 43.659668," +
                "\"lng\": -79.39738" +
                "}," +
                "\"date\": \"Mon Dec 25 12:00:00 EST 2023\"" +
                "}";
        Assertions.assertEquals(expected1, events.get(0).getJsonRepresentation());
        Assertions.assertEquals(expected2, events.get(1).getJsonRepresentation());
    }

    @Test
    void getDeadEndJson() {
        List<Event> events = entities.buildings.get(70).getEvents();
        String expected1 = "{" +
                "\"name\": \"Physics Event\"," +
                "\"organizer\": \"PHYSU\"," +
                "\"location\": " +
                "{" +
                "\"name\": \"Bahen Centre for Information Technology\"," +
                "\"code\": \"BA\"," +
                "\"shortname\": \"Bahen Centre\"," +
                "\"campus\": \"UTSG\"," +
                "\"address\": {" +
                "\"street\": \"40 St. George Street\"," +
                "\"city\": \"Toronto\"," +
                "\"province\": \"ON\"," +
                "\"country\": \"Canada\"," +
                "\"postal\": \"M5S 2E4\"" +
                "}," +
                "\"lat\": 43.659668," +
                "\"lng\": -79.39738" +
                "}," +
                "\"date\": \"Mon Dec 25 12:00:00 EST 2023\"" +
                "}";
        String expected2 = "{" +
                "\"name\": \"thechristmascronicle\"," +
                "\"organizer\": \"DNDClub\"," +
                "\"location\": " +
                "{" +
                "\"name\": \"Bahen Centre for Information Technology\"," +
                "\"code\": \"BA\"," +
                "\"shortname\": \"Bahen Centre\"," +
                "\"campus\": \"UTSG\"," +
                "\"address\": {" +
                "\"street\": \"40 St. George Street\"," +
                "\"city\": \"Toronto\"," +
                "\"province\": \"ON\"," +
                "\"country\": \"Canada\"," +
                "\"postal\": \"M5S 2E4\"" +
                "}," +
                "\"lat\": 43.659668," +
                "\"lng\": -79.39738" +
                "}," +
                "\"date\": \"Mon Dec 25 12:00:00 EST 2023\"" +
                "}";
        Assertions.assertEquals(expected1, events.get(0).getDeadEndJson());
        Assertions.assertEquals(expected2, events.get(1).getDeadEndJson());
    }
}