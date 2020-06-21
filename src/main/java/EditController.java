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
import java.util.Iterator;

public class EditController {

    @FXML
    private AnchorPane pane_add;

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


    public void modify(javafx.event.ActionEvent actionEvent) throws IOException {
        if (IDField.getText() == null || IDField.getText().isEmpty()) {
            msgbox("Please type in the ID!");
            return;
        }
        if ((nameField.getText()==null || nameField.getText().isEmpty()) &&
            (priceField.getText()==null || priceField.getText().isEmpty()) &&
                (materialField.getText()==null || materialField.getText().isEmpty()) &&
                (quantityField.getText()==null || quantityField.getText().isEmpty()) &&
                (pictureField.getText()==null || pictureField.getText().isEmpty()) ) {
            msgbox("Please fill in at least one field in order to modify details");
            return;
        }
        if ((nameField.getText() != null) && (!nameField.getText().isEmpty()))
            write_to_json("Name", nameField.getText());
        if ((priceField.getText() != null) && (!priceField.getText().isEmpty()))
            write_to_json("Price", priceField.getText());
        if ((materialField.getText() != null) && (!materialField.getText().isEmpty()))
            write_to_json("Material", materialField.getText());
        if ((quantityField.getText() != null) && (!quantityField.getText().isEmpty()))
            write_to_json("Quantity", quantityField.getText());
        if ((pictureField.getText() != null) && (!pictureField.getText().isEmpty()))
            write_to_json("Picture", pictureField.getText());


        AnchorPane panel= FXMLLoader.load(getClass().getResource("app2.fxml"));
        pane_add.getChildren().setAll(panel);
    }

    private void findProduct(JSONArray x, String a, String b, String id) {
        File file=new File("src/main/resources/productslist.json");
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/productslist.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Product");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject y= (JSONObject) jsonArray.get(i);
                    String code=(String) y.get("ID");
                    if(code.equals(id)) y.put(a,b);
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
    private static FileWriter file;
    public  void write_to_json(String x, String y) {
        JSONObject obj = new JSONObject();
        JSONArray use = new JSONArray();
        JSONObject list = new JSONObject();
        String id = IDField.getText();
        findProduct(use,x,y,id);
        list.put("Product", use);

        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("src/main/resources/productslist.json");
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

    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app2.fxml"));
        pane_add.getChildren().setAll(pane);
    }
}

