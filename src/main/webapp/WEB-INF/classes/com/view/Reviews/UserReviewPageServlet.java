package com.view.Reviews;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserReviewPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userID;
        try {
            userID = Integer.parseInt(session.getAttribute("id").toString());
        } catch (NullPointerException e) {
            System.out.println("user not signed in");
            response.sendRedirect("index.jsp");
            return;
        }

        // TODO: if not signed in redirect to mainmap i guess

        System.out.println("URPServlet");

        session.setAttribute("userID", userID);
        response.sendRedirect("user_reviews.jsp");
    }
}
