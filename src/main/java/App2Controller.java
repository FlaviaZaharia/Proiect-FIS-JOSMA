import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class App2Controller {

    @FXML
    private AnchorPane anchor1;

    @FXML
    void add(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("add.fxml"));
        anchor1.getChildren().setAll(pane);
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("delete.fxml"));
        anchor1.getChildren().setAll(pane);
    }

    @FXML
    void edit(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("edit.fxml"));
        anchor1.getChildren().setAll(pane);
    }

    @FXML
    void orders(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("orders.fxml"));
        anchor1.getChildren().setAll(pane);
    }

    @FXML
    void returnp(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("return-requests.fxml"));
        anchor1.getChildren().setAll(pane);
    }

    @FXML
    void stock(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("stock.fxml"));
        anchor1.getChildren().setAll(pane);
    }
    @FXML
    void logout(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        anchor1.getChildren().setAll(pane);
    }

    public void signout(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        anchor1.getChildren().setAll(pane);
    }
}
