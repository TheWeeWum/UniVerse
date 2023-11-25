package com.view;

import com.app.BuildingSetup;
import com.entity.building.Building;
import com.interface_adapter.open_building.OpenBuildingController;
import com.use_case.open_building.OpenBuildingOutputData;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class BuildingInfoServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;

        HttpSession session = request.getSession();
        String buildingCode = session.getAttribute("buildingCode").toString();

        // Initialize the loop for the use_case
        OpenBuildingController controller = BuildingSetup.setup(this);

        // call the SignupController passing it the inputs
        controller.execute(buildingCode);
    }

    public void writeBuilding(OpenBuildingOutputData openBuildingOutputData) {
        // StringBuilder buildingsJson = new StringBuilder("[");
        Building building = openBuildingOutputData.getBuilding();
        String name = building.getName();
        //buildingsJson.append(String.format("{ \"name\": \"%s\" },", name));

        // delete comma at the end
        // buildingsJson.delete(buildingsJson.length() - 1, buildingsJson.length());
        //buildingsJson.append("]");

        // System.out.println(buildingsJson);

        try {
            System.out.println("Trying to write building");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            // out.print(buildingsJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write buildings");
        }
    }
}
