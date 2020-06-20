import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmpOrder implements Initializable {

        @FXML
        private AnchorPane mainPane;
        @FXML
        private TableView<Order> table;

        @FXML
        private TableColumn<Order,String> id_col;

        @FXML
        private TableColumn<Order,String> obs_col;

        @FXML
        private TableColumn<Order,String> stat_col;

    private ObservableList<Order> ord= FXCollections.observableArrayList();
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
                    String code = (String) y.get("Order code");
                    TextField observ= new TextField();
                    String obs=observ.getText();
                    ChoiceBox<String> c=new ChoiceBox<String>();
                    //loadData(c);
                    c.getItems().addAll("Pending","Accepted","Rejected","Delivered");
                    c.setValue("Pending");
                    ord.add(new Order(code,obs,c));

                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        id_col.setCellValueFactory(new PropertyValueFactory<>("code"));
        obs_col.setCellValueFactory(new PropertyValueFactory<>("obs"));
        stat_col.setCellValueFactory(new PropertyValueFactory<>("ch"));
        table.setItems(ord);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app2.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    public void apply(ActionEvent actionEvent) {

    }

    private void loadData(ChoiceBox<String> a) { //choiceBox
        ObservableList<String> list=FXCollections.observableArrayList();
        list.addAll("Pending","Accepted","Rejected","Delivered");
        a.getItems().addAll(list);
    }
    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }
}
