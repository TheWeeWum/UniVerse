package com.view.Favourites;

import com.app.AddToFavouritesSetup;
import com.app.FavouritesSetup;
import com.entity.building.Building;
import com.interface_adapter.add_to_favourites.AddToFavouritesController;
import com.interface_adapter.open_favourites.OpenFavouritesController;
import com.use_case.add_to_favourites.AddToFavouritesOutputData;
import com.use_case.open_favourites.OpenFavouritesOutputData;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FavouritesInfoServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;

        HttpSession session = request.getSession();

        // String buildingCode = session.getAttribute("buildingCode").toString();
        int userId;
        try {
            userId = Integer.parseInt(session.getAttribute("id").toString());
        } catch (NullPointerException e) {
            System.out.println("user not signed in");
            response.sendRedirect("index.jsp");
            return;
        }

        // Initialize the loop for the use_case
        OpenFavouritesController controller = FavouritesSetup.setup(this);

        // call the controller passing it the inputs
        System.out.println("lllaa");
        controller.execute(userId);
    }

    public void writeFavouriteBuildings(OpenFavouritesOutputData openFavouritesOutputData) {

        StringBuilder buildingsJson = new StringBuilder("[");
        System.out.println(openFavouritesOutputData.getFavouriteBuildings());

        for (Building building : openFavouritesOutputData.getFavouriteBuildings()) {
//            buildingsJson.append(building.getJsonRepresentation()).append(",");
            String name = building.getName();
            String code = building.getCode();

            buildingsJson.append(String.format("{ " + "\"name\": \"%s\", " + "\"code\": \"%s\" " + "},", name, code));
        }
        // delete comma at the end
        buildingsJson.delete(buildingsJson.length() - 1, buildingsJson.length());
        buildingsJson.append("]");

        try {
            System.out.println("Trying to write favourite building");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(buildingsJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write buildings");
        }

    }
}
