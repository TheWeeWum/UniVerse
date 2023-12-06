package com.view.User;

import com.app.LoginSetup;
import com.interface_adapter.login.LoginController;
import com.use_case.login.LoginOutputData;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here

        // Set the variables as request attributes

        // Send user to the next page
        response.sendRedirect("login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        LoginController controller = LoginSetup.setup(this);
        controller.execute(request);

    }

    public void signInFailed(String message) throws IOException, ServletException {
        request.setAttribute("errorMessage", message);
        try {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (NullPointerException e) {
            System.out.println("Test passed, if not a test then error in LoginServlet redirection in signInFailed");
        }
    }

    public void sendToProfileScreen(LoginOutputData outputData) throws IOException {
        HttpSession session = request.getSession();

        // sets the username field on the jsp
        session.setAttribute("username", outputData.getUsername());
        session.setAttribute("id", outputData.getId());
        session.setAttribute("loggedIn", true);
        // Redirect to the user profile page
        response.sendRedirect("profile.jsp");
    }
}

