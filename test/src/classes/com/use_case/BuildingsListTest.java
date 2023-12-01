package src.classes.com.use_case;

import com.app.BuildingListSetup;
import com.entity.event.Event;
import com.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.view.Buildings.BuildingsListServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BuildingsListTest {
    @BeforeEach
    public void setUp() {
        BuildingsListServlet servlet = new BuildingsListServlet();
        OpenBuildingsListController controller = BuildingListSetup.setup(servlet);
        controller.execute();
    }
}
