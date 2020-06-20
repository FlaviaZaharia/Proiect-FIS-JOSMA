import javafx.scene.control.Label;

import java.util.Date;

public class ReturnedProduct {
    private String uname;
    private String name;
    private String pid;
    private String oid;
    private Label obs;
    private String date;

    public ReturnedProduct(String pid, String oid, Label obs, String date) {
        //this.uname=uname;
       // this.name=name;
        this.pid=pid;
        this.oid=oid;
        this.obs=obs;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public Label getObs() {
        return obs;
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

    public void setObs(Label obs) {
        this.obs = obs;
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
