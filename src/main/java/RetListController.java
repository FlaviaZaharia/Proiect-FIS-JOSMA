import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class RetListController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableView<ReturnedProduct> table;



    @FXML
    private TableColumn<ReturnedProduct,String> col_pid;

    @FXML
    private TableColumn<ReturnedProduct,String> col_oid;

    @FXML
    private TableColumn<ReturnedProduct,String> col_rdate;

    @FXML
    private TableColumn<ReturnedProduct,String> col_obs;

    private ObservableList<ReturnedProduct> list= FXCollections.observableArrayList();
    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        mainPane.getChildren().setAll(pane);
    }


    public void initialize(URL location, ResourceBundle resources) {
        File file=new File("src/main/resources/returns.json");
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/returns.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Return requests");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject y = (JSONObject) jsonArray.get(i);
                    String nume=(String) y.get("Name");
                    String result=readjson(nume);

                    if("yes".equals(result)){
                        String pid_field=(String) y.get("Product ID");
                        String oid_field=(String) y.get("Order code");
                        String date_field=(String) y.get("Date");
                        Label obs_field=new Label();
                        list.add(new ReturnedProduct(pid_field,oid_field,obs_field, date_field));}

                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_pid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        col_oid.setCellValueFactory(new PropertyValueFactory<>("oid"));
        col_rdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_obs.setCellValueFactory(new PropertyValueFactory<>("obs"));
        table.setItems(list);
    }

    /*public String findName(String x) throws org.json.simple.parser.ParseException{
        File file=new File("src\\main\\resources\\productslist.json");
        String flag="";
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src\\main\\resources\\productslist.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Product");
                Iterator i=jsonArray.iterator();
                while(i.hasNext()){
                    JSONObject innerObj=(JSONObject) i.next();
                    if (innerObj.get("Product ID").equals(x))
                        flag+=innerObj.get("Name");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return flag;
    }*/

    public String readjson (String s) throws org.json.simple.parser.ParseException { //read from file
        File file=new File("src\\main\\resources\\user.json");
        String flag="";
        if(file.length()!=0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src\\main\\resources\\user.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("user");
                Iterator i=jsonArray.iterator();
                while(i.hasNext()){
                    JSONObject innerObj=(JSONObject) i.next();
                    if (innerObj.get("First Name:").equals(s))
                        flag="yes";
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return flag;
    }
}
