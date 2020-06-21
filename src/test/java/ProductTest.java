import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ProductTest extends ApplicationTest {
    private static final String name="name";
    private static final String price="200";
    private static final String material="material";
//    private static final TextField quantity=new TextField("200");
    private static final String id="id";
   // private static final ImageView picture=new ImageView("picture.jpg");
   // private static final Button button=new Button("button");
    private static final String q="200";
    public void start(Stage stage) throws Exception {

    }
   private Product p=new Product();

    @Test
    public void testNameGetterSetter() {
        p.setName(name);
        assertEquals(name, p.getName());

    }
    @Test
    public void testPriceGetterSetter() {
        p.setPrice(price);
        assertEquals(price, p.getPrice());

    }
    @Test
    public void testMaterialGetterSetter() {
        p.setMaterial(material);
        assertEquals(material, p.getMaterial());

    }
    @Test
    public void testQGetterSetter() {
        p.setQ(q);
        assertEquals(q, p.getQ());

    }
    @Test
    public void testIDGetterSetter() {
        p.setId(id);
        assertEquals(id, p.getId());
    }

}
