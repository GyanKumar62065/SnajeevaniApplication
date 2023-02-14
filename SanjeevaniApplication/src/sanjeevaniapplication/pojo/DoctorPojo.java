/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapplication.pojo;

/**
 *
 * @author gk620
 */
public class DoctorPojo {
    private String doctorId , doctorName , emailId, contactNo, qualification, gender, specialist;

    public DoctorPojo(String doctorId, String doctorName, String emailId, String contactNo, String qualification, String gender, String specialist) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.qualification = qualification;
        this.gender = gender;
        this.specialist = specialist;
    }

    public DoctorPojo() {
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
}
