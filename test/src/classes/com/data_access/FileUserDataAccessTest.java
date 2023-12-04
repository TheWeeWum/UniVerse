package src.classes.com.data_access;

import com.app.DataAccessBuilder;
import com.data_access.EventDataAccessObject;
import com.app.Path;
import com.data_access.FileUserDataAccessObject;
import com.entity.building.Building;
import com.entity.event.Event;
import com.entity.event.EventBuilder;
import com.entity.review.Review;
import com.entity.user.Guest;
import com.entity.user.LoggedInUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.classes.com.entity.GetEntitiesTest;
import src.classes.com.entity.ReviewableTest;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUserDataAccessTest {
    private FileUserDataAccessObject fudao;
    @BeforeEach
    void setUp() {
        this.fudao = DataAccessBuilder.getFileUserDataAccessObject();
    }

    @Test
    void saveUser() {
        int numUsers = fudao.getAccounts().size();

        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review(0,"",new Date(),"","",4));
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building("NA", "NotABuilding", "NA", "Nowhere", null, new ArrayList<>(), new ArrayList<>(), null, new ArrayList<>()));

        Date date = new Date();
        LoggedInUser loggedInUser = new LoggedInUser("", "", -(int) date.getTime(), reviews, new ArrayList<>(), new ArrayList<>());

        fudao.save(loggedInUser);
        Assertions.assertEquals(numUsers + 1, fudao.getAccounts().size());
    }

    @Test
    void saveGuessError() {;
        Assertions.assertThrows(ClassCastException.class, () -> fudao.save(new Guest()));
    }

    @Test
    void addEvent() {
        EventDataAccessObject EDAO = new EventDataAccessObject(Path.path + "external-data/events.json", new EventBuilder());
        EDAO.addEvent("TESTCODE", "testtitle", "testOrganizer", "NotARoom", new Date(), "This is a test event added by the EventDataAccessTest");
        assertFalse(EDAO.getEvents("TESTCODE").isEmpty());
    }
}