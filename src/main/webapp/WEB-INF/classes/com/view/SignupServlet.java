package com.view;

import com.interface_adapter.signup.SignupController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here
        SignupController controller = (SignupController) request.getAttribute("controller");

        // Set the variables as request attributes
        HttpSession session = request.getSession();
        session.setAttribute("controller", controller);

        // Send user to the next page
        response.sendRedirect("signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeated password");

        SignupController controller = (SignupController) request.getAttribute("controller");
        controller.execute(username, password, repeatedPassword);

        // Perform authentication (you can replace this with your actual authentication logic)
        if (isValidUser(username, password, repeatedPassword)) {
            // Create a session and store the username
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to the user profile page (you can replace this URL)
            // TODO: send to the personal users page
            response.sendRedirect("profile");
        } else {
            // Authentication failed, redirect back to the login page
            response.sendRedirect("signup.jsp");
        }
    }

    private boolean isValidUser(String username, String password, String repeatedPassword) {
        // TODO: this is temporary, needs to actually go into the code
        return true;
//        return password.equals(repeatedPassword);

        // Implement your authentication logic here (e.g., check credentials against a database)
        // Return true if the user is valid; otherwise, return false
        // Replace this with your own authentication mechanism
        // return true; // For demonstration purposes, always return true
    }
}

