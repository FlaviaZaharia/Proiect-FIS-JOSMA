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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginController {
    @FXML
    private AnchorPane rootPane ;
    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox choiceBox;



    @FXML
    public void click(ActionEvent event) throws IOException, ParseException {       //login
        if (usernameField.getText() == null || usernameField.getText().isEmpty()) {
            showMessageDialog(null, "Please type in the username!");
            return;
        }

        if (passwordField.getText() == null || passwordField.getText().isEmpty()) {
            showMessageDialog(null, "Please type in the password!");
            return;
        }
        //if (readUsers(usernameField.getText(),passwordField.getText())) {
             if (getRole(usernameField.getText(),passwordField.getText()).equals("Customer")) {
                AnchorPane pane1 = FXMLLoader.load(getClass().getResource("app.fxml"));
                rootPane.getChildren().setAll(pane1); }
             else if (getRole(usernameField.getText(),passwordField.getText()).equals("Employee")) {
                 AnchorPane pane2= FXMLLoader.load(getClass().getResource("app2.fxml"));
                 rootPane.getChildren().setAll(pane2);
             }
        else showMessageDialog(null,"Incorrect username or password");
    }
    @FXML
    public void register(ActionEvent event) throws IOException      //register
    {
       AnchorPane pane = FXMLLoader.load(getClass().getResource("register.fxml"));
       rootPane.getChildren().setAll(pane);
    }
   
    public String getRole (String user, String parola) throws org.json.simple.parser.ParseException { //read from file
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
                    if (innerObj.get("User:").equals(user)&&innerObj.get("Role:").equals("Customer")
                            &&innerObj.get("Password:").equals(UserService.cryptPassword(parola)))
                        flag="Customer";
                    if (innerObj.get("User:").equals(user)&&innerObj.get("Role:").equals("Employee")
                            &&innerObj.get("Password:").equals(UserService.cryptPassword(parola)))
                        flag="Employee";
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



