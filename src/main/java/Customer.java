public class Customer {
    private int ID;
    private String username;
    private String last_name;
    private String first_name;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    public Customer(String username, String last_name, String first_name, String phone, String address, String city, String postalCode, String country) {
//        this.ID = ID;
        this.username = username;
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

/*
    `id` int(11) NOT NULL AUTO_INCREMENT,
      `username` varchar(50) DEFAULT NULL,
      `last_name` varchar(50) DEFAULT NULL,
      `first_name` varchar(50) DEFAULT NULL,
      `phone` varchar(50) DEFAULT NULL,
      `address` varchar(50) DEFAULT NULL,
      `city` varchar(50) DEFAULT NULL,
      `postalCode` varchar(15) DEFAULT NULL,
      `country` varchar(50) DEFAULT NULL,
     */
}
