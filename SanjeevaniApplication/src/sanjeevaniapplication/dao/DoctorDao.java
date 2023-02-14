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

/**
 *
 * @author gk620
 */
public class DoctorDao {
    public static void updateName(String currName,String newName)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update DOCTORS set doctor_name=? where doctor_name=?");
        ps.setString(1, newName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }
    
    
    public static void deleteDoctor(String name)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Delete From DOCTORS where DOCTOR_NAME=?");
        ps.setString(1, name);
        ps.executeUpdate();
    }
    
    public static String getNewDoctorId() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(doctor_id) from doctors");
        rs.next();
        int docId = 101;
        String id = rs.getString(1);
        if(id != null){
            String num = id.substring(3);
            docId = Integer.parseInt(num)+ 1;
        }
        return "DOC" + docId;
    }
    
    public static boolean addEmp(DoctorPojo doc) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into doctors values (?, ? , ? ,? , ? , ? , ?)");
        ps.setString(1, doc.getDoctorId());
        ps.setString(2, doc.getDoctorName());
        ps.setString(3, doc.getEmailId());
        ps.setString(4, doc.getContactNo());
        ps.setString(5, doc.getQualification());
        ps.setString(6, doc.getSpecialist());
        ps.setString(7, doc.getGender());
       return ps.executeUpdate() == 1;
    }
    public static String getNewDocId()throws  SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select max(doctor_id) from doctors");
        rs.next();
        int docId=101;
        String id=rs.getString(1);
        if(id!=null){
            String num=id.substring(3);
            docId=Integer.parseInt(num)+1;
         }
        return "DOC"+docId;
    }  
    public static boolean addDoctor(DoctorPojo doc)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into doctors values(?,?,?,?,?,?,?)");
        ps.setString(1,doc.getDoctorId());
        ps.setString(2, doc.getDoctorName());
        ps.setString(3,doc.getEmailId());
        ps.setString(4, doc.getContactNo());
        ps.setString(5, doc.getQualification());
        ps.setString(7, doc.getSpecialist());
        ps.setString(6, doc.getGender());
        return ps.executeUpdate()==1;
   }
    
    public static List<String> getAllDoctorId()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select doctor_id from doctors");
        List<String>list = new ArrayList<>();
        
        while(rs.next()){
            list.add(rs.getString(1));
        }
        return list;
    }
    
    public static boolean deleteDoctorByDoctorId(String Id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select doctor_name from doctors where doctor_id=?");
        ps.setString(1, Id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String name = rs.getString(1);
        UsersDao.deleteUser(name);
        ps = conn.prepareStatement("delete from doctors where doctor_id=?");
        ps.setString(1, Id);
        return ps.executeUpdate()== 1;
    }
    
    public static List<DoctorPojo> getAllDoctorDetails()throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("Select * from doctors");
        List<DoctorPojo>ls = new ArrayList<>();
        while(rs.next()){
            ls.add(new DoctorPojo(rs.getString(1) , rs.getString(2) ,
                    rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) ,rs.getString(7)));
        }
        return ls;
    }
}
