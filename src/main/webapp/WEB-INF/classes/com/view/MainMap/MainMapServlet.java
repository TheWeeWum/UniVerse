package com.view.MainMap;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainMapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here

        // Set the variables as request attributes

        // Send user to the next page
        response.sendRedirect("mainmap.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a session and store the username
        HttpSession session = request.getSession();
        // session.setAttribute("username", username);

        // TODO: Redirect to the user to building page maybe?
        // response.sendRedirect("profile.jsp");
    }
}

