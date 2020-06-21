import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
public class UserTest extends ApplicationTest {
    private static final String test_user = "tester";
    private static final String test_pass = "pass";
    private static final String test_first = "first";
    private static final String test_last="last";
    private static final String test_address = "addr";
    private static final String test_email = "email";
    private static final String test_number = "number";
    private static final String test_role = "number";
    @Override
    public void start(Stage stage) throws Exception {

    }

    private User user_test = new User();


    @Test
    public void testUsernameGetterSetter() {
        user_test.setUsername(test_user);
        assertEquals(test_user, user_test.getUsername());

    }
    @Test
    public void testPasswordGetterSetter() {
        user_test.setPassword(test_pass);
        assertEquals(test_pass, user_test.getPassword());

    }
    @Test
    public void testFirstNameGetterSetter() {
        user_test.setfirstName(test_first);
        assertEquals(test_first, user_test.getfirstName());

    }
    @Test
    public void testLastNameGetterSetter() {
        user_test.setlastName(test_last);
        assertEquals(test_last, user_test.getlastName());

    }

    @Test
    public void testAddressNameGetterSetter() {
        user_test.setaddress(test_address);
        assertEquals(test_address, user_test.getaddress());

    }
    @Test
    public void testNumberGetterSetter() {
        user_test.setnumber(test_number);
        assertEquals(test_number, user_test.getnumber());

    }

    @Test
    public void testEmailGetterSetter() {
        user_test.setemail(test_email);
        assertEquals(test_email, user_test.getemail());

    }
    @Test
    public void testRoleGetterSetter() {
        user_test.setRole(test_role);
        assertEquals(test_role, user_test.getRole());

    }
}
