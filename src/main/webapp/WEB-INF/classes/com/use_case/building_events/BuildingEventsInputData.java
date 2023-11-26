package com.use_case.building_events;

public class BuildingEventsInputData {
    private final String buildingCode;

    public BuildingEventsInputData(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getBuildingCode() {
        return buildingCode;
    }
}
