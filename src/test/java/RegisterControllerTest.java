import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.File;

public class RegisterControllerTest extends ApplicationTest {
    private RegisterController controller;
    private static final String u = "user";
    private static final String p = "pass";
    private static final String n = "number";
    private static final String e = "email";
    private static final String a = "address";
    private static final String ln = "last";
    private static final String fn = "first";
    private static final String r = "Employee";

    @Override
    public void start(Stage stage) throws Exception {
    }

    @Before
    public void setup() throws Exception {

        controller = new RegisterController();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.emailField = new TextField();
        controller.firstNameField = new TextField();
        controller.lastNameField = new TextField();
        controller.addressField = new TextField();
        controller.numberField = new TextField();
        controller.choiceBox = new ChoiceBox<>();
        controller.passwordField.setText(p);
        controller.usernameField.setText(u);
        controller.addressField.setText(a);
        controller.numberField.setText(n);
        controller.lastNameField.setText(ln);
        controller.firstNameField.setText(fn);
        controller.choiceBox.setValue(r);

    }

    @Test
    public void testHandleRegister() {
        controller.handleRegistrationAction();

    }
}
