package com.view;

import com.interface_adapter.signup.SignupController;
import com.use_case.signup.SignupOutputData;
import com.app.SignupSetup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    private SignupController controller;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here

        // Set the variables as request attributes

        // Send user to the next page

        // TODO: old. but new not implemented yet
        response.sendRedirect("signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        controller = SignupSetup.setup(this);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeated password");

        controller.execute(username, password, repeatedPassword);
    }

    public void sendToProfileScreen(SignupOutputData outputData) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username", outputData.getUsername());

        // Redirect to the user profile page
        response.sendRedirect("profile.jsp");
    }

    public void signupFailed(SignupOutputData outputData) throws IOException {
        response.sendRedirect("signup.jsp");
    }

}

