import java.util.Date;

public class Order {
    private int ID;
    private java.sql.Date order_date;
    private java.sql.Date shipped_date;
    private String status;
    private String comments;
    private int customer_id;

    public Order(java.sql.Date order_date, java.sql.Date shipped_date, String status, String comments, int customer_id) {
        this.order_date = order_date;
        this.shipped_date = shipped_date;
        this.status = status;
        this.comments = comments;
        this.customer_id = customer_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public java.sql.Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(java.sql.Date order_date) {
        this.order_date = order_date;
    }

    public java.sql.Date getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(java.sql.Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
