package src.classes.com.view;

import com.app.BuildingListSetup;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.view.MainMap.MainMapServlet;
import com.view.MainMap.MarkerServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.verify;

public class MainMapTest {
    @Test
    void mainMapServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create an instance of your servlet
        MainMapServlet servlet = new MainMapServlet();

        // Call the doGet method with the mocked request and response
        servlet.doGet(request, response);

        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("mainmap.jsp");
    }

    @Test
    void markerServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create an instance of your servlet
        MarkerServlet servlet = new MarkerServlet();

        // Call the doGet method with the mocked request and response
        servlet.doGet(request, response);

        // Verify that sendRedirect was called with the expected argument
        verify(response).setContentType("application/json");
    }
}
