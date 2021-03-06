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
        AnchorPane pane = FXMLLoader.load(getClass().getResource("show-orders.fxml"));
        anchor.getChildren().setAll(pane);
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        anchor.getChildren().setAll(pane);
    }

    public void pastReturn(ActionEvent actionEvent)throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("returnp.fxml"));
        anchor.getChildren().setAll(pane);
    }
}