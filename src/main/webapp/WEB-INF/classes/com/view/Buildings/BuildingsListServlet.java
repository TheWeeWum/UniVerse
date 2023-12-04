package com.view.Buildings;

import com.app.BuildingListSetup;
import com.entity.building.Building;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.use_case.open_buildings_list.OpenBuildingsListOutputData;
import org.mockito.internal.matchers.Null;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuildingsListServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;

        // Initialize the loop for the use_case
        OpenBuildingsListController controller = BuildingListSetup.setup(this);

        // call the SignupController passing it the inputs
        controller.execute();
    }

    public void writeBuildings(OpenBuildingsListOutputData openBuildingsListOutputData) {
        StringBuilder buildingsJson = new StringBuilder("[");

        for (Building building : openBuildingsListOutputData.getBuildings()) {
            String name = building.getName();
            String code = building.getCode();

            buildingsJson.append(String.format("{ " + "\"name\": \"%s\", " + "\"code\": \"%s\" " + "},", name, code));
        }
        // delete comma at the end
        buildingsJson.delete(buildingsJson.length() - 1, buildingsJson.length());
        buildingsJson.append("]");

        System.out.println(buildingsJson);

        try {
            System.out.println("Trying to write buildings");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(buildingsJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write buildings");
        } catch (NullPointerException e) {
            System.out.println("Went in a full loop!");
        }
    }
}
