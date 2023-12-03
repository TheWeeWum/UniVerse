package com.data_access;

import com.app.Path;
import com.entity.review.Review;
import com.entity.review.ReviewBuilder;
import com.entity.user.User;
import com.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.*;

public class BuildingReviewDataAccessObject implements BuildingReviewsDataAccessInterface {
    private ReviewBuilder reviewBuilder = null;

    private final String reviewPath;

    private final FileUserDataAccessObject userDao;

    public BuildingReviewDataAccessObject(String reviewPath, ReviewBuilder reviewBuilder, FileUserDataAccessObject userDao) {
        this.reviewPath = reviewPath;
        this.reviewBuilder = reviewBuilder;
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
                    if (user == null) {
                        System.out.println("User who wrote the review no longer exists");
                    }

                    String dateStr = ro.get("date").getAsString(); // get date data
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = sdf.parse(dateStr); // make Date

                    float rating = ro.get("rating").getAsFloat(); // get rating
                    String title = ro.get("title").getAsString(); // get title
                    String content = ro.get("content").getAsString(); // get content

                    // create Review
                    Review review = reviewBuilder.create(user.getId(), user.getUsername(), date, title, content, rating);
                    reviews.add(review); // append Review in Review array
                }
            } catch (NullPointerException e) {
                // review list was hopefully empty
            } catch (ParseException e) {
                System.out.println("Parse Error");
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public void saveReview(Review review, String buildingCode) {
        try {
            // Read the existing JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get(reviewPath)));
            JSONObject json = new JSONObject(jsonContent);

            // Retrieve building reviews or create if not exists
            JSONObject buildingReviews = json.optJSONObject(buildingCode);
            if (buildingReviews == null) {
                buildingReviews = new JSONObject();
                JSONArray reviewsArray = new JSONArray();
                json.put(buildingCode, buildingReviews);
                buildingReviews.put("reviews", reviewsArray);
            }

            // Create a new review JSON object
            JSONObject reviewObject = new JSONObject();
            reviewObject.put("userid", review.getUser()); // Assuming User has an ID field
            reviewObject.put("username", review.getUsername()); // Assuming User has an ID field
            reviewObject.put("date", review.getDate().toString()); // Convert Date to String representation
            reviewObject.put("rating", String.valueOf(review.getRating())); // Convert float rating to String
            reviewObject.put("title", review.getTitle());
            reviewObject.put("content", review.getContent());

            // Add the new review to the building's reviews array
            JSONArray reviewsArray = buildingReviews.getJSONArray("reviews");
            reviewsArray.put(reviewObject);

            // Add the updated reviewsArray back to the buildingReviews object
            buildingReviews.put("reviews", reviewsArray);

            // Write the updated JSON back to the file
            Files.write(Paths.get(reviewPath), json.toString(2).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
