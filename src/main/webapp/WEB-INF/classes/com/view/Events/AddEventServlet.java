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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here

        // Set the variables as request attributes

        // Send user to the next page

        // TODO: old. but new not implemented yet
        HttpSession session = request.getSession();
        String buildingCode = session.getAttribute("buildingCode").toString();
        response.sendRedirect("addEvent.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        // get the session to change the data on
        HttpSession session = request.getSession();

        try {
            // Redirect to the user profile page
            response.sendRedirect("events.jsp");
        } catch (IOException e) {
            signupFailed("Could not send to page");
        }
    }

    public void signupFailed(String message) {
        try {
            request.setAttribute("errorMessage", message);
            request.getRequestDispatcher("addEvent.jsp").forward(request, response);
        } catch (IOException e) {
            System.out.println("Could not send to addEvent page");
        } catch (ServletException e) {
            System.out.println("Could not forward request,response objects in AddEventServlet");
        }
    }

}

