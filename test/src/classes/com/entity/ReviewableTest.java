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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class ReviewableTest {
    private Building building;
    @BeforeEach
    public void init() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review(0,"",new Date(),"","",4));
        reviews.add(new Review(0,"",new Date(),"","",1));
        reviews.add(new Review(0,"",new Date(),"","",4));
        this.building = new Building("","","","", null, null, null, null, reviews);
    }

    @Test
    public void getRating() {
        Assertions.assertEquals(3, building.getRating(), 0.001);
    }

    @Test
    public void rate() {
        building.rate(new Review(0,"",new Date(),"","",4));
        Assertions.assertEquals((double) (4 * 3 + 1) /4, building.getRating(), 0.001);
    }

    @Test
    public void deleteReview() {
        int numReviews = building.getReviews().size();
        Review review = new Review(0,"",new Date(),"","",4);
        building.rate(review);
        Assertions.assertEquals(numReviews+1, building.getReviews().size());
        building.deleteReview(review);
        Assertions.assertEquals(numReviews, building.getReviews().size());
    }
}