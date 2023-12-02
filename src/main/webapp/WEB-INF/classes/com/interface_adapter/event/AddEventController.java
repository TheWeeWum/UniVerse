package com.interface_adapter.event;

import com.use_case.add_event.AddEventInputBoundary;
import com.use_case.add_event.AddEventInputData;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEventController {
    private final AddEventInputBoundary interactor;
    public AddEventController(AddEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(HttpServletRequest request) {
        String title = request.getParameter("title");
        String organizer = request.getParameter("organizer");
        String time = request.getParameter("time");
        String description = request.getParameter("description");

        Date t = null;
        try {
            t = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(time);
        } catch (ParseException e) {
            System.out.println("Could not parse time into the Date Object in AddEventController");
        }

        AddEventInputData inputData = new AddEventInputData(title, organizer, t, description);

        if (title == null || organizer == null || time == null || description == null) {
            System.out.println("Error getting request parameters in AddEventController");
        }

        interactor.execute(inputData);
    }
}
