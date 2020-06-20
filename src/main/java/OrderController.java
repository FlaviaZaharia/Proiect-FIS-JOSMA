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
        {
            System.out.println(p.getId());
            System.out.println(p.getQuantity().getText());
            StockController.changestock(p.getId(),p.getQuantity().getText());

        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        order.getChildren().setAll(pane);
        //StockController.changestock();
        ViewProductsController.list.clear();
    }

   /* public void readstocks(JSONArray x, String a, String b, String id){ //read from file
        File file=new File("src/main/resources/productslist.json");
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/productslist.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Product");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject y= (JSONObject) jsonArray.get(i);
                    String code=(String) y.get("ID");
                    if(code.equals(id)) {
                        String q=(String) y.get("Quantity");
                        int aux=Integer.valueOf(q);
                        int aux2=Integer.valueOf((b));
                        aux=aux-aux2;
                        y.put(a,String.valueOf(aux));
                    }
                    x.add(y);
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
    static FileWriter file1;
    public void changestock(){
        JSONObject obj = new JSONObject();
        JSONArray use = new JSONArray();
        JSONObject list1 = new JSONObject();
        for(Product p:ViewProductsController.list)
        {
        readstocks(use,"Quantity",p.getQuantity().getText(),p.getId());
        System.out.println(p.getQuantity().getText());
            System.out.println(p.getId());
        }

        list1.put("Product", use);

        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file1 = new FileWriter("src/main/resources/productslist.json");
            file1.write(list1.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file1.flush();
                file1.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}*/





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
