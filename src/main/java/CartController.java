import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CartController {

    @FXML
    private AnchorPane tablepane;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product,String> col_name;

    @FXML
    private TableColumn<Product,String> col_price;

    @FXML
    private TableColumn<Product,String> col_quantity;

    @FXML
    private TableColumn<Product,String> col_id;

    @FXML
    private TextField sum_field;

    public void initialize() {
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.setItems(ViewProductsController.list);
    }

    public void backM(javafx.event.ActionEvent actionEvent)throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        tablepane.getChildren().setAll(pane);
    }

    public void confirm(ActionEvent actionEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("order.fxml"));
        tablepane.getChildren().setAll(pane);
    }
}

