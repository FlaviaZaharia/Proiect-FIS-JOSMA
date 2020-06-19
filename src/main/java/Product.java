import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class Product {
    private String name;
    private String price;
    private String material;
    private String quantity;
    private String id;
    private ImageView picture;
    private  Button button;

  
    public Product(String name, String price, String material, String quantity, String id, ImageView picture,Button button) {
        this.name = name;
        this.price = price;
        this.material = material;
        this.quantity = quantity;
        this.id = id;
        this.picture = picture;
        this.button=button;
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

    public String getQuantity() {
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

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPicture(ImageView picture) {
        this.picture = picture;
    }
}
