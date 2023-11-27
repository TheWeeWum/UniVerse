package com.view.Events;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EventsPageServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String buildingCode = request.getParameter("buildingCode");
        HttpSession session = request.getSession();

        session.setAttribute("buildingCode", buildingCode);
        response.sendRedirect("events.jsp");
    }
}
