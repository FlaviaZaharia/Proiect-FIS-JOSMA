import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class StockController {
    public static void readstocks(JSONArray x,String b, String id) { //read from file
        File file = new File("src/main/resources/productslist.json");
        if (file.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/productslist.json"));
                JSONArray jsonArray = (JSONArray) jsonObject.get("Product");

                for (int i = 0; i < jsonArray.size(); i++) {
                     JSONObject y = (JSONObject) jsonArray.get(i);
                    String code = (String) y.get("ID");
                    if (code.equals(id)) {
                        String q = (String) y.get("Quantity");
                        int aux = Integer.valueOf(q);
                        int aux2 = Integer.valueOf((b));
                        aux = aux - aux2;
                        y.put("Quantity", String.valueOf(aux));
                    }
                    x.add(y);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    static FileWriter file;

    public static  void changestock(String x,String y) {
        JSONObject obj = new JSONObject();
       JSONArray use = new JSONArray();
        JSONObject list1 = new JSONObject();
        readstocks(use,x,y);
        list1.put("Product", use);

        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("src/main/resources/productslist.json");
            file.write(list1.toJSONString());
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
