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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController {
    @FXML
    private AnchorPane rootPane ;
    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    @FXML
    void click(ActionEvent event) {       //login
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == null || username.isEmpty()) {
            loginMessage.setText("Please type in a username!");
            return;
        }

        if (password == null || password.isEmpty()) {
            loginMessage.setText("Password cannot be empty");
            return;
        }
    }
    @FXML
    void register(ActionEvent event) throws IOException      //register
    {
       AnchorPane pane = FXMLLoader.load(getClass().getResource("register.fxml"));
       rootPane.getChildren().setAll(pane);
    }


    @FXML
    private AnchorPane mainPane;

    @FXML
    void method(ActionEvent event) throws IOException {     //cancel
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        mainPane.getChildren().setAll(pane);
    }


}