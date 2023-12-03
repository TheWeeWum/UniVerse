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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;

        HttpSession session = request.getSession();
        String buildingCode = session.getAttribute("buildingCode").toString();

        int id = Integer.parseInt(session.getAttribute("id").toString());

        System.out.println(id);

        // Initialize the loop for the use_case
        OpenBuildingController controller = BuildingSetup.setup(this);

        // call the controller passing it the inputs
        controller.execute(id, buildingCode);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get session and the username
        HttpSession session = request.getSession();

        int id = Integer.parseInt(session.getAttribute("id").toString());
        session.getAttribute("buildingCode");

    }

    public void writeBuilding(OpenBuildingOutputData openBuildingOutputData) {
        Building building = openBuildingOutputData.getBuilding();

//        StringBuilder buildingJson = new StringBuilder("[");
//
//        String name = building.getName();
//
//        String code = building.getCode();
//
//        String street = building.getAddress().getStreet();
//        String city = building.getAddress().getCity();
//        String province = building.getAddress().getProvince();
//        String country = building.getAddress().getCountry();
//        String postal = building.getAddress().getPostal();
//        String address = street + ", " + city + ", " + province + ", " + country + ", " + postal;
//
//        float lat = building.getLocation().getLatitude();
//        float lng = building.getLocation().getLongitude();
//
//        String campus = building.getCampus();
//
//        buildingJson.append(String.format("{ " +
//                "\"name\": \"%s\", " +
//                "\"code\": \"%s\", " +
//                "\"address\": \"%s\", " +
//                "\"campus\": \"%s\", " +
//                "\"lat\": \"%f\", " +
//                "\"lng\": \"%f\" " +
//                "}", name, code, address, campus, lat, lng));
//
//        buildingJson.append("]");

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
        }
    }
}
