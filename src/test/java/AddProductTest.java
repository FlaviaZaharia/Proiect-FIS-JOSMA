import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class AddProductTest extends ApplicationTest {
    private static final String file = "src/main/resources/add_products_test.json";
    private AddProductController controller=new AddProductController();
    @Override
    public void start(Stage stage) throws Exception {

    }
    @Before
    public void setup() throws Exception {


        controller.nameField = new TextField();
        controller.priceField = new TextField();
        controller.materialField = new TextField();
        controller.quantityField= new TextField();
        controller.IDField= new TextField();
        controller.pictureField= new TextField();
        controller.filename = file;
        controller.nameField.setText("product");
        controller.priceField.setText("200");
        controller.materialField.setText("gold");
        controller.quantityField.setText("40");
        controller.IDField.setText("123");
        controller.pictureField.setText("img.jpg");

    }
    @Test
    public void testHandleRegister() {
        controller.handle_add_product();
        assertEquals(true,!file.isEmpty());

    }
}
