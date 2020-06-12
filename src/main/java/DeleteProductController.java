import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;

public class DeleteProductController {

    @FXML
    private TextField IDField;
    @FXML
    private AnchorPane delete_prod;
    @FXML
    private void msgbox(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    @FXML
    void delete_product(ActionEvent event) throws IOException {
        if (IDField.getText() == null || IDField.getText().isEmpty()) {
            msgbox("Please type in an ID!");
            return;
        }
        AnchorPane panel= FXMLLoader.load(getClass().getResource("app2.fxml"));
        delete_prod.getChildren().setAll(panel);
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        AnchorPane panel= FXMLLoader.load(getClass().getResource("app2.fxml"));
        delete_prod.getChildren().setAll(panel);
    }

}
