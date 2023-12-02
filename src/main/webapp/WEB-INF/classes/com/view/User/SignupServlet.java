package com.view.User;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Perform data retrieval or processing here
        // Set the variables as request attributes

        // Send user to the next page

        // TODO: old. but new not implemented yet
        response.sendRedirect("signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // save the request and response for use later in
        // sendToProfileScreen and signupFailed
        this.request = request;
        this.response = response;
        // Initialize the loop for the use_case
        SignupController controller = SignupSetup.setup(this);

        // call the SignupController passing it the inputs
        controller.execute(request);
    }

    public void sendToProfileScreen(SignupOutputData outputData) throws IOException {
        // get the session to change the data on
        HttpSession session = request.getSession();

        // sets the username field on the jsp
        session.setAttribute("username", outputData.getUsername());
        session.setAttribute("id", outputData.getID());
        session.setAttribute("loggedIn", true);
        // Redirect to the user profile page
        response.sendRedirect("profile.jsp");
    }

    public void signupFailed(String message) throws IOException, ServletException {
        request.setAttribute("errorMessage", message);
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

}

