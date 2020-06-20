import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;


public class AddProductController {
    private static FileWriter file;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField materialField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField IDField;
    @FXML
    private TextField pictureField;
    @FXML
    private AnchorPane pane_add;
    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    @FXML
    void addproduct(ActionEvent event) throws IOException {
        if (nameField.getText() == null || nameField.getText().isEmpty()) {
            msgbox("Please type in a name!");
            return;
        }
        if (priceField.getText() == null || priceField.getText().isEmpty()) {
            msgbox("Please type in a price!");
            return;
        }
        if (materialField.getText() == null || materialField.getText().isEmpty()) {
            msgbox("Please type in a material!");
            return;
        }
        if (quantityField.getText() == null || quantityField.getText().isEmpty()) {
            msgbox("Please type in a qantity!");
            return;
        }
        if (IDField.getText() == null || IDField.getText().isEmpty()) {
            msgbox("Please type in an ID!");
            return;
        }
        if (pictureField.getText() == null || pictureField.getText().isEmpty()) {
            msgbox("Please type in an image source!");
            return;
        }
        handle_add_product();
        AnchorPane panel= FXMLLoader.load(getClass().getResource("app2.fxml"));
        pane_add.getChildren().setAll(panel);
    }
    public void readProducts(JSONArray x ){ //read from file
        File file=new File("D:\\JOSMA\\src\\main\\resources\\productslist.json");
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("D:\\JOSMA\\src\\main\\resources\\productslist.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Product");

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
        public  void handle_add_product(){
//scriere in user.json
            JSONObject obj = new JSONObject();
            JSONArray use=new JSONArray();
            JSONObject list=new JSONObject();
            readProducts(use);
            obj.put("Name",nameField.getText());
            obj.put("Price",priceField.getText());
            obj.put("Material",materialField.getText());
            obj.put("Quantity",quantityField.getText());
            obj.put("ID",IDField.getText());
            obj.put("Picture",pictureField.getText());
            use.add(obj);
            list.put("Product",use);

            try {
                // Constructs a FileWriter given a file name, using the platform's default charset
                file = new FileWriter("D:\\JOSMA\\src\\main\\resources\\productslist.json");
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


    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app2.fxml"));
        pane_add.getChildren().setAll(pane);
    }
}
