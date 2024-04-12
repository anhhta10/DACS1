
package model;

/**
 *
 * @author anhth
 */
public class ModelCustomer {
    private int id;
    private String name;
    private boolean isprefessed;
    private String emailString;
    private int phone;
    private String address;

    public ModelCustomer() {
    }

    public ModelCustomer(int id, String name, boolean isprefessed, String emailString, int phone, String address) {
        this.id = id;
        this.name = name;
        this.isprefessed = isprefessed;
        this.emailString = emailString;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsprefessed() {
        return isprefessed;
    }

    public void setIsprefessed(boolean isprefessed) {
        this.isprefessed = isprefessed;
    }

    public String getEmailString() {
        return emailString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
