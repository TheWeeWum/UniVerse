package com.view.Buildings;

import com.entity.building.Building;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.use_case.open_buildings_list.OpenBuildingsListOutputData;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuildingsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("buildings.jsp");
    }
}
