package src.classes.com.use_case;

import com.data_access.FileUserDataAccessObject;
import com.entity.user.CommonUserFactory;
import com.entity.user.UserFactory;
import com.interface_adapter.signup.SignupController;
import com.interface_adapter.signup.SignupPresenter;
import com.use_case.signup.*;
import com.view.User.SignupServlet;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Test
    public void testInteractorExecutionWithDifPasswords() throws ServletException, IOException {
        // Mock required dependencies - Presenter, UserFactory, and UserDataAccessInterface
        SignupServlet servletMock = mock(SignupServlet.class);
        // Create the presenter with the mocked servlet
        SignupPresenter presenter = new SignupPresenter(servletMock);
        UserFactory userFactoryMock = mock(UserFactory.class);
        SignupUserDataAccessInterface userDataAccessMock = mock(SignupUserDataAccessInterface.class);

        // Create interactor instance with mock dependencies
        SignupInteractor interactor = new SignupInteractor(presenter, userFactoryMock, userDataAccessMock);

        // Create valid input data
        SignupInputData validInput = new SignupInputData("TestUser", "Pass123", "Pass", 123);

        // Stub the user not existing initially
        when(userDataAccessMock.existsByUsername("TestUser")).thenReturn(null);

        // Call the interactor with valid input data
        interactor.execute(validInput);

        verify(servletMock).signupFailed("Passwords don't match.");
    }
    @Test
    public void testInteractorExecutionWithExisitngUsername() throws ServletException, IOException {
        // Mock required dependencies - Presenter, UserFactory, and UserDataAccessInterface
        SignupServlet servletMock = mock(SignupServlet.class);
        // Create the presenter with the mocked servlet
        SignupPresenter presenter = new SignupPresenter(servletMock);
        UserFactory userFactoryMock = mock(UserFactory.class);
        SignupUserDataAccessInterface userDataAccess = new FileUserDataAccessObject();

        // Create interactor instance with mock dependencies
        SignupInteractor interactor = new SignupInteractor(presenter, userFactoryMock, userDataAccess);

        // Create valid input data
        SignupInputData validInput = new SignupInputData("ikraskov", "Almaty", "Almaty", 123);

        // Call the interactor with valid input data
        interactor.execute(validInput);

        verify(servletMock).signupFailed("User already exists.");
    }

    @Test
    public void testInteractorExecutionWithAUserWithExistingUsername() throws ServletException, IOException {
        // Mock required dependencies - Presenter, UserFactory, and UserDataAccessInterface
        SignupServlet servletMock = mock(SignupServlet.class);
        // Create the presenter with the mocked servlet
        SignupPresenter presenter = new SignupPresenter(servletMock);
        UserFactory userFactoryMock = new CommonUserFactory();
        SignupUserDataAccessInterface userDataAccess = new FileUserDataAccessObject();

        // Create interactor instance with mock dependencies and real dependencies as well
        SignupInteractor interactor = new SignupInteractor(presenter, userFactoryMock, userDataAccess);

        // create a random username
        // Create valid input data
        // create a random password
        String password = "TestUserPassword" + (int) (Math.random() * 10000);
        SignupInputData validInput = new SignupInputData("liam", password, password, 123);

        // Capture the argument passed to sendToProfileScreen method
        ArgumentCaptor<SignupOutputData> captor = ArgumentCaptor.forClass(SignupOutputData.class);
        // Call the interactor with valid input data
        interactor.execute(validInput);
        verify(servletMock).sendToProfileScreen(captor.capture());
        // Retrieve the captured argument
        SignupOutputData capturedOutputData = captor.getValue();


        // Assert specific data in the captured input data. IMPORTANT: CHANGE THE USERNAME TO THE ONE ABOVE
        assertEquals("liam", capturedOutputData.getUsername());
        assertEquals(123, capturedOutputData.getID());
    }

    @Test
    public void testInteractorExecutionWithANewUser() throws ServletException, IOException {
        // Mock required dependencies - Presenter, UserFactory, and UserDataAccessInterface
        SignupServlet servletMock = mock(SignupServlet.class);
        // Create the presenter with the mocked servlet
        SignupPresenter presenter = new SignupPresenter(servletMock);
        UserFactory userFactoryMock = new CommonUserFactory();
        SignupUserDataAccessInterface userDataAccess = new FileUserDataAccessObject();

        // Create interactor instance with mock dependencies and real dependencies as well
        SignupInteractor interactor = new SignupInteractor(presenter, userFactoryMock, userDataAccess);

        // create a random username
        String username = "TestUser" + (int) (Math.random() * 10000);
        // Create valid input data

        SignupInputData validInput = new SignupInputData(username, "parol", "parol", 123);

        // Capture the argument passed to sendToProfileScreen method
        ArgumentCaptor<SignupOutputData> captor = ArgumentCaptor.forClass(SignupOutputData.class);
        // Call the interactor with valid input data
        interactor.execute(validInput);
        verify(servletMock).sendToProfileScreen(captor.capture());
        // Retrieve the captured argument
        SignupOutputData capturedOutputData = captor.getValue();


        // Assert specific data in the captured input data. IMPORTANT: CHANGE THE USERNAME TO THE ONE ABOVE
        assertEquals(username, capturedOutputData.getUsername());
        assertEquals(123, capturedOutputData.getID());
    }


}