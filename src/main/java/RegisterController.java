import com.fasterxml.jackson.annotation.JsonValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.String;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.swing.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;


public class RegisterController implements Initializable{
    private ObservableList list=FXCollections.observableArrayList();
    private static FileWriter file;
    @FXML
    private AnchorPane mainPane;

     @FXML
     void cancel(ActionEvent event) throws IOException {     //cancel
         AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
         mainPane.getChildren().setAll(pane);
     }
    @FXML
    private ChoiceBox<String> choiceBox=new ChoiceBox<>();
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private Text registerMessage;
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData(); //choiceBox
    }
    private void loadData() { //choiceBox
        list.addAll("Customer","Employee");
        choiceBox.getItems().addAll(list);
    }
    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    @FXML
    public void afterRegister(ActionEvent event) throws IOException { //signup to login
        if (usernameField.getText() == null || usernameField.getText().isEmpty()) {
            msgbox("Please type in a username!");
            return;
        }

        if (passwordField.getText() == null || passwordField.getText().isEmpty()) {
            msgbox("Password cannot be empty");
            return;
        }
        if (firstNameField.getText() == null || firstNameField.getText().isEmpty()) {
            msgbox("First name cannot be empty");
            return;
        }

        if (lastNameField.getText() == null || lastNameField.getText().isEmpty()) {
            msgbox("Last name cannot be empty");
            return;
        }
        if (emailField.getText() == null || emailField.getText().isEmpty()) {
            msgbox("Email cannot be empty");
            return;
        }

        if (addressField.getText() == null || addressField.getText().isEmpty()) {
            msgbox("Address cannot be empty");
            return;
        }
        if (numberField.getText() == null || numberField.getText().isEmpty()) {
            msgbox("Number cannot be");
            return;
        }

        if (choiceBox.getValue() == null || choiceBox.getValue().isEmpty()) {
            msgbox("Role cannot be empty");
            return;
        }
      handleRegistrationAction();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        mainPane.getChildren().setAll(pane);

        //if (username==null ||)
    }


  public void readFromFile(JSONArray x ){ //read from file
        File file=new File("src\\main\\resources\\user.json");
      if(file.length()!=0) {
          JSONParser jsonParser = new JSONParser();
          try {
              JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src\\main\\resources\\user.json"));
              JSONArray jsonArray = (JSONArray) jsonObject.get("user");

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


    public void handleRegistrationAction() {

        //scriere in user.json
        JSONObject obj = new JSONObject();
        JSONArray use=new JSONArray();
        JSONObject list=new JSONObject();
        readFromFile(use);
        obj.put("User:",usernameField.getText());
        //obj.put("Password:",passwordField.getText());
        obj.put("Password:",UserService.cryptPassword(passwordField.getText()));
        obj.put("First Name:",firstNameField.getText());
        obj.put("Last Name:",lastNameField.getText());
        obj.put("Email:",emailField.getText());
        obj.put("Address:",addressField.getText());
        obj.put("Number:",numberField.getText());
        obj.put("Role:",(String)choiceBox.getValue());
        use.add(obj);
        list.put("user",use);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("src\\main\\resources\\user.json");
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


