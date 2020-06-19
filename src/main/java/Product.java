import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class Product {
    private String name;
    private String price;
    private String material;
    private TextField quantity;
    private String id;
    private ImageView picture;
    private Button button;

    public Product() {

    }
    public Product(String name, String price, String material, String quantity, String id, ImageView picture,Button button) {
        this.name = name;
        this.price = price;
        this.material = material;
        this.quantity = new TextField(quantity);
        this.id = id;
        this.picture = picture;
        this.button=button;
    }
    public Product(String name, String price, String quant, String id) {
        this.name=name;
        this.price=price;
        this.quantity= new TextField(quant);
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getMaterial() {
        return material;
    }

    public TextField getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }

    public ImageView getPicture() {
        return picture;
    }

    public Button getButton() {
        return button;
    }


    public void setButton(Button button) {
        this.button = button;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setQuantity(TextField quantity) {
        this.quantity = quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPicture(ImageView picture) {
        this.picture = picture;
    }
}
