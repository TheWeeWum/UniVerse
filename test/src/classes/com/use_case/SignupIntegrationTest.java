package src.classes.com.use_case;

import com.data_access.FileUserDataAccessObject;
import com.entity.user.CommonUserFactory;
import com.interface_adapter.signup.SignupController;
import com.interface_adapter.signup.SignupPresenter;
import com.use_case.signup.*;
import com.view.User.SignupServlet;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SignupIntegrationTest {

    @Test
    public void testControllerExecution() {
        // Mock interactor and request
        SignupInteractor interactorMock = mock(SignupInteractor.class);
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);

        // Set up specific parameters for the request
        when(requestMock.getParameter("username")).thenReturn("TestUser");
        when(requestMock.getParameter("password")).thenReturn("Pass123");
        when(requestMock.getParameter("repeated password")).thenReturn("Pass123");

        // Create controller instance with mock interactor
        SignupController controller = new SignupController(interactorMock);

        // Call controller method
        controller.execute(requestMock);

        // Capture the argument passed to execute method
        ArgumentCaptor<SignupInputData> captor = ArgumentCaptor.forClass(SignupInputData.class);
        verify(interactorMock).execute(captor.capture());

        // Retrieve the captured argument
        SignupInputData capturedInputData = captor.getValue();

        // Assert specific data in the captured input data
        assertEquals("TestUser", capturedInputData.getUsername());
        assertEquals("Pass123", capturedInputData.getPassword());
        assertEquals("Pass123", capturedInputData.getRepeatPassword());
    }
}