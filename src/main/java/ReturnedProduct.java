import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Date;

public class ReturnedProduct {
    private String uname;
    private String name;
    private String pid;
    private String oid;
    private String info;
    private TextField obs;
    private String request;
    private String date;
    private String reason;

    public ReturnedProduct(String request,String oid,String pid,String date,String obs) {
        this.pid = pid;
        this.oid = oid;
        this.request = request;
        this.date = date;
        this.info=obs;
    }

    public ReturnedProduct(String pid, String oid, String obs, String request, String reason,String date,String name, String infovechi) {
        this.pid = pid;
        this.oid = oid;
        this.obs = new TextField(obs);
        this.request = request;
        this.reason = reason;
        this.date=date;
        this.name=name;
        this.info=infovechi;
    }

    public TextField getObs() {
        return obs;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequest() {
        return request;
    }

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public void setObs(TextField obs) {
        this.obs = obs;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getName() {
        return name;
    }



    public String getOid() {
        return oid;
    }

    public String getPid() {
        return pid;
    }

    public String getUname() {
        return uname;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setOid(String oid) {
        this.oid = oid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
