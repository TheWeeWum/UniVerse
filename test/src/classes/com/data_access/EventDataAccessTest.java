package src.classes.com.data_access;

import com.data_access.EventDataAccessObject;
import com.app.Path;
import com.entity.event.Event;
import com.entity.event.EventBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.classes.com.entity.GetEntitiesTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventDataAccessTest {
    private GetEntitiesTest entities;
    @BeforeEach
    void setUp() {
//        EventDataAccessObject dao = new EventDataAccessObject();
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
    void getEvents() {
        EventDataAccessObject EDAO = new EventDataAccessObject(Path.path + "external-data/events.json", new EventBuilder());
        Assertions.assertEquals(new ArrayList<Event>(), EDAO.getEvents("NOTABUILDINGCODE"));
        System.out.println(EDAO.getEvents("HH"));
        assertFalse(EDAO.getEvents("BA").isEmpty());
    }

    @Test
    void addEvent() {
        EventDataAccessObject EDAO = new EventDataAccessObject(Path.path + "external-data/events.json", new EventBuilder());
        EDAO.addEvent("TESTCODE", "testtitle", "testOrganizer", "NotARoom", new Date(), "This is a test event added by the EventDataAccessTest");
        assertFalse(EDAO.getEvents("TESTCODE").isEmpty());
    }
}