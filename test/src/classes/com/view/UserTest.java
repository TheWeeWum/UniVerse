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
import com.view.Reviews.UserReviewPageServlet;
import com.view.Reviews.UserReviewServlet;
import com.view.User.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockRequestDispatcher;

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

public class UserTest {
    @Test
    void aboutServletTest() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create an instance of your servlet
        AboutServlet servlet = new AboutServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("about.jsp");
    }

    @Test
    void favouriteServletTest() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create an instance of your servlet
        FavouritesServlet servlet = new FavouritesServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("favourites.jsp");
    }

    @Test
    void indexServletTest() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create an instance of your servlet
        IndexServlet servlet = new IndexServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("index.jsp");
    }

    @Test
    void loginServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create an instance of your servlet
        LoginServlet servlet = new LoginServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("login.jsp");
    }

    @Test
    void loginServletDoPost() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        when(request.getParameter("username")).thenReturn("ikraskov");
        when(request.getParameter("password")).thenReturn("Almaty");

        // Create an instance of your servlet
        LoginServlet servlet = new LoginServlet();

        servlet.doPost(request, response);
        // Verify that sendRedirect was called with the expected argument

        verify(session).setAttribute("username", "ikraskov");
        verify(session).setAttribute("loggedIn", true);
        verify(response).sendRedirect("profile.jsp");
    }

    @Test
    void loginServletDoPostFail() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        Date date = new Date();
        String username = "testUsername" + date.getTime();
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn("password");

        // Create an instance of your servlet
        LoginServlet servlet = new LoginServlet();

        servlet.doPost(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(request).getRequestDispatcher("login.jsp");
    }

    @Test
    void signupServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create an instance of your servlet
        SignupServlet servlet = new SignupServlet();

        servlet.doGet(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(response).sendRedirect("signup.jsp");
    }

    @Test
    void signupServletDoPost() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        Date date = new Date();
        String username = "testUsername" + date.getTime();
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn("password");
        when(request.getParameter("repeated password")).thenReturn("password");

        // Create an instance of your servlet
        SignupServlet servlet = new SignupServlet();

        servlet.doPost(request, response);
        // Verify that sendRedirect was called with the expected argument
        verify(session).setAttribute("username", username);
        verify(session).setAttribute("loggedIn", true);
        verify(response).sendRedirect("profile.jsp");
    }

    @Test
    void signupServletDoPostFail() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        Date date = new Date();
        String username = "testUsername" + date.getTime();
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn("password");
        when(request.getParameter("repeated password")).thenReturn("password2");

        // Create an instance of your servlet
        SignupServlet servlet = new SignupServlet();

        servlet.doPost(request, response);
        verify(request).setAttribute("errorMessage", "Passwords don't match.");
    }

    @Test
    void userProfilePageServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("loggedIn")).thenReturn(true);

        // Create an instance of your servlet
        UserProfilePageServlet servlet = new UserProfilePageServlet();

        servlet.doGet(request, response);

        verify(response).sendRedirect("profile.jsp");
    }

    @Test
    void userProfilePageServletDoGetFailFalse() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("loggedIn")).thenReturn(false);

        // Create an instance of your servlet
        UserProfilePageServlet servlet = new UserProfilePageServlet();

        servlet.doGet(request, response);

        verify(session).setAttribute("username", "You are not signed in");
        verify(response).sendRedirect("profile.jsp");
    }

    @Test
    void userProfilePageServletDoGetFailNull() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("loggedIn")).thenReturn(null);

        // Create an instance of your servlet
        UserProfilePageServlet servlet = new UserProfilePageServlet();

        servlet.doGet(request, response);

        verify(session).setAttribute("username", "You are not signed in");
        verify(response).sendRedirect("profile.jsp");
    }

    @Test
    void userProfileServletDoGet() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("id")).thenReturn("1");
        when(response.getWriter()).thenReturn(new PrintWriter(Path.path + "external-data-test/FakeFileForTests.json"));

        // Create an instance of your servlet
        UserProfileServlet servlet = new UserProfileServlet();

        servlet.doGet(request, response);

        verify(response).setContentType("application/json");
    }

    @Test
    void userProfileServletDoGetFail() throws ServletException, IOException {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        // Create an instance of your servlet
        UserProfileServlet servlet = new UserProfileServlet();

        servlet.doGet(request, response);

        verify(response).sendRedirect("index.jsp");
    }
}
