import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
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
    private Label sum_field;

    public void initialize() {
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.setItems(ViewProductsController.list);
        sum_field.setText(sum());
    }

    public void backM(javafx.event.ActionEvent actionEvent)throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        tablepane.getChildren().setAll(pane);
    }

    public void confirm(ActionEvent actionEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("order.fxml"));
        tablepane.getChildren().setAll(pane);
    }
    public String sum() {
        float r=0;
        float m,n;
        for(Product p: ViewProductsController.list) {
            m=Float.valueOf(p.getPrice());
            n=Float.valueOf(p.getQuantity().getText());
            r = r + m*n;
        }
        return String.valueOf(r);
    }
}

