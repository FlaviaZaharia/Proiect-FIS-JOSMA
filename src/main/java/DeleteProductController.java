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

public class DeleteProductController {

    @FXML
    private TextField IDField;
    @FXML
    private AnchorPane delete_prod;
    @FXML
    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    @FXML
    void delete_product(ActionEvent event) throws IOException {
        if (IDField.getText() == null || IDField.getText().isEmpty()) {
            msgbox("Please type in an ID!");
            return;
        }
        write_to_json();
        AnchorPane panel= FXMLLoader.load(getClass().getResource("app2.fxml"));
        delete_prod.getChildren().setAll(panel);
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        AnchorPane panel= FXMLLoader.load(getClass().getResource("app2.fxml"));
        delete_prod.getChildren().setAll(panel);
    }

    public void findProduct(JSONArray x ,String prod_id){ //read from file
        File file=new File(file1);
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file1));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Product");

                for (int i = 0; i < jsonArray.size(); i++) {
                   JSONObject y= (JSONObject) jsonArray.get(i);
                   String code=(String) y.get("ID");
                   if(!code.equals(prod_id))
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
    private static String  file1="src/main/resources/productslist.json";
    private static FileWriter file;
    public void write_to_json(){
        JSONObject obj = new JSONObject();
        JSONArray use=new JSONArray();
        JSONObject list=new JSONObject();
        findProduct(use,IDField.getText());
        list.put("Product",use);

        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter(file1);
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
