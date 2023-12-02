package com.view.Building;

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
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String buildingCode = request.getParameter("buildingCode");

        session.setAttribute("buildingCode", buildingCode);

        response.sendRedirect("building.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(session.getAttribute("id").toString());
        String buildingCode = session.getAttribute("buildingCode").toString();

        // save the request and response for use later in
        this.request = request;
        this.response = response;
        // Initialize the loop for the use_case
        AddToFavouritesController controller = AddToFavouritesSetup.setup(this);

        // call the controller passing it the inputs
        controller.execute(userId, buildingCode);
    }
}
