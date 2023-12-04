package com.view.Events;

import com.app.AddEventSetup;
import com.interface_adapter.event.AddEventController;
import com.interface_adapter.signup.SignupController;
import com.use_case.add_event.AddEventOutputData;
import com.use_case.signup.SignupOutputData;
import com.app.SignupSetup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddEventServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("addEvent.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // save the request and response for use later in
        // sendToProfileScreen and signupFailed
        this.request = request;
        this.response = response;
        // Initialize the loop for the use_case
        AddEventController controller = AddEventSetup.setup(this);

        // call the SignupController passing it the inputs
        controller.execute(request);
    }

    public void successView(AddEventOutputData outputData) {
        try {
            // Redirect to the user profile page
            response.sendRedirect("events.jsp");
        } catch (IOException e) {
            System.out.println("Could not find events page");
        }
    }
}

