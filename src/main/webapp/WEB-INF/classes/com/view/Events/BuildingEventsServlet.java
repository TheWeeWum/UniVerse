package com.view.Events;

import com.app.BuildingEventsSetup;
import com.entity.event.Event;
import com.interface_adapter.event.BuildingEventsController;
import com.use_case.buildingEvents.BuildingEventsOutputData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuildingEventsServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;

        HttpSession session = request.getSession();
        String buildingCode = session.getAttribute("buildingCode").toString();

        // Initialize the loop for the use_case
        BuildingEventsController controller = BuildingEventsSetup.setup(this);

        // call the SignupController passing it the inputs
        controller.execute(buildingCode);
    }

    public void displayEvents(BuildingEventsOutputData outputData) {
        StringBuilder eventsJson = new StringBuilder("[");
        for (Event event : outputData.getEvents()) {
            String name = event.getName();
            String organizer = event.getOrganizer();
            Date date = event.getDate();
            // TODO: add description to event
            // String desc = event.getDescription();

            eventsJson.append(String.format("{ " +
                            "\"name\": \"%s\", " +
                            "\"organizer\": \"%s\", " +
                            "\"date\": \"%s\" " +
                            "},",
                    name, organizer, date));
        }
        // delete comma at the end
        eventsJson.delete(eventsJson.length() - 1, eventsJson.length());
        eventsJson.append("]");

        System.out.println(eventsJson);

        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(eventsJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write markers");
        }
    }
}
