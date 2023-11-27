package com.data_access;

import com.entity.review.Review;
import com.entity.review.ReviewFactory;
import com.entity.user.User;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.*;

public class BuildingReviewDataAccessObject implements BuildingReviewsDataAccessInterface {
    private ReviewFactory reviewFactory = null;

    private final String reviewPath;

    private final FileUserDataAccessObject userDao;

    public BuildingReviewDataAccessObject(String reviewPath, ReviewFactory reviewFactory, FileUserDataAccessObject userDao) {
        this.reviewPath = reviewPath;
        this.reviewFactory = reviewFactory;
        this.userDao = userDao;
    }

    // create Review objects from reviews.json
    public List<Review> getReviews(String buildingCode) {
        List<Review> reviews = new ArrayList<>();
        try {
            // read the file given
            JsonObject jsonReviews = JsonParser.parseReader(new FileReader(reviewPath)).getAsJsonObject();
            try {
                // form array of reviews
                JsonArray reviewsInBuilding = jsonReviews.get(buildingCode).getAsJsonObject().get("reviews").getAsJsonArray();
                // loop through reviews in reviews array
                for (JsonElement reviewElement: reviewsInBuilding) {
                    // set review element in the array as JsonObject
                    JsonObject ro = reviewElement.getAsJsonObject();

                    // getting review attributes from json
                    Integer userid = ro.get("userid").getAsInt(); // get userid
                    userDao.populateAccountsFromJson();
                    User user = userDao.getUser(userid); // make User

                    String dateStr = ro.get("date").getAsString(); // get date data
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = sdf.parse(dateStr); // make Date

                    float rating = ro.get("rating").getAsFloat(); // get rating
                    String title = ro.get("title").getAsString(); // get title
                    String content = ro.get("content").getAsString(); // get content

                    // create Review
                    Review review = reviewFactory.create(user, date, title, content, rating);
                    reviews.add(review); // append Review in Review array
                }
            } catch (NullPointerException e) {
                // review list was hopefully empty
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reviews;
    }
}
