package src.classes.com.data_access;

import com.data_access.EventDataAccessObject;
import com.entity.event.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.classes.com.entity.GetEntitiesTest;

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
}