package src.classes.com.entity;


import com.entity.review.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BuildingReviewsTest {
    private GetEntitiesTest entities;
    @BeforeEach
    void setUp() {
        entities = new GetEntitiesTest();
        entities.init();
    }

    @Test
    void getUser() {
        List<Review> reviews = entities.buildings.get(70).getReviews();
        Assertions.assertEquals(1, reviews.get(0).getUser().getId());
        Assertions.assertEquals(447938204, reviews.get(1).getUser().getId());
        Assertions.assertEquals(2, reviews.get(2).getUser().getId());
        Assertions.assertEquals(447949816, reviews.get(3).getUser().getId());
        Assertions.assertEquals(447951020, reviews.get(4).getUser().getId());
        Assertions.assertEquals(447951497, reviews.get(5).getUser().getId());
    }

    @Test
    void getDate() {
        List<Review> reviews = entities.buildings.get(70).getReviews();
        Assertions.assertEquals("Thu Nov 02 12:00:00 EDT 2023", reviews.get(0).getDate().toString());
        Assertions.assertEquals("Sun Nov 05 12:00:00 EST 2023", reviews.get(1).getDate().toString());
        Assertions.assertEquals("Fri Nov 17 08:00:00 EST 2023", reviews.get(2).getDate().toString());
        Assertions.assertEquals("Mon Dec 04 07:00:00 EST 2023", reviews.get(3).getDate().toString());
        Assertions.assertEquals("Thu Dec 14 11:00:00 EST 2023", reviews.get(4).getDate().toString());
        Assertions.assertEquals("Mon Dec 25 12:00:00 EST 2023", reviews.get(5).getDate().toString());
    }

    @Test
    void getTitle() {
        List<Review> reviews = entities.buildings.get(70).getReviews();
        Assertions.assertEquals("helo", reviews.get(0).getTitle());
        Assertions.assertEquals("oop", reviews.get(1).getTitle());
        Assertions.assertEquals("Evan Wang sleeps here", reviews.get(2).getTitle());
        Assertions.assertEquals("bahen is THE BEST", reviews.get(3).getTitle());
        Assertions.assertEquals("bahen is THE WORST", reviews.get(4).getTitle());
        Assertions.assertEquals("beyonce", reviews.get(5).getTitle());
    }

    @Test
    void getContent() {
        List<Review> reviews = entities.buildings.get(70).getReviews();
        Assertions.assertEquals("buah", reviews.get(0).getContent());
        Assertions.assertEquals("chuu", reviews.get(1).getContent());
        Assertions.assertEquals("Idk, im so annoyed. evan wang sleeps here everyday and snores. it disturbs others students. i hate it here.", reviews.get(2).getContent());
        Assertions.assertEquals("I LOOOOOOOOOOOOOOOVE BAHEN. SO MANY COMPUTERS. SO EXCITING. I LOVE CODE. I CODE EVERYDAY. YUMMMMM!!!!!!!!! I WISH I COULD CODE EVERY. SINGLE. DAY!!!", reviews.get(3).getContent());
        Assertions.assertEquals("i DISAGREE WITH LIAM. WHAT IS HE SAYING????? bahen makes me STRESSED. boo. E.J.PRATT on top", reviews.get(4).getContent());
        Assertions.assertEquals("idk, they played beyonce's music here once. and i love beyonce.", reviews.get(5).getContent());
    }

    @Test
    void getRating() {
        List<Review> reviews = entities.buildings.get(70).getReviews();
        Assertions.assertEquals(3.4, reviews.get(0).getRating(), 0.1);
        Assertions.assertEquals(5, reviews.get(1).getRating(), 0.1);
        Assertions.assertEquals(4.0, reviews.get(2).getRating(), 0.1);
        Assertions.assertEquals(4.6, reviews.get(3).getRating(), 0.1);
        Assertions.assertEquals(0.1, reviews.get(4).getRating(), 0.1);
        Assertions.assertEquals(5, reviews.get(5).getRating(), 0.1);
    }
    @Test
    void getJsonRepresentation() {
        List<Review> reviews = entities.buildings.get(70).getReviews();
        Assertions.assertEquals(3.4, reviews.get(0).getRating(), 0.1);
        Assertions.assertEquals(5, reviews.get(1).getRating(), 0.1);
        Assertions.assertEquals(4.0, reviews.get(2).getRating(), 0.1);
        Assertions.assertEquals(4.6, reviews.get(3).getRating(), 0.1);
        Assertions.assertEquals(0.1, reviews.get(4).getRating(), 0.1);
        Assertions.assertEquals(5, reviews.get(5).getRating(), 0.1);
    }

}
