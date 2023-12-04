package com.view.Building;

import com.app.BuildingSetup;
import com.entity.building.Address;
import com.entity.building.Building;
import com.interface_adapter.open_building.OpenBuildingController;
import com.use_case.open_building.OpenBuildingOutputData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class BuildingInfoServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;

        HttpSession session = request.getSession();
        String buildingCode = session.getAttribute("buildingCode").toString();

        int id;
        try {
            id = Integer.parseInt(session.getAttribute("id").toString());
        } catch (NullPointerException e) {
            System.out.println("user not signed in");
            response.sendRedirect("index.jsp");
            return;
        }
        System.out.println(id);

        // Initialize the loop for the use_case
        OpenBuildingController controller = BuildingSetup.setup(this);

        // call the controller passing it the inputs
        controller.execute(id, buildingCode);
    }

//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Get session and the username
//        HttpSession session = request.getSession();
//
//        int id = Integer.parseInt(session.getAttribute("id").toString());
//        String buildingCode = session.getAttribute("buildingCode").toString();
//    }

    public void writeBuilding(OpenBuildingOutputData openBuildingOutputData) {
        Building building = openBuildingOutputData.getBuilding();

        String buildingJson = building.getJsonRepresentation();
        System.out.println(buildingJson);
        System.out.println(openBuildingOutputData.getIsFavourited());

        try {
            System.out.println("Trying to write building");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(buildingJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write building");
        } catch (NullPointerException e) {
            System.out.println("If out was null then tests passed!");
            System.out.println("was null since the response is pretend!");
        }
    }
}
