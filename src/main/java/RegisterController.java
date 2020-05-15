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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private ObservableList list=FXCollections.observableArrayList();
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData(); //choiceBox
    }
    private void loadData() { //choiceBox
        list.addAll("Customer","Employee");
        choiceBox.getItems().addAll(list);
    }
    @FXML
    public void afterRegister(ActionEvent event) throws IOException { //signup to login
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        mainPane.getChildren().setAll(pane);

        //if (username==null ||)
    }
    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(),firstNameField.getText(),lastNameField.getText(),emailField.getText(),addressField.getText(),numberField.getText(),(String) choiceBox.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }


}
