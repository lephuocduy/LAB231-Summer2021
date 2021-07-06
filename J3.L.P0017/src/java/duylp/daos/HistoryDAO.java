/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.daos;

import duylp.db.MyConnection;
import duylp.dtos.HistoryDTO;
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
public class HistoryDAO {
    
    private static final Logger LOGGER = Logger.getLogger(HistoryDAO.class);
    
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public HistoryDAO() {
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
    
    public boolean insertHistory(HistoryDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into tblHistories(historyDate, historyRank, userID) Values(?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, dto.getHistoryDate());
            preStm.setInt(2, dto.getHistoryRank());
            preStm.setString(3, dto.getUserID());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return check;
    }
    
    public List<HistoryDTO> historyList(String userID) throws Exception {
        List<HistoryDTO> result = null;
        HistoryDTO dto;
        try {
            String sql = "Select historyDate, historyRank From tblHistories Where userID = ? Order By historyDate DESC";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Timestamp historyDate = rs.getTimestamp("historyDate");
                int historyRank = rs.getInt("historyRank");
                dto = new HistoryDTO(historyDate, historyRank);
                result.add(dto);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeMyConnection();
        }
        return result;
    }
    
}
