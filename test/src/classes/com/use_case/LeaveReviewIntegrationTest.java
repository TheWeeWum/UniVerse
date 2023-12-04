package src.classes.com.use_case;

import com.app.LoginSetup;
import com.app.ReviewSetup;
import com.interface_adapter.leave_review.ReviewController;
import com.interface_adapter.login.LoginController;
import com.use_case.login.LoginInputData;
import com.view.Building.BuildingPageServlet;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeaveReviewIntegrationTest {

    @Test
    public void testLeavingReview() throws IOException, ServletException {
        BuildingPageServlet servletMock = mock(BuildingPageServlet.class);
        ReviewController reviewController = ReviewSetup.setup(servletMock);
        // Mocking input data
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getAttribute("id")).thenReturn("1");
        when(request.getParameter("reviewTitle")).thenReturn("TestReview");
        when(request.getParameter("reviewContent")).thenReturn("TestReviewContent");
        when(request.getParameter("rating")).thenReturn("5");
        when(request.getAttribute("buildingCode")).thenReturn("BA");

        reviewController.execute(request);

        // Capture the argument passed to updateAfterReview method
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // Verify that the success view was prepared
        verify(servletMock).updateAfterReview(captor.capture());
        String capturedOutputData = captor.getValue();
        assertEquals("The review has been saved.", capturedOutputData);

    }
    @Test
    public void testLeavingReviewGuest() throws IOException, ServletException {
        BuildingPageServlet servletMock = mock(BuildingPageServlet.class);
        ReviewController reviewController = ReviewSetup.setup(servletMock);
        // Mocking input data
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getAttribute("id")).thenReturn("-1");
        when(request.getParameter("reviewTitle")).thenReturn("TestReview");
        when(request.getParameter("reviewContent")).thenReturn("TestReviewContent");
        when(request.getParameter("rating")).thenReturn("5");
        when(request.getAttribute("buildingCode")).thenReturn("BA");

        reviewController.execute(request);

        // Capture the argument passed to updateAfterReview method
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // Verify that the success view was prepared
        verify(servletMock).updateAfterReview(captor.capture());
        String capturedOutputData = captor.getValue();
        assertEquals("The review has been saved.", capturedOutputData);

    }

//    @Test
//    public void test2() throws IOException, ServletException {
//        LoginServlet servletMock = mock(LoginServlet.class);
//        LoginController loginController = LoginSetup.setup(servletMock);
//        // Mocking input data
//        LoginInputData validInput = new LoginInputData("Noname", "dark");
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        when(request.getParameter("username")).thenReturn("Noname");
//        when(request.getParameter("password")).thenReturn("dark");
//        loginController.execute(request);
//
//        // Capture the argument passed to signInFailed method
//        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//
//        // Verify that the fail  view was prepared
//        verify(servletMock).signInFailed(captor.capture());
//        String capturedOutputData = captor.getValue();
//
//        assertEquals("User with the following credentials doesn't exist.", capturedOutputData);
//    }
}
