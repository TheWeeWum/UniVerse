package src.classes.com.view;

import com.app.Path;
import com.view.Building.AddToFavouritesServlet;
import com.view.Building.BuildingInfoServlet;
import com.view.Building.BuildingPageServlet;
import com.view.Events.AddEventServlet;
import com.view.Events.BuildingEventsServlet;
import com.view.Events.EventsPageServlet;
import com.view.MainMap.MainMapServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EventsTest {
    @Test
    void addEventServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create an instance of your servlet
        AddEventServlet servlet = new AddEventServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("addEvent.jsp");
    }

    @Test
    void addEventServletDoPost() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("buildingCode")).thenReturn("TESTCODE");
        when(request.getParameter("title")).thenReturn("title");
        when(request.getParameter("organizer")).thenReturn("organizer");
        when(request.getParameter("room")).thenReturn("room");
        when(request.getParameter("time")).thenReturn("1000-10-10 12:00");
        when(request.getParameter("description")).thenReturn("description");

        // Create an instance of your servlet
        AddEventServlet servlet = new AddEventServlet();

        servlet.doPost(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("events.jsp");
    }

    @Test
    void buildingEventsServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("buildingCode")).thenReturn("BA");

        when(response.getWriter()).thenReturn(new PrintWriter(Path.path + "external-data-test/FakeFileForTests.json"));

        // Create an instance of your servlet
        BuildingEventsServlet servlet = new BuildingEventsServlet();

        servlet.doGet(request, response);

        // Verify that sendRedirect was called with the expected argument
        verify(response).setContentType("application/json");
    }

    @Test
    void buildingEventsServletDoGetFail() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);


        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        BuildingEventsServlet servlet = new BuildingEventsServlet();

        servlet.doGet(request, response);

        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("index.jsp");
    }

    @Test
    void eventsPageServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Set attributes on the session mock
        when(request.getParameter("buildingCode")).thenReturn("BA");

        // Associate the session mock with the request mock
        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        EventsPageServlet servlet = new EventsPageServlet();

        servlet.doGet(request, response);

        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("events.jsp");
        verify(session).setAttribute("buildingCode", "BA");
    }
}
