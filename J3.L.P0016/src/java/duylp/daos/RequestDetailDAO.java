/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.daos;

import duylp.db.MyConnection;
import duylp.dtos.RequestDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Le Phuoc Duy
 */
public class RequestDetailDAO {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public RequestDetailDAO() {
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
    
    public List<RequestDetailDTO> requestQuanlityList(int requestID) throws Exception {
        List<RequestDetailDTO> result = null;
        RequestDetailDTO dto;
        try {
            String sql = "select quantity, productID From tblRequestsDetails Where requestID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, requestID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                String productID = rs.getString("productID");
                dto = new RequestDetailDTO(productID, quantity);
                result.add(dto);
            }
        } catch (Exception e) {
            closeMyConnection();
        }
        return result;
    }
}
