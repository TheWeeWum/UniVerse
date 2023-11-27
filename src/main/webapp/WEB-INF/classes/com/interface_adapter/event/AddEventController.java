package com.interface_adapter.event;

import com.use_case.add_event.AddEventInputBoundary;
import com.use_case.add_event.AddEventInputData;
import com.use_case.add_event.AddEventOutputData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class AddEventController {
    private final AddEventInputBoundary interactor;
    public AddEventController(AddEventInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(HttpServletRequest request) {
        // get Building code so that we can save the event to the right building
        HttpSession session = request.getSession();
        String buildingCode = session.getAttribute("buildingCode").toString();

        // get the event information
        String title = request.getParameter("title");
        String organizer = request.getParameter("organizer");
        String room = request.getParameter("room");
        String time = request.getParameter("time");
        String description = request.getParameter("description");

        // try and get the time object
        Date t = null;
        System.out.println(time);
        try {
            time = time.substring(0, 4) + "-" + time.substring(5, 7) + "-" + time.substring(8, 10) + " " +
                    time.substring(11, 13) + ":" + time.substring(14, 16);
            System.out.println(time);
            t = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
        } catch (ParseException e) {
            System.out.println("Could not parse time into the Date Object in AddEventController");
        }

        // create input data to send onwards
        AddEventInputData inputData = new AddEventInputData(buildingCode, title, organizer, room, t, description);

        if (title == null || organizer == null || time == null || description == null) {
            System.out.println("Error getting request parameters in AddEventController");
        }

        interactor.execute(inputData);
    }
}
