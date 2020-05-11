import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane rootPane ;


    @FXML
    void click(ActionEvent event) {

    }
    @FXML
    void register(ActionEvent event) throws IOException
    {
       AnchorPane pane = FXMLLoader.load(getClass().getResource("register.fxml"));
       rootPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private AnchorPane mainPane;

    @FXML
    void method(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        mainPane.getChildren().setAll(pane);
    }
}