package com.use_case.building_reviews;

public class BuildingReviewsInputData {
    private final String buildingCode;
    public BuildingReviewsInputData(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getBuildingCode() {
        return buildingCode;
    }
}
