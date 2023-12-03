package src.classes.com.entity;

import org.junit.Before;


public class BaseTest {
    private GetEntitiesTest entities;

    @Before
    public void init() {
        entities = new GetEntitiesTest();
        entities.init();
    }

}