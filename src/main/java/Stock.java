import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

public class Stock implements Initializable {
    @FXML
    private AnchorPane ancor;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product,String> prod_col;

    @FXML
    private TableColumn<Product,String> quantity_col;

    @FXML
    private TableColumn<Product,String> name_col;

    @FXML
    private TableColumn<Product,String> material_col;
    ObservableList<Product> product= FXCollections.observableArrayList();
    @FXML
    void back(ActionEvent event) throws IOException {
        AnchorPane panel = FXMLLoader.load(getClass().getResource("app2.fxml"));
        ancor.getChildren().setAll(panel);
    }

    @FXML
    void refill(ActionEvent event) {
       for(Product p:product)
       Management.update(p.getId());
    }
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
                    String material_field=(String) y.get("Material");
                    String quantity=(String) y.get("Quantity");
                    if(Integer.valueOf(quantity)<15)
                    product.add(new Product(name_field,material_field, quantity,code));

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        prod_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        quantity_col.setCellValueFactory(new PropertyValueFactory<>("q"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        material_col.setCellValueFactory(new PropertyValueFactory<>("material"));
        table.setItems(product);
    }
}
