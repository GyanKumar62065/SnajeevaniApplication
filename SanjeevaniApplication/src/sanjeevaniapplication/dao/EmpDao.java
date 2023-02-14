/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sanjeevaniapplication.dbutils.DBConnection;
import sanjeevaniapplication.pojo.EmpPojo;

/**
 *
 * @author gk620
 */
public class EmpDao {
    public static String getNewEmpId() throws SQLException , NumberFormatException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(EMP_ID) FROM EMPLOYEES");
        rs.next();
        String empId = rs.getString(1);
        String s = empId.substring(1);
        int value = Integer.parseInt(s);
        value++;
        String ans = "E" + String.valueOf(value);
        return ans;
    }
    
    public static boolean addEmployees(EmpPojo emp) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEES VALUES (? , ? , ? , ?)");
        ps.setString(1, emp.getEmpId());
        ps.setString(2, emp.getEmpName());
        ps.setString(3, emp.getEmpDepartment());
        ps.setDouble(4, emp.getEmpSal());
        return ps.executeUpdate() == 1;
    }
    
    public static List<String>getAllEmpId() throws SQLException{
       Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("SELECT EMP_ID FROM EMPLOYEES");
       List<String>empIdList = new ArrayList<>();
       while(rs.next()){
           empIdList.add(rs.getString(1));
       }
       return empIdList;
    }
    
    public static EmpPojo getEmpDetailsByEmpId(String id) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMP_ID = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        EmpPojo emp = new EmpPojo(rs.getString(1) , rs.getString(2) , rs.getString(3), rs.getDouble(4));
        return emp;
    }
    
    
    public static boolean updateEmployees(EmpPojo emp) throws SQLException{
        updateName(emp);
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update employees set emp_name=?,emp_salary=? where emp_id=?");
        ps.setString(1, emp.getEmpName());
        ps.setDouble(2, emp.getEmpSal());
        ps.setString(3,emp.getEmpId());
        return ps.executeUpdate() == 1;
    }

    private static void updateName(EmpPojo emp)throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select emp_name from employees where emp_id = ?");
        ps.setString(1, emp.getEmpId());
        ResultSet rs = ps.executeQuery();
        rs.next();
        String currName = rs.getString(1);
        String newName = emp.getEmpName();
        UsersDao.updateName(currName, newName);
        if(emp.getEmpDepartment().equalsIgnoreCase("Receptionist")){
            ReceptionistDao.updateName(currName, newName);
        }else if(emp.getEmpDepartment().equalsIgnoreCase("Doctor")){
            DoctorDao.updateName(currName, newName);
        }
    }
    
    public static List<EmpPojo>getAllEmployeesDetails()throws SQLException{
       Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES");
       List<EmpPojo>empIdList = new ArrayList<>();
       while(rs.next()){
           EmpPojo emp = new EmpPojo(rs.getString(1) , rs.getString(2), rs.getString(3), rs.getDouble(4));
           empIdList.add(emp);
       }
       return empIdList;
    }
    
    public static boolean deleteEMployee(String em) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps1=conn.prepareStatement("Select * from employees where emp_id = ?");
        ps1.setString(1, em);
        ResultSet rs = ps1.executeQuery();
        rs.next();
        EmpPojo emp = new EmpPojo(rs.getString(1), rs.getString(2),rs.getString(3), rs.getDouble(4));
        deleteName(emp);
        PreparedStatement ps=conn.prepareStatement("Delete from employees where emp_id = ?");
        ps.setString(1,em);
        return ps.executeUpdate() == 1;
    }

    private static void deleteName(EmpPojo emp) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select emp_name from employees where emp_id = ?");
        ps.setString(1, emp.getEmpId());
        ResultSet rs = ps.executeQuery();
        rs.next();
        String currName = rs.getString(1);
        UsersDao.deleteUser(currName);
        if(emp.getEmpDepartment().equalsIgnoreCase("Receptionist")){
            ReceptionistDao.deleteReceptionist(currName);
        }else if(emp.getEmpDepartment().equalsIgnoreCase("Doctor")){
            DoctorDao.deleteDoctor(currName);
        }

    }
    
    public static Map<String,String> getUnRegisteredDoctors() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select emp_id,emp_name from employees where emp_department='DOCTOR' and emp_name not in (select user_name from users where user_type='DOCTOR') order by emp_id");
        Map<String , String>unRegDoc = new HashMap<>();
        while(rs.next()){
            unRegDoc.put(rs.getString(1), rs.getString(2));
        }
        return unRegDoc;
    }
    public static Map<String,String> getUnRegisteredReceptionist() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select emp_id,emp_name from employees where emp_department='RECEPTIONIST' and emp_name not in (select user_name from users where user_type='RECEPTIONIST') order by emp_id");
        Map<String , String>unRegRecept = new HashMap<>();
        while(rs.next()){
            unRegRecept.put(rs.getString(1), rs.getString(2));
        }
        return unRegRecept;
    }
    
    
}
