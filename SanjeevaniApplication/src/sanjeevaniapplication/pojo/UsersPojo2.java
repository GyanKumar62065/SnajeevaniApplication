/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapplication.pojo;

/**
 *
 * @author gk620
 */
public class UsersPojo2 {
    private String loginId , userName , userPassword , userType;

    public UsersPojo2(String loginId, String userName, String userPassword, String userType) {
        this.loginId = loginId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public UsersPojo2() {
    }
    
    

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
}
