package com.interface_adapter.building_reviews;

import com.use_case.building_reviews.BuildingReviewsOutputBoundary;
import com.use_case.building_reviews.BuildingReviewsOutputData;
import com.view.Events.BuildingEventsServlet;
import com.view.Reviews.BuildingReviewsServlet;

public class BuildingReviewsPresenter implements BuildingReviewsOutputBoundary {
    BuildingReviewsServlet buildingReviewsServlet;

    public BuildingReviewsPresenter(BuildingReviewsServlet buildingReviewsServlet) {
        this.buildingReviewsServlet = buildingReviewsServlet;
    }

    @Override
    public void prepareSuccessView(BuildingReviewsOutputData buildingReviewsOutputData) {
        buildingReviewsServlet.displayReviews(buildingReviewsOutputData);
    }
}
