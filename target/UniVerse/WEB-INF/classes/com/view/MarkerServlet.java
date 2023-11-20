package com.view;

import com.app.MarkerSetup;
import com.entity.map.Marker;
import com.entity.building.Building;
import com.interface_adapter.marker.MarkerController;
import com.use_case.display_markers.MarkerOutputData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarkerServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;

        // Initialize the loop for the use_case
        MarkerController controller = MarkerSetup.setup(this);

        // call the SignupController passing it the inputs
        controller.execute();
    }

    public void writeMarkers(MarkerOutputData markers) {
        StringBuilder markerJson = new StringBuilder("[");
        for (Marker marker : markers.getMarkers()) {
            Building building = marker.getBuilding();
            String name = building.getName();

            float lat = marker.getLatitude();
            float lon = marker.getLongitude();

            markerJson.append(String.format("{ \"lat\": %f, \"lng\": %f, \"title\": \"%s\" },", lat, lon, name));
        }
        markerJson.delete(markerJson.length()-1, markerJson.length());
        markerJson.append("]");
        System.out.println(markerJson);

        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(markerJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write markers");
        }
    }
}