package com.view.Building;

import com.app.ReviewSetup;
import com.interface_adapter.leave_review.ReviewController;

import com.app.AddEventSetup;
import com.app.AddToFavouritesSetup;
import com.interface_adapter.add_to_favourites.AddToFavouritesController;
import com.interface_adapter.event.AddEventController;
import com.use_case.add_event.AddEventOutputData;
import com.use_case.add_to_favourites.AddToFavouritesOutputData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BuildingPageServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        String buildingCode = request.getParameter("buildingCode");

        session.setAttribute("buildingCode", buildingCode);

        response.sendRedirect("building.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        request.setAttribute("buildingCode", session.getAttribute("buildingCode"));
        request.setAttribute("id" , session.getAttribute("id"));

        ReviewController controller = ReviewSetup.setup(this);
        controller.execute(request);
    }

    public void updateAfterReview(String message) throws IOException, ServletException {

        request.setAttribute("ReviewMessage", message);
        request.getRequestDispatcher("building.jsp").forward(request, response);
    }
}
