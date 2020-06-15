import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AppController {
    @FXML
    private AnchorPane anchor;

    public void products(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("view-products.fxml"));
        anchor.getChildren().setAll(pane);
    }

    public void cart(ActionEvent actionEvent)throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("cart.fxml"));
        anchor.getChildren().setAll(pane);
    }

    public void porder(ActionEvent actionEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("porder.fxml"));
        anchor.getChildren().setAll(pane);
    }
}