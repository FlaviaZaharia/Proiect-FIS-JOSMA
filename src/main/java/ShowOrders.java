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
import java.util.Iterator;
import java.util.ResourceBundle;

public class ShowOrders implements Initializable {

    @FXML
    private AnchorPane ancor;

    @FXML
    private TableView<Order> table;

    @FXML
    private TableColumn<Order,String> code_field;

    @FXML
    private TableColumn<Order,String> data_field;

    @FXML
    private TableColumn<Order,String> total_field;

    @FXML
    private TableColumn<Order,String> status_field;

    @FXML
    private TableColumn<Order,String> obs_field;
    private ObservableList<Order> obs= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("src/main/resources/orders.json");
        if (file.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/orders.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Orders");

                for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject y = (JSONObject) jsonArray.get(i);
                String num=(String) y.get("Name");
                //System.out.println(num);
                String result=readjson(num);
                //System.out.println(result);
                if("yes".equals(result)) {
                    String status = (String) y.get("Status");
                    String code = (String) y.get("Order code");
                    String data = (String) y.get("Date");
                    String total = (String) y.get("Total sum");
                    //String observ = (String) y.get("Observations");
                    obs.add(new Order(code, data, total, status));
                }

            } }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        code_field.setCellValueFactory(new PropertyValueFactory<>("code"));
        data_field.setCellValueFactory(new PropertyValueFactory<>("data"));
        total_field.setCellValueFactory(new PropertyValueFactory<>("total"));
        status_field.setCellValueFactory(new PropertyValueFactory<>("status"));
        obs_field.setCellValueFactory(new PropertyValueFactory<>("observation"));
        table.setItems(obs);
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        ancor.getChildren().setAll(pane);
    }
    public static String readjson (String s) throws org.json.simple.parser.ParseException { //read from file
        File file=new File("src\\main\\resources\\user.json");
        String flag="";
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src\\main\\resources\\user.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("user");
                Iterator i=jsonArray.iterator();
                while(i.hasNext()){
                    JSONObject innerObj=(JSONObject) i.next();
                    if (innerObj.get("First Name:").equals(s))
                        flag="yes";
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return flag;
    }
}
