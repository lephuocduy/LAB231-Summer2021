/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.dtos;

import java.sql.Date;

/**
 *
 * @author Le Phuoc Duy
 */
public class UserDTO {
    private String email, fullname, password, phoneNumber, address, roleID, statusUserID, code;
    private Date createUserDate;

    public UserDTO(String email) {
        this.email = email;
    }
    
    public UserDTO(String email, String code) {
        this.email = email;
        this.code = code;
    }
    
    public UserDTO(String fullname, String roleID, String statusUserID) {
        this.fullname = fullname;
        this.roleID = roleID;
        this.statusUserID = statusUserID;
    }

    public UserDTO(String email, String fullname, String password, String phoneNumber, String address, String roleID, String statusUserID, Date createUserDate) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.roleID = roleID;
        this.statusUserID = statusUserID;
        this.createUserDate = createUserDate;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getStatusUserID() {
        return statusUserID;
    }

    public void setStatusUserID(String statusUserID) {
        this.statusUserID = statusUserID;
    }

    public Date getCreateUserDate() {
        return createUserDate;
    }

    public void setCreateUserDate(Date createUserDate) {
        this.createUserDate = createUserDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
  
}
