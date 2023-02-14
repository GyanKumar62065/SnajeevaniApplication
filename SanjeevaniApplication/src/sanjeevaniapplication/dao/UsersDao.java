
package sanjeevaniapplication.dao;

import java.sql.SQLException;
import sanjeevaniapplication.dbutils.DBConnection;
import sanjeevaniapplication.pojo.UsersPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import sanjeevaniapplication.pojo.UsersPojo2;

public class UsersDao {
    
    public static String isValidateUser(UsersPojo user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT USER_NAME FROM USERS WHERE LOGIN_ID=? AND USER_TYPE=? AND USER_PASSWORD=?");
        ps.setString(1, user.getLoginId());
        ps.setString(2, user.getUserType().toLowerCase());
        ps.setString(3, user.getUserPassword());
        ResultSet rs = ps.executeQuery();
        String userName = null;
        if(rs.next()){
            userName = rs.getString("USER_NAME");
        }
        return userName;
    }
    
    public static void updateName(String currName , String userName) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE USERS SET USER_NAME = ? WHERE USER_NAME = ?");
        ps.setString(1, userName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }
    
    public static void deleteUser(String name)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Delete From USERS where user_name =?");
        ps.setString(1, name);
        ps.executeUpdate();
    }
    
    public static boolean addUser(UsersPojo2 user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into users values (?, ? , ? ,?)");
        ps.setString(1, user.getLoginId());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getUserType().toLowerCase());
        ps.setString(4, user.getUserPassword());
       return ps.executeUpdate() == 1;
    }
    
    
}
