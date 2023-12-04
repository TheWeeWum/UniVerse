package src.classes.com.view;
import com.entity.review.Review;
import com.interface_adapter.building_reviews.BuildingReviewsController;
import com.use_case.building_reviews.BuildingReviewsOutputData;
import com.view.Reviews.BuildingReviewsServlet;
import com.data_access.BuildingReviewDataAccessObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class BuildingReviewsServletTest {

    @InjectMocks
    private BuildingReviewsServlet buildingReviewsServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private BuildingReviewsController buildingReviewsController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGet() throws Exception {
        // Mocking session and request
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("buildingCode")).thenReturn("BA");

        // Calling the servlet's doGet method
        buildingReviewsServlet.doGet(request, response);

        // Verifying that the BuildingReviewsController's execute method was called with the correct building code
        verify(buildingReviewsController).execute("BA");
    }

    @Test
    public void testDisplayReviews() throws IOException {
        // Mocking the BuildingReviewsOutputData
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review(1, "John Doe", new Date(), "Title", "Content", 4.5f));
        BuildingReviewsOutputData outputData = new BuildingReviewsOutputData(reviews);

        // Mocking the response.getWriter() and PrintWriter
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Calling the displayReviews method
        buildingReviewsServlet.displayReviews(outputData);

        // Verifying that the response was set up correctly
        verify(response).setContentType("application/json");
        verify(response.getWriter()).print("[{\"username\":\"John Doe\",\"userID\":1,\"date\":\"<date>\",\"title\":\"Title\",\"rating\":4.5,\"content\":\"Content\"}]");
        verify(response.getWriter()).flush();
    }
}
