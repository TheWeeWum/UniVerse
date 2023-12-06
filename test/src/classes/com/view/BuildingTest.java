package src.classes.com.view;

import com.view.Building.AddToFavouritesServlet;
import com.view.Building.BuildingInfoServlet;
import com.view.Building.BuildingPageServlet;
import com.view.MainMap.MainMapServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BuildingTest {
    @Test
    void addToFavouritesServletDoPost() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Set attributes on the session mock
        when(session.getAttribute("id")).thenReturn("5");
        when(session.getAttribute("buildingCode")).thenReturn("BA");

        // Associate the session mock with the request mock
        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        AddToFavouritesServlet servlet = new AddToFavouritesServlet();

        servlet.doPost(request, response);
    }

    @Test
    void addToFavouritesServletDoPostFail() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Associate the session mock with the request mock
        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        AddToFavouritesServlet servlet = new AddToFavouritesServlet();

        servlet.doPost(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("index.jsp");
    }

    @Test
    void buildingInfoServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Set attributes on the session mock
        when(session.getAttribute("id")).thenReturn("5");
        when(session.getAttribute("buildingCode")).thenReturn("BA");

        // Associate the session mock with the request mock
        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        BuildingInfoServlet servlet = new BuildingInfoServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).setContentType("application/json");
    }

    @Test
    void buildingPageServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Set attributes on the session mock
        when(request.getParameter("buildingCode")).thenReturn("BA");

        // Associate the session mock with the request mock
        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        BuildingPageServlet servlet = new BuildingPageServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("building.jsp");
        verify(session).setAttribute("buildingCode", "BA");
    }

    @Test
    void buildingPageServletDoPost() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Set attributes on the session mock
        when(session.getAttribute("buildingCode")).thenReturn("MM");
        when(session.getAttribute("id")).thenReturn("1");

        when(request.getParameter("reviewContent")).thenReturn("reviewContent");
        when(request.getParameter("reviewTitle")).thenReturn("reviewTitle");
        when(request.getParameter("rating")).thenReturn("3");

        when(request.getAttribute("id")).thenReturn("1");
        when(request.getAttribute("buildingCode")).thenReturn("MM");

        // Associate the session mock with the request mock
        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        BuildingPageServlet servlet = new BuildingPageServlet();

        servlet.doGet(request, response);
        servlet.doPost(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("building.jsp");
        verify(request).setAttribute("buildingCode", "MM");
        verify(request).setAttribute("id", "1");
    }
}
