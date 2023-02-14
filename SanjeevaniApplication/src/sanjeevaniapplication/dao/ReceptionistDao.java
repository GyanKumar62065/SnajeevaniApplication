/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapplication.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapplication.dbutils.DBConnection;
import sanjeevaniapplication.pojo.DoctorPojo;
import sanjeevaniapplication.pojo.ReceptionistPojo;

/**
 *
 * @author gk620
 */
public class ReceptionistDao {
    public static void updateName(String currName,String newName)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update receptionists set receptionist_name=? where receptionist_name=?");
        ps.setString(1, newName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }
    
    public static void deleteReceptionist(String name)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Delete From RECEPTIONISTS where RECEPTIONISTS_NAME =?");
        ps.setString(1, name);
        ps.executeUpdate();
    }
    
    public static String getNewReceptionistId()throws  SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select max(RECEPTIONISTS_ID) from RECEPTIONISTS");
        rs.next();
        int recId=101;
        String id=rs.getString(1);
        if(id!=null){
            String num=id.substring(3);
            recId=Integer.parseInt(num)+1;
         }
        return "REC"+recId;
    }  
    
    public static boolean addReceptionist(ReceptionistPojo rec)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into RECEPTIONISTS values(?,?,?)");
        ps.setString(1,rec.getReceptionistId());
        ps.setString(2, rec.getReceptionistName());
        ps.setString(3,rec.getGender());
        return ps.executeUpdate()==1;
   }
    
        public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("Select * from RECEPTIONISTS");
        List<ReceptionistPojo>ls = new ArrayList<>();
        while(rs.next()){
//            ls.add(new ReceptionistPojo(rs.getString(1), rs.getString(2);, rs.getString(3)));
        }
        return ls;
    }
}
