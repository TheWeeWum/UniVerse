package com.view.MainMap;

import com.app.MarkerSetup;
import com.entity.building.Address;
import com.entity.building.Location;
import com.entity.building.Building;
import com.entity.event.Event;
import com.interface_adapter.marker.MarkerController;
import com.use_case.display_markers.MarkerOutputData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

    public void writeMarkers(MarkerOutputData buildings) {
        StringBuilder markerJson = new StringBuilder("[");
        for (Building building : buildings.getBuildings()) {

            Location location = building.getLocation();
            String code = building.getCode();
            String name = building.getName();
            String shortname = building.getShortname();
            String campus = building.getCampus();

            Address address = building.getAddress();
            String street = address.getStreet();
            String city = address.getCity();
            String province = address.getProvince();
            String country = address.getCountry();
            String postal = address.getPostal();

            float lat = location.getLatitude();
            float lon = location.getLongitude();

            List<Event> events = building.getEvents();

            markerJson.append(String.format("{ " +
                    "\"name\": \"%s\", " +
                    "\"code\": \"%s\", " +
                    "\"campus\": \"%s\", " +
                    "\"street\": \"%s\", " +
                    "\"city\": \"%s\", " +
                    "\"province\": \"%s\", " +
                    "\"country\": \"%s\", " +
                    "\"postal\": \"%s\", " +
                    "\"lat\": %f, " +
                    "\"lng\": %f, " +
                    "\"events\": [ ",
                    name, code, campus, street, city, province, country, postal, lat, lon));
            for (Event event : events) {
                markerJson.append(String.format("{" +
                        "\"building\": \"%s\"," +
                        "\"room\": \"%s\"," +
                        "\"name\":\"%s\"," +
                        "\"organizer\":\"%s\"," +
                        "\"date\":\"%s\"" +
                        "},",
                        code, event.getLocation(), event.getName(), event.getOrganizer(), event.getDate()));
            }
            markerJson.delete(markerJson.length()-1, markerJson.length());
            markerJson.append("]},");
        }
        markerJson.delete(markerJson.length()-1, markerJson.length());
        markerJson.append("]");

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
