package src.classes.com.app;

import com.app.*;
import com.data_access.EventDataAccessObject;
import com.entity.event.Event;
import com.interface_adapter.building_reviews.BuildingReviewsController;
import com.interface_adapter.event.AddEventController;
import com.interface_adapter.event.BuildingEventsController;
import com.interface_adapter.login.LoginController;
import com.interface_adapter.marker.MarkerController;
import com.interface_adapter.open_building.OpenBuildingController;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.interface_adapter.signup.SignupController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.classes.com.entity.GetEntitiesTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetupTest {
    private GetEntitiesTest entities;
    @BeforeEach
    void setUp() {
//        EventDataAccessObject dao = new EventDataAccessObject();
        entities = new GetEntitiesTest();
        entities.init();
    }

    @Test
    void addEventSetupTest() {
        Assertions.assertInstanceOf(AddEventController.class, AddEventSetup.setup(null));
    }

    @Test
    void loginSetupTest() {
        try {
            Assertions.assertInstanceOf(LoginController.class, LoginSetup.setup(null));
        } catch (IOException e) {
            System.out.println("File not working");
        }
    }

    @Test
    void markerSetup() {
        Assertions.assertInstanceOf(MarkerController.class, MarkerSetup.setup(null));
    }

    @Test
    void signupSetup() {
        try {
            Assertions.assertInstanceOf(SignupController.class, SignupSetup.setup(null));
        } catch (IOException e) {
            System.out.println("File not working");
        }
    }

    @Test
    void buildingSetup() {
        Assertions.assertInstanceOf(OpenBuildingController.class, BuildingSetup.setup(null));
    }

    @Test
    void buildingListSetup() {
        Assertions.assertInstanceOf(OpenBuildingsListController.class, BuildingListSetup.setup(null));
    }

    @Test
    void buildingEventsSetup() {
        Assertions.assertInstanceOf(BuildingEventsController.class, BuildingEventsSetup.setup(null));
    }

//    @Test
//    void addToFavouritesSetup() {
//        Assertions.assertInstanceOf(AddToFavouritesController.class, AddToFavouritesSetup.setup(null));
//    }

    @Test
    void buildingReviewsSetup() {
        Assertions.assertInstanceOf(BuildingReviewsController.class, BuildingReviewsSetup.setup(null));
    }

    @Test
    void addEventSetup() {
        Assertions.assertInstanceOf(AddEventController.class, AddEventSetup.setup(null));
    }
}