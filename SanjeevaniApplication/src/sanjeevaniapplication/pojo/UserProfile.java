/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapplication.pojo;

/**
 *
 * @author gk620
 */
public class UserProfile {
    private static String userId , userName , userType;
    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserProfile.userId = userId;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserProfile.userName = userName;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUserType(String userType) {
        UserProfile.userType = userType;
    }

    
}
