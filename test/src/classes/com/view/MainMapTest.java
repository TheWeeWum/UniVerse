package src.classes.com.view;

import com.app.BuildingListSetup;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.view.MainMap.MainMapServlet;
import org.junit.jupiter.api.BeforeEach;

public class MainMapTest {
    @BeforeEach
    public void setUp() {
        MainMapServlet servlet = new MainMapServlet();
    }
}
