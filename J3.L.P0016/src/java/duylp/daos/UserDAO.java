/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.daos;

import duylp.db.MyConnection;
import duylp.dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Le Phuoc Duy
 */
public class UserDAO {
    
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public UserDAO() {
    }

    private void closeMyConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public UserDTO checkLogin(String email, String password) {
        UserDTO result = null;
        try {
            String sql = "Select fullname, roleID, statusUserID From tblUsers Where email = ? and password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, email);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("fullname");
                String roleID = rs.getString("roleID");
                String statusUserID = rs.getString("statusUserID");
                result = new UserDTO(fullname, roleID, statusUserID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }
    
    public boolean insertUser(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into tblUsers(email, fullname, password, phoneNumber, address, createUserDate, roleID, statusUserID) Values(?,?,?,?,?,?,'US',?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getEmail());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getPassword());
            preStm.setString(4, dto.getPhoneNumber());
            preStm.setString(5, dto.getAddress());
            preStm.setDate(6, dto.getCreateUserDate());
            preStm.setString(7, dto.getStatusUserID());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeMyConnection();
        }
        return check;
    }
    
    public boolean userVerify(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblUsers set statusUserID = 'Active' Where email = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getEmail());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeMyConnection();
        }
        return check;
    }
        
}
