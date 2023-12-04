package src.classes.com.use_case;

import com.app.LoginSetup;
import com.data_access.FileUserDataAccessObject;
import com.interface_adapter.login.LoginController;
import com.interface_adapter.login.LoginPresenter;
import com.use_case.login.LoginInputData;
import com.use_case.login.LoginInteractor;
import com.use_case.login.LoginOutputData;
import com.use_case.login.LoginUserDataAccessInterface;
import com.use_case.signup.SignupOutputData;
import com.view.User.LoginServlet;
import com.view.User.SignupServlet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LogInIntegrationTest {

    private LoginInteractor interactor;
    private LoginUserDataAccessInterface userDataAccessObject;

    @Before
    public void setUp() {
        userDataAccessObject = new FileUserDataAccessObject(); // Using the actual implementation for testing
        LoginPresenter presenterMock = mock(LoginPresenter.class);
        interactor = new LoginInteractor(presenterMock, userDataAccessObject);
    }

    @Test
    public void testValidLogin() throws IOException {
        LoginServlet servletMock = mock(LoginServlet.class);
        LoginController loginController = LoginSetup.setup(servletMock);
        // Mocking input data
        LoginInputData validInput = new LoginInputData("ikraskov", "Almaty");
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("username")).thenReturn("ikraskov");
        when(request.getParameter("password")).thenReturn("Almaty");
        loginController.execute(request);

        // Capture the argument passed to sendToProfileScreen method
        ArgumentCaptor<LoginOutputData> captor = ArgumentCaptor.forClass(LoginOutputData.class);

        // Verify that the success view was prepared
        verify(servletMock).sendToProfileScreen(captor.capture());
        LoginOutputData capturedOutputData = captor.getValue();
        assertEquals("ikraskov", capturedOutputData.getUsername());
        assertEquals(1, capturedOutputData.getId());
    }

}