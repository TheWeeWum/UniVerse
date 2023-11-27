package com.view.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here

        // Set the variables as request attributes

        // Send user to the next page
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // gets the username and password from the input fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // TODO: all of this needs to be changed to the clean architecture setup.

        // Create a session and store the username
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        // Redirect to the user profile page (you can replace this URL)
        // TODO: send to the personal users page
        response.sendRedirect("profile.jsp");
    }
}

