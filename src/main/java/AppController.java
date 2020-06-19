import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AppController {
    @FXML
    private AnchorPane anchor;

    @FXML
    public void products(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("view-products.fxml"));
        anchor.getChildren().setAll(pane);
    }

    @FXML
    void returnp(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("make-a-return.fxml"));
        anchor.getChildren().setAll(pane);
    }

    @FXML
    public void porder(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("porder.fxml"));
        anchor.getChildren().setAll(pane);
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        anchor.getChildren().setAll(pane);
    }
}