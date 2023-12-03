package com.use_case.open_building;

public class OpenBuildingInputData {
    private final int userId;
    private final String buildingCode;

    public OpenBuildingInputData(int userId, String buildingCode) {
        this.userId = userId;
        this.buildingCode = buildingCode;
    }

    public int getUserId() { return userId; }

    public String getBuildingCode() {
        return buildingCode;
    }


}
