package com.use_case.display_markers;

import com.entity.map.Marker;

import java.util.List;

public class MarkerOutputData {
    private final List<Marker> markers;
    public MarkerOutputData(List<Marker> markers) {
        this.markers = markers;
    }

    public List<Marker> getMarkers() {
        return markers;
    }
}
