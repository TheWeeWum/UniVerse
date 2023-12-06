package src.classes.com.use_case;

import com.app.BuildingReviewsSetup;
import com.interface_adapter.building_reviews.BuildingReviewsController;
import com.use_case.building_reviews.BuildingReviewsOutputData;
import com.view.Reviews.BuildingReviewsServlet;
import com.view.Reviews.BuildingReviewsPageServlet;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BuildingReviewsTest {
    // test clean architecture
    @Test
    public void testBuildingReviews() {
        BuildingReviewsServlet servletMock = mock(BuildingReviewsServlet.class);
        BuildingReviewsController buildingReviewsController = BuildingReviewsSetup.setup(servletMock);

        buildingReviewsController.execute("BA");

        // Capture the argument passed to displayReviews method
        ArgumentCaptor<BuildingReviewsOutputData> captor = ArgumentCaptor.forClass(BuildingReviewsOutputData.class);

        // Verify that the success view was prepared
        verify(servletMock).displayReviews(captor.capture());
        BuildingReviewsOutputData capturedOutputData = captor.getValue();
        assertEquals(1, capturedOutputData.getReviews().get(0).getUser());
        assertEquals(447938204, capturedOutputData.getReviews().get(1).getUser());
        assertEquals(2, capturedOutputData.getReviews().get(2).getUser());
    }

    // test BuildingReviewsServlet
    @Test
    public void buildingReviewsServletTest() throws ServletException, IOException {
        BuildingReviewsServlet servletMock = new BuildingReviewsServlet();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("buildingCode")).thenReturn("yippee");

        servletMock.doGet(request, response);
        verify(response).setContentType("application/json");
    }

    //test redirect to BuildingReviewsPage
    @Test
    public void sendToBuildingReviewsPageTest() throws ServletException, IOException {
        BuildingReviewsPageServlet servletMock = new BuildingReviewsPageServlet();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getParameter("buildingCode")).thenReturn("TEST");
        when(request.getSession()).thenReturn(session);

        servletMock.doGet(request, response);
        verify(response).sendRedirect("building_reviews.jsp");
    }
}
