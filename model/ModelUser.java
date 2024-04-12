
package model;

public class ModelUser {
    private int userID;
    private int businessID;
    private String userName;
    private String email;
    private String password;
    private String repassword;
    private String veridyCode;

    public ModelUser(int userID, int businessID, String userName, String email, String password, String repassword, String veridyCode) {
        this.userID = userID;
        this.businessID = businessID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.repassword = repassword;
        this.veridyCode = veridyCode;
    }
    
    public ModelUser(int userID, String userName, String email, String password, String repassword) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.repassword = repassword;
    }


    public ModelUser(int userID, String userName, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    
    public ModelUser(int userID, String userName, String email, int businessID) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.businessID = businessID;
    }
    
    public ModelUser(String email, String password, String repassword) {
        this.email = email;
        this.password = password;
        this.repassword = repassword;
    }

    public ModelUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public ModelUser() {
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVeridyCode() {
        return veridyCode;
    }

    public void setVeridyCode(String veridyCode) {
        this.veridyCode = veridyCode;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    
    public boolean comparePass() {
        return this.password.equals(this.repassword);
    }

    public int getBusinessID() {
        return businessID;
    }

    public void setBusinessID(int businessID) {
        this.businessID = businessID;
    }
}
