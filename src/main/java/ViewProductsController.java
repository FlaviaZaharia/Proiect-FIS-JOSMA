import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ViewProductsController implements Initializable {

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product,String> col_image;

    @FXML
    private TableColumn<Product,String> col_name;

    @FXML
    private TableColumn<Product,String> col_price;

    @FXML
    private TableColumn<Product,String> col_material;

    @FXML
    private TableColumn<Product,String> col_quantity;

    @FXML
    private TableColumn<Product,String> col_id;
    @FXML
    private TableColumn<Product,String> col_add;
    @FXML
    private AnchorPane tablepane;
    ObservableList<Product> obs= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file=new File("src/main/resources/productslist.json");
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/productslist.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Product");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject y= (JSONObject) jsonArray.get(i);
                    String code=(String) y.get("ID");
                    String name_field=(String) y.get("Name");
                    String price_field=(String) y.get("Price");
                    String material_field=(String) y.get("Material");
                    String quantity_field=(String) y.get("Quantity");
                    String image_field =(String) y.get("Picture");
                    ImageView img=new ImageView(new Image(this.getClass().getResourceAsStream(image_field)));
                    Button b=new Button("add");
                    b.setOnAction(event->{
                        AnchorPane pane = null;
                        try {
                            pane = FXMLLoader.load(getClass().getResource("login.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        tablepane.getChildren().setAll(pane);});
                    obs.add(new Product(name_field,price_field,material_field,quantity_field,code,img,b));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
       col_image.setCellValueFactory(new PropertyValueFactory<>("picture"));
       col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_material.setCellValueFactory(new PropertyValueFactory<>("material"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_add.setCellValueFactory((new PropertyValueFactory<>("button")));
        table.setItems(obs);

    }
}




