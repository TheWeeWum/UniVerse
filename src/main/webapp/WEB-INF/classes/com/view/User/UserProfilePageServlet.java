package com.view.User;

import com.app.ProfileSetup;
import com.entity.Reviewable;
import com.entity.building.Building;
import com.entity.review.Review;
import com.entity.room.Room;
import com.entity.user.LoggedInUser;
import com.interface_adapter.open_profile.ProfileController;
import com.use_case.open_profile.ProfileInteractor;
import com.use_case.open_profile.ProfileOutputData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserProfilePageServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here
        HttpSession session = request.getSession();
        this.request = request;
        this.response = response;

        if (session.getAttribute("loggedIn") == null) {
            // If the user is not logged in, set a default message
            session.setAttribute("username", "You are not signed in");
        } else if (session.getAttribute("loggedIn").equals(false)) {
            // If the user is not logged in, set a default message
            session.setAttribute("username", "You are not signed in");
        }

        // Redirect to the profile.jsp page
        response.sendRedirect("profile.jsp");
    }
}
