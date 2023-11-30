package com.view.User;

import com.app.ProfileSetup;
import com.entity.user.LoggedInUser;
import com.interface_adapter.open_profile.ProfileController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserProfileServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;
  //  final private LoggedInUser user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here
        HttpSession session = request.getSession();
        this.request = request;
        this.response = response;

        if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) {
            // If the user is logged in, set the user details in the session

            ProfileController controller = ProfileSetup.setup(this);
            controller.execute();

            // Add more attributes as needed
        } else {
            // If the user is not logged in, set a default message
            session.setAttribute("username", "You are not signed in");
        }

        // Redirect to the profile.jsp page
        response.sendRedirect("profile.jsp");
    }
}
