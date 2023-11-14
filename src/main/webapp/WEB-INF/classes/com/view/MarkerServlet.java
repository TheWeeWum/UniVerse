package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarkerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Simulate fetching marker data from a database or other source
        String markerData = "[{ \"lat\": 43.66234588623047, \"lng\": -79.3955307006836, \"title\": \"Marker 1\" }, { \"lat\": 43.655, \"lng\": -79.394, \"title\": \"Marker 2\" }]";

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(markerData);
        out.flush();
    }
}