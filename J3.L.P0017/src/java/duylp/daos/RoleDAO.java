/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.daos;

import duylp.db.MyConnection;
import duylp.dtos.RoleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Le Phuoc Duy
 */
public class RoleDAO {
    
    private static final Logger LOGGER = Logger.getLogger(RoleDAO.class);

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public RoleDAO() {
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
    
    public List<RoleDTO> listRole() throws Exception {
        List<RoleDTO> result = null;
        RoleDTO dto;
        try {
            String sql = "Select roleID, roleName From tblRoles";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String roleID = rs.getString("roleID");
                String roleName = rs.getString("roleName");
                dto = new RoleDTO(roleID, roleName);
                result.add(dto);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return result;
    }
    
    public boolean insertRole(RoleDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into tblRoles(roleID, roleName) Values(?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRoleID());
            preStm.setString(2, dto.getRoleName());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }
    
    public boolean checkRoleID(String roleID) throws Exception {
        boolean check = false;
        try {
            String sql = "Select roleName From tblRoles Where roleID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, roleID);
            rs = preStm.executeQuery();
            if (rs.next())
                check = true;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }
}
