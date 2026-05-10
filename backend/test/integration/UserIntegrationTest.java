package integration;
import io.ebean.Ebean;
import models.User;               
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import play.Application;
import play.test.Helpers;
import static org.assertj.core.api.Assertions.assertThat;

//integration tests with docker
public class UserIntegrationTest {
    private static Application app;
    private User createdUser;
//start fake play app once before all tests for real db connection
    @BeforeClass
    public static void setupApp() {
        app = Helpers.fakeApplication();
        Helpers.start(app);
    }
   //shut down play app after tests finished
    @AfterClass
    public static void tearDownApp() {
        Helpers.stop(app);
    }
//delete user created so the db doesnt fill up with test data
    @After
    public void cleanup() {
        if (createdUser != null && createdUser.getId() != 0) {
            Ebean.delete(createdUser);
            createdUser = null;
        }
    }
//happy path:save a user then read it back, fieldss should match
    @Test
    public void canSaveAndRetrieveUserFromDatabase() {
        String uniqueName = "itest_" + System.currentTimeMillis();
//timestamp keep username unique even if previous run didnt clean up
        createdUser = new User();
        createdUser.setUserName(uniqueName);
        createdUser.setEmail("[email protected]");
        createdUser.setPassword("hashed_pw_placeholder");
        createdUser.setLevel("normal");
        createdUser.save();  

        assertThat(createdUser.getId()).isGreaterThan(0);

        User found = Ebean.find(User.class, createdUser.getId());
        assertThat(found).isNotNull();
        assertThat(found.getUserName()).isEqualTo(uniqueName);
        assertThat(found.getEmail()).isEqualTo("[email protected]");
        assertThat(found.getLevel()).isEqualTo("normal");
    }
    //error case:id that isnt in the db should return null, not crash
    @Test
    public void findingNonExistentUserReturnsNull() {
        long fakeId = 99_999_999L;   
        //a big number that isnt in db
        User notFound = Ebean.find(User.class, fakeId);
        assertThat(notFound).isNull();
    }
}