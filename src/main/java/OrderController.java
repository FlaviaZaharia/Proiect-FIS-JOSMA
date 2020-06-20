import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.text.View;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.UUID;

public class OrderController implements Initializable {

    @FXML
    private TextField name_field;
    @FXML
    private AnchorPane order;
    @FXML
    private TextField address_field;

    @FXML
    private ChoiceBox<String> choicebox=new ChoiceBox<>();
    private static String order_code;
    LocalDate date = LocalDate.now();
    private ObservableList list= FXCollections.observableArrayList();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public void initialize(URL location, ResourceBundle resources) {
        loadData(); //choiceBox
    }
    private void loadData() { //choiceBox
        list.addAll("Courier","In store");
        choicebox.getItems().addAll(list);
    }
    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    @FXML
    void finish_order(ActionEvent event) throws IOException {
        if (name_field.getText() == null || name_field.getText().isEmpty()) {
            msgbox("Name cannot be empty!");
            return;
        }

        if (address_field.getText() == null || address_field.getText().isEmpty()) {
            msgbox("Address cannot be empty");
            return;
        }
        if (choicebox.getValue() == null || choicebox.getValue().isEmpty()) {
            msgbox("Shipping method cannot be empty");
            return;
        }
      handle_write_toJSON();
        for(Product p:ViewProductsController.list)
            StockController.changestock(p.getQuantity().getText(),p.getId());

        AnchorPane pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        order.getChildren().setAll(pane);
        ViewProductsController.list.clear();
    }

    public static final String generate(String... args){
            //generate random UUIDs
            UUID idOne = UUID.randomUUID();
            UUID idTwo = UUID.randomUUID();
            return idOne.toString();
        }



    public void readFromFile(JSONArray x ){ //read from file
        File file=new File("src/main/resources/orders.json");
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/orders.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Orders");

                for (int i = 0; i < jsonArray.size(); i++) {
                    x.add(jsonArray.get(i));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
  static  FileWriter file;
    private void handle_write_toJSON() {
        JSONObject obj = new JSONObject();
        JSONArray use=new JSONArray();
        JSONObject list=new JSONObject();
        JSONArray prod_list=new JSONArray();
        readFromFile(use);
        obj.put("Name",name_field.getText());
        obj.put("Address",address_field.getText());
        obj.put("Shipping",(String)choicebox.getValue());
        obj.put("Total sum",CartController.sum());
        obj.put("Order code",OrderController.generate());
        obj.put("Date",date.format((formatter)));
        obj.put("Status","Pending");
        obj.put("Observations","");
        for(Product p: ViewProductsController.list)
        {
            JSONObject prod_obj=new JSONObject();
            prod_obj.put("Product Name",p.getName());
            prod_obj.put("Quantity",p.getQuantity().getText());
            prod_obj.put("Price",p.getPrice());
            prod_list.add(prod_obj);
        }
        obj.put("Products",prod_list);
        use.add(obj);
        list.put("Orders",use);

        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("src/main/resources/orders.json");
            file.write(list.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
