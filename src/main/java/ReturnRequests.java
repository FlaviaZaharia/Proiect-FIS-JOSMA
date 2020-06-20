import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ReturnRequests implements Initializable {

    @FXML
    private TableView<ReturnedProduct> table;
    @FXML
    private AnchorPane pane;
    @FXML
    private TableColumn<ReturnedProduct,String> order_col;

    @FXML
    private TableColumn<ReturnedProduct,String> id_col;

    @FXML
    private TableColumn<ReturnedProduct,String> reason_col;
    @FXML
    private TableColumn<ReturnedProduct,String> date_col;

    @FXML
    private TableColumn<ReturnedProduct,String> name_col;
    @FXML
    private TableColumn<ReturnedProduct,String> obs_col;
    @FXML
    private TableColumn<ReturnedProduct,String> request_col;
    @FXML
    void back(ActionEvent event) throws IOException {
        AnchorPane panel = FXMLLoader.load(getClass().getResource("app2.fxml"));
        pane.getChildren().setAll(panel);
    }

    @FXML
    void save(ActionEvent event) {
       aux.addAll(prod);
       write();

    }
    ObservableList<ReturnedProduct> aux=FXCollections.observableArrayList();
   ObservableList<ReturnedProduct> prod= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file=new File("src/main/resources/returns.json");
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/returns.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Return requests");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject y= (JSONObject) jsonArray.get(i);
                    String req_id=(String) y.get("Request ID");
                    String order_id=(String) y.get("Order code");
                    String prod_id=(String) y.get("Product ID");
                    String reason=(String) y.get("Reason");
                    String num=(String) y.get("Name");
                    String data=(String) y.get("Date");
                    String info=(String) y.get("Observations");
                    if(info.equals("")) {
                        TextField t = new TextField();
                        String obs_field = t.getText();
                        prod.add(new ReturnedProduct(prod_id, order_id, obs_field, req_id, reason, data, num));
                    }
                    else aux.add(new ReturnedProduct(prod_id, order_id, info, req_id, reason, data, num));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        order_col.setCellValueFactory(new PropertyValueFactory<>("oid"));
        id_col.setCellValueFactory(new PropertyValueFactory<>("pid"));
        reason_col.setCellValueFactory(new PropertyValueFactory<>("reason"));
        obs_col.setCellValueFactory(new PropertyValueFactory<>("obs"));
        request_col.setCellValueFactory(new PropertyValueFactory<>("request"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.setItems(prod);
    }

    static FileWriter file;
    public void write()
    {
        //JSONObject obj = new JSONObject();
        JSONArray use=new JSONArray();
        JSONObject list=new JSONObject();
        for(ReturnedProduct p:aux)
        {
            JSONObject obj = new JSONObject();
          obj.put("Name",p.getName());
          obj.put("Date",p.getDate());
          obj.put("Request ID",p.getRequest());
          obj.put("Order code",p.getOid());
          obj.put("Product ID",p.getPid());
          obj.put("Reason",p.getReason());
          //  System.out.println(p.getReason());
          obj.put("Observations",p.getObs().getText());
         // System.out.println(p.getObs().getText());
          use.add(obj);
        }

        list.put("Return requests",use);

        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("src/main/resources/returns.json");
            file.write(list.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
