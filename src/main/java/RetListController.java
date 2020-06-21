import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class RetListController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private TableView<ReturnedProduct> table;
    @FXML
    private TableColumn<ReturnedProduct, String> req_col;

    @FXML
    private TableColumn<ReturnedProduct, String> order_col;

    @FXML
    private TableColumn<ReturnedProduct, String> prod_col;

    @FXML
    private TableColumn<ReturnedProduct, String> date_col;

    @FXML
    private TableColumn<ReturnedProduct, String> obs_col;
    private ObservableList<ReturnedProduct> obs = FXCollections.observableArrayList();

    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        mainPane.getChildren().setAll(pane);
    }


    //@Override
   public void initialize(URL location, ResourceBundle resources) {

       File file = new File("src/main/resources/returns.json");
        if (file.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/returns.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Return requests");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject y = (JSONObject) jsonArray.get(i);
                    String num = (String) y.get("User");

                    if (LoginController.user.getUsername().equals(num)) {
                        String id_r = (String) y.get("Request ID");
                        String id_o = (String) y.get("Order code");
                        String id_p = (String) y.get("Product ID");
                        String d = (String) y.get("Date");
                        String observ = (String) y.get("Observations");
                        obs.add(new ReturnedProduct(id_r, id_o, id_p, d,observ));
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            req_col.setCellValueFactory(new PropertyValueFactory<>("request"));
            order_col.setCellValueFactory(new PropertyValueFactory<>("oid"));
            prod_col.setCellValueFactory(new PropertyValueFactory<>("pid"));
            date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
            obs_col.setCellValueFactory(new PropertyValueFactory<>("info"));
            table.setItems(obs);
        }
    }
}
