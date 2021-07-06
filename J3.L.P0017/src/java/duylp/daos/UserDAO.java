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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Le Phuoc Duy
 */
public class UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);

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
            LOGGER.error(e);
        }
    }

    public String checkLogin(String userID, String password) {
        String role = "failed";
        try {
            String sql = "Select roleID, statusUserID From tblUsers Where userID = ? and password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String status = rs.getString("statusUserID");
                if (status.equals("Active")) {
                    role = rs.getString("roleID");
                } else if (status.equals("Inactive")) {
                    role = "inactive";
                }
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return role;
    }

    public List<UserDTO> list() throws Exception {
        List<UserDTO> result = null;
        UserDTO dto;
        try {
            String sql = "Select userID, userName, email, phoneNumber, photo, roleID From tblUsers Where statusUserID = 'Active'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userID");
                String userName = rs.getString("userName");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String photo = rs.getString("photo");
                String roleID = rs.getString("roleID");
                dto = new UserDTO(userID, userName, email, phoneNumber, photo, roleID);
                result.add(dto);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<UserDTO> roleUserList(String role) throws Exception {
        List<UserDTO> result = null;
        UserDTO dto;
        try {
            String sql = "Select userID, userName, password, email, phoneNumber, photo, roleID From tblUsers Where roleID = ? And statusUserID = 'Active'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, role);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userID");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String photo = rs.getString("photo");
                String roleID = rs.getString("roleID");
                dto = new UserDTO(userID, userName, email, phoneNumber, photo, roleID);
                result.add(dto);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<UserDTO> findByLikeName(String search) throws Exception {
        List<UserDTO> result = null;
        UserDTO dto;
        try {
            String sql = "Select userID, userName, password, email, phoneNumber, photo, roleID From tblUsers Where userName LIKE ? And statusUserID = 'Active'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userID");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String photo = rs.getString("photo");
                String roleID = rs.getString("roleID");
                dto = new UserDTO(userID, userName, email, phoneNumber, photo, roleID);
                result.add(dto);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public boolean insertUser(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into tblUsers(userID, userName, password, email, phoneNumber, photo, statusPromotion, roleID, statusUserID) Values(?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUserID());
            preStm.setString(2, dto.getUserName());
            preStm.setString(3, dto.getPassword());
            preStm.setString(4, dto.getEmail());
            preStm.setString(5, dto.getPhoneNumber());
            preStm.setString(6, dto.getPhoto());
            preStm.setBoolean(7, dto.isStatusPromotion());
            preStm.setString(8, dto.getRoleID());
            preStm.setString(9, dto.getStatusUserID());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }
    
    public boolean updateUser(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblUsers set userName = ?, email = ?, phoneNumber = ?, photo = ?, roleID = ? Where userID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUserName());
            preStm.setString(2, dto.getEmail());
            preStm.setString(3, dto.getPhoneNumber());
            preStm.setString(4, dto.getPhoto());
            preStm.setString(5, dto.getRoleID());
            preStm.setString(6, dto.getUserID());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }
    
    public boolean changePassword(String password, String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblUsers set password = ? Where userID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, password);
            preStm.setString(2, userID);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }

    public boolean deleteUser(String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblUsers set statusUserID = 'Inactive' Where userID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }

    public UserDTO findByUserID(String userID) {
        UserDTO result = null;
        try {
            String sql = "Select userName, password, email, phoneNumber, photo, statusPromotion, rank From tblUsers Where userID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String photo = rs.getString("photo");
                boolean statusPromotion = rs.getBoolean("statusPromotion");
                int rank = rs.getInt("rank");
                result = new UserDTO(userName, password, email, phoneNumber, photo, statusPromotion, rank);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public boolean addPromotion(Timestamp promotionDate, int rank, String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblUsers set statusPromotion = 1, promotionDate = ?, rank = ? Where userID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, promotionDate);
            preStm.setInt(2, rank);
            preStm.setString(3, userID);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }

    public List<UserDTO> promotionList() throws Exception {
        List<UserDTO> result = null;
        UserDTO dto;
        try {
            String sql = "Select userID, userName, photo, promotionDate , rank From tblUsers Where statusPromotion = 1 And statusUserID = 'Active'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userID");
                String userName = rs.getString("userName");
                String photo = rs.getString("photo");
                Timestamp promotionDate = rs.getTimestamp("promotionDate");
                int rank = rs.getInt("rank");
                dto = new UserDTO(userID, userName, photo, promotionDate, rank);
                result.add(dto);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public boolean updateRank(Timestamp promotionDate, int rank, String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblUsers set promotionDate = ?, rank = ? Where userID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, promotionDate);
            preStm.setInt(2, rank);
            preStm.setString(3, userID);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }

    public boolean deletePromotion(String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblUsers set statusPromotion = 0 Where userID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }

}
