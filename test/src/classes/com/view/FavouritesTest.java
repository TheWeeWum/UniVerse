package src.classes.com.view;

import com.app.Path;
import com.view.Building.AddToFavouritesServlet;
import com.view.Building.BuildingInfoServlet;
import com.view.Building.BuildingPageServlet;
import com.view.Events.AddEventServlet;
import com.view.Events.BuildingEventsServlet;
import com.view.Events.EventsPageServlet;
import com.view.Favourites.FavouritesInfoServlet;
import com.view.Favourites.FavouritesPageServlet;
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

public class FavouritesTest {
    @Test
    void favouritesInfoServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(session.getAttribute("id")).thenReturn("1");
        when(request.getSession()).thenReturn(session);

        when(response.getWriter()).thenReturn(new PrintWriter(Path.path + "external-data-test/FakeFileForTests.json"));

        // Create an instance of your servlet
        FavouritesInfoServlet servlet = new FavouritesInfoServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).setContentType("application/json");
    }

    @Test
    void favouritesPageServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("id")).thenReturn("1");

        // Create an instance of your servlet
        FavouritesPageServlet servlet = new FavouritesPageServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("favourites.jsp");
    }

    @Test
    void favouritesPageServletDoGetFail() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        FavouritesPageServlet servlet = new FavouritesPageServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("index.jsp");
    }
}
