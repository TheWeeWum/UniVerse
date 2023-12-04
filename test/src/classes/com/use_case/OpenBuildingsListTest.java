package src.classes.com.use_case;

import com.app.BuildingListSetup;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.use_case.login.LoginOutputData;
import com.use_case.open_buildings_list.OpenBuildingsListInputData;
import com.use_case.open_buildings_list.OpenBuildingsListOutputData;
import com.view.Buildings.BuildingsListServlet;
import com.view.Buildings.BuildingsServlet;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OpenBuildingsListTest {
    // tests the clean architecture
    @Test
    public void testOpenBuildingsList() {
        BuildingsListServlet servletMock = mock(BuildingsListServlet.class);

        OpenBuildingsListController openBuildingsListController = BuildingListSetup.setup(servletMock);
        
        // mocking input data
        OpenBuildingsListInputData openBuildingsListInputData = new OpenBuildingsListInputData();

        openBuildingsListController.execute();
        // Capture the argument passed to sendToProfileScreen method
        ArgumentCaptor<OpenBuildingsListOutputData> captor = ArgumentCaptor.forClass(OpenBuildingsListOutputData.class);

        // Verify that the success view was prepared
        verify(servletMock).writeBuildings(captor.capture());
        OpenBuildingsListOutputData capturedOutputData = captor.getValue();
        assertEquals("UC", capturedOutputData.getBuildings().get(0).getCode());
        assertEquals("HH", capturedOutputData.getBuildings().get(1).getCode());
        assertEquals("SM", capturedOutputData.getBuildings().get(2).getCode());
    }

    //tests the BuildingsListServlet
    @Test
    public void buildingsServletTest() throws ServletException, IOException {
        BuildingsListServlet servletMock = new BuildingsListServlet();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        servletMock.doGet(request, response);
        verify(response).setContentType("application/json");
    }

    //tests the redirect servlet
    @Test
    public void sendToBuildingsListPageTest() throws ServletException, IOException {
        BuildingsServlet servletMock = new BuildingsServlet();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        servletMock.doGet(request, response);
        verify(response).sendRedirect("buildings.jsp");
    }
}
