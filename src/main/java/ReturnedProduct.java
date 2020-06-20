import javafx.scene.control.Label;

import java.util.Date;

public class ReturnedProduct {
    private String uname;
    private String name;
    private String pid;
    private String oid;
    private String obs;
    private String request;
    private String date;

    public ReturnedProduct(String request,String oid,String pid,String date) {
        this.pid = pid;
        this.oid = oid;
        this.request = request;
        this.date = date;
        this.obs="";
    }

    public void setObs(String obs) {
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
}
