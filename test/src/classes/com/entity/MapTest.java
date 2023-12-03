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

import static org.junit.Assert.*;


public class MapTest {
    private GetEntitiesTest entities;

    @BeforeEach
    public void init() {
        entities = new GetEntitiesTest();
        entities.init();
    }

    @Test
    public void getBuildingsTest() {
        Map map = entities.map;
        Assertions.assertEquals(175, map.getBuildings().size());
    }

    @Test
    public void getBuildingTest() {
        Map map = entities.map;
        Assertions.assertEquals("Medical Sciences Building", map.getBuilding("Medical Sciences Building").getName());
    }
}