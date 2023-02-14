package sanjeevaniapplication.pojo;


public class UsersPojo {
    
    private String loginId , userPassword , userType;

    public UsersPojo(String loginId, String userPassword, String userType) {
        this.loginId = loginId;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public UsersPojo() {
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
