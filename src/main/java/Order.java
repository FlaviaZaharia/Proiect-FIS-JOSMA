import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Order {

    private String code;
    private String data;
    private String total;
    private String status;
    private String observation;
    private TextField obs;
    private ChoiceBox<String> ch;
    private String c;
    private ObservableList<Product> pr= FXCollections.observableArrayList();

    public Order(String code, String data, String total, String status,String obs) {
        this.code = code;
        this.data = data;
        this.total = total;
        this.status = status;
        this.observation =obs;
    }
    public Order(String code, String obs, ChoiceBox<String> a){ // ObservableList<Product> p) {
        this.code = code;
        this.obs =new TextField(obs);
        this.ch = a;
        //this.pr=p;
    }

    public String getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public String getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public String getObservation() {
        return observation;
    }

    public void setObs(TextField obs) {
        this.obs = obs;
    }

    public ChoiceBox<String> getCh() {
        return ch;
    }

    public TextField getObs() {
        return obs;
    }

    public void setCh(ChoiceBox<String> ch) {
        this.ch = ch;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ObservableList<Product> getPr() {
        return pr;
    }

    public void setPr(ObservableList<Product> pr) {
        this.pr = pr;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
