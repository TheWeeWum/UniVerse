package com.data_access;

import com.entity.map.Marker;
import com.use_case.display_markers.BuildingMarkerDataAccessInterface;

import java.util.List;

public class BuildingDataAccessObject implements BuildingMarkerDataAccessInterface {
    private List<Marker> markers;

    @Override
    public List<Marker> getMarkers() {
        return markers;
    }
}
