package com.interface_adapter.building_reviews;

import com.use_case.building_reviews.BuildingReviewsInputBoundary;
import com.use_case.building_reviews.BuildingReviewsInputData;

public class BuildingReviewsController {
    BuildingReviewsInputBoundary buildingReviewsInteractor;
    public BuildingReviewsController(BuildingReviewsInputBoundary buildingReviewsInteractor) {
        this.buildingReviewsInteractor = buildingReviewsInteractor;
    }

    public void execute(String buildingCode) {
        BuildingReviewsInputData buildingReviewsInputData = new BuildingReviewsInputData(buildingCode);
        buildingReviewsInteractor.execute(buildingReviewsInputData);
    }
}
