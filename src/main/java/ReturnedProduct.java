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

    public ReturnedProduct(String request,String oid,String pid,String date, String obs) {
        this.pid = pid;
        this.oid = oid;
        this.request = request;
        this.date = date;
        this.obs=obs;
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

    public String getObs() {
        return obs;
    }

    public String getDate() {
        return date;
    }
    public String getRequest() {
        return request;
    }


    public void setName(String name) {
        this.name = name;
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
