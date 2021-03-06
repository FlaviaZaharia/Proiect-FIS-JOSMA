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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static javax.swing.JOptionPane.showMessageDialog;

public class ReturnProductController {
    @FXML
    AnchorPane returnanchor;
    @FXML
    TextField id_field;
    @FXML
    TextField code_field;
    @FXML
    TextField reason_field;
    private static FileWriter file;
    public static String name;
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @FXML
    void cancel(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        returnanchor.getChildren().setAll(pane);
    }
    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    @FXML
    void send(ActionEvent event) {

        if (id_field.getText() == null || id_field.getText().isEmpty()) {
            showMessageDialog(null, "Please type in the ID of the product!");
            return;
        }
        if (code_field.getText() == null || code_field.getText().isEmpty()) {
            showMessageDialog(null, "Please type in the code of the order!");
            return;
        }
        if (reason_field.getText() == null || reason_field.getText().isEmpty()) {
            showMessageDialog(null, "Please type in the reason of the return!");
            return;
        }

        handle_return_request();
    }


    public void readRequests(JSONArray x ){ //read from file
        File file=new File(file1);
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file1));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Return requests");

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

  String file1="src/main/resources/returns.json";
   public void handle_return_request() {
        JSONObject obj = new JSONObject();
        JSONArray use=new JSONArray();
        JSONObject list=new JSONObject();
        readRequests(use);
        obj.put("User",LoginController.user.getUsername());
        obj.put("Product ID",id_field.getText());
        obj.put("Order code",code_field.getText());
        obj.put("Reason",reason_field.getText());
        obj.put("Date",date.format(formatter));
        obj.put("Request ID",OrderController.generate());
        obj.put("Observations","");
        use.add(obj);
        list.put("Return requests",use);

        try {
            file = new FileWriter("src/main/resources/returns.json");
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
