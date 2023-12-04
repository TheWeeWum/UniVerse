package com.data_access;

import com.entity.review.Review;
import com.entity.review.ReviewBuilder;
import com.entity.user.LoggedInUser;
import com.entity.user.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.use_case.open_myreviews.OpenReviewDataAccessInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserReviewDataAccessObject implements OpenReviewDataAccessInterface {
    private ReviewBuilder reviewBuilder = null;

    private final String userPath;

    private final FileUserDataAccessObject userDao;

    public UserReviewDataAccessObject(String userPath, ReviewBuilder reviewBuilder, FileUserDataAccessObject userDao) {
        this.userPath = userPath;
        this.reviewBuilder = reviewBuilder;
        this.userDao = userDao;
    }

    // create Review objects from user.json
    public List<Review> getReviews(int userID) {
        LoggedInUser user = userDao.getAccounts().get(userID);
        System.out.println(user.getUsername());
        System.out.println(user.getReviews());
        return user.getReviews();

//        List<Review> reviews = new ArrayList<>();
//        try {
//            // read the file given
//            JsonObject jsonUsers = JsonParser.parseReader(new FileReader(userPath)).getAsJsonObject();
//            try {
//                // Check if the user with the given ID exists in the database
//                if (jsonUsers.has(String.valueOf(userID))) {
//                    // Get the user object
//                    JsonObject userJson = jsonUsers.getAsJsonObject(String.valueOf(userID));
//
//                    // Check if the user has reviews
//                    if (userJson.has("reviews")) {
//                        // form array of reviews
//                        JsonArray reviewsInUser = userJson.getAsJsonArray("reviews");
//
//                        // loop through reviews in reviews array
//                        for (JsonElement reviewElement : reviewsInUser) {
//                            // set review element in the array as JsonObject
//                            JsonObject ro = reviewElement.getAsJsonObject();
//
//                            // getting review attributes from json
//                            Integer reviewerID = ro.get("userid").getAsInt(); // get reviewer ID
//                            User reviewer = userDao.getUser(reviewerID); // make User
//
//                            String dateStr = ro.get("date").getAsString(); // get date data
//                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                            Date date = sdf.parse(dateStr); // make Date
//
//                            float rating = ro.get("rating").getAsFloat(); // get rating
//                            String title = ro.get("title").getAsString(); // get title
//                            String content = ro.get("content").getAsString(); // get content
//
//                            // create Review
//                            Review review = reviewBuilder.create(reviewer.getId(), reviewer.getUsername(), date, title, content, rating);
//                            reviews.add(review); // append Review in Review array
//                        }
//                    }
//                }
//            } catch (NullPointerException e) {
//                // review list was hopefully empty
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return reviews;
    }
}
