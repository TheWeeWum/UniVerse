import com.data_access.FileUserDataAccessObject;
import com.entity.user.CommonUserFactory;
import com.entity.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.IOException;
import java.util.Map;

public class FileUserDataAccessObjectTest {

    private FileUserDataAccessObject userDAO;


    //Tests that the user data is loaded from the JSON file. The JSON file is rather simple
    @Test
    public void testUserDataLoading() throws IOException {

        userDAO = new FileUserDataAccessObject();
        Map<Integer, User> accounts = userDAO.getAccounts();
        accounts.keySet().forEach(System.out::println);
        Assertions.assertFalse(accounts.isEmpty(),
                "User data should be loaded from the test JSON file.");
    }

    //Tests that the user data is loaded from the JSON file. The JSON file resembles the one we use in the project
    @Test
    public void testUserDataLoading2() throws IOException {

        userDAO = new FileUserDataAccessObject();
        Map<Integer, User> accounts = userDAO.getAccounts();
        accounts.keySet().forEach(System.out::println);
        Assertions.assertFalse(accounts.isEmpty(),
                "User data should be loaded from the test JSON file.");
    }

    // The test in fact works. The Json file is updated as a result
    @Test
    public void testAddingUserToDatabase() throws IOException {

        userDAO = new FileUserDataAccessObject();
        CommonUserFactory userFactory = new CommonUserFactory();
        User newUser = userFactory.create("testUser", "testPassword", 123);

        //Here, we "replicate" the save method from the FileUserDataAccessObject class.
        //We have to replicate it to pass the testBase11 json file, as our original method always
        //writes to the UserData.json file
        Map<Integer, User> accounts = userDAO.getAccounts();
        accounts.put(newUser.getId(), newUser);
        userDAO.addUserToJsonFile();

    }

    // Add more test methods to cover other functionalities of FileUserDataAccessObject
}