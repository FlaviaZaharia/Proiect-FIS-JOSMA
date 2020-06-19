public class Order {

    private String code;
    private String data;
    private String total;
    private String status;
    private String observation;
    public Order(String code, String data, String total, String status) {
        this.code = code;
        this.data = data;
        this.total = total;
        this.status = status;
        this.observation ="";
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
}
