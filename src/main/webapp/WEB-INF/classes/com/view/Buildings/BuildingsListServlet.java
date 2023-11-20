package com.view.Buildings;

import com.app.MarkerSetup;
import com.entity.map.Marker;
import com.entity.building.Building;
import com.interface_adapter.marker.MarkerController;
import com.use_case.display_markers.MarkerOutputData;
import com.use_case.open_buildings_list.OpenBuildingsListOutputData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuildingsListServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;
    }

    public void writeBuildings(OpenBuildingsListOutputData openBuildingsListOutputData) {
        StringBuilder buildingsJson = new StringBuilder("[");
        for (Building building : openBuildingsListOutputData.getBuildings()) {
            String name = building.getName();

            buildingsJson.append(String.format("{ \"name\": \"%s\" }, ", name));
        }
        // delete comma at the end
        buildingsJson.delete(buildingsJson.length() - 1, buildingsJson.length());
        buildingsJson.append("]");

        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(buildingsJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write buildings");
        }
    }
}
