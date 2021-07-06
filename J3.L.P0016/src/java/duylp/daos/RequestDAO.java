/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.daos;

import duylp.db.MyConnection;
import duylp.dtos.ProductDTO;
import duylp.dtos.RequestDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Le Phuoc Duy
 */
public class RequestDAO {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public RequestDAO() {
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

    public boolean inserRequest(RequestDTO dto) throws Exception {
        boolean result = true;
        try {
            String sql = "Insert Into tblRequests(requestID, bookDate, bookingUntil, email, statusRequestID) Values(?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getRequestID());
            preStm.setTimestamp(2, dto.getBookDate());
            preStm.setDate(3, dto.getBookingUntil());
            preStm.setString(4, dto.getEmail());
            preStm.setString(5, dto.getStatusRequestID());
            preStm.executeUpdate();
            for (ProductDTO pdto : dto.getListProduct()) {
                sql = "Insert Into tblRequestsDetails(quantity, requestID, productID) VALUES(?,?,?)";
                preStm = conn.prepareStatement(sql);
                preStm.setInt(1, pdto.getQuantityRequest());
                preStm.setInt(2, dto.getRequestID());
                preStm.setString(3, pdto.getProductID());
                preStm.executeUpdate();
                sql = "Update tblProducts Set quantity=quantity-? Where productID = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setInt(1, pdto.getQuantityRequest());
                preStm.setString(2, pdto.getProductID());
                preStm.executeUpdate();
            }
        } catch (Exception e) {
            result = false;
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public int getNumberPageRequest() {
        try {
            String sql = "Select count(requestID) From tblRequests";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 20;
                if (total % 20 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return 0;
    }

    public List<RequestDTO> requestList(int index) throws Exception {
        List<RequestDTO> result = null;
        RequestDTO dto;
        try {
            String sql = "select requestID, bookDate, bookingUntil, email, statusRequestID From tblRequests Order By bookDate DESC , requestID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int requestID = Integer.parseInt(rs.getString("requestID"));
                Timestamp bookDate = rs.getTimestamp("bookDate");
                Date bookingUntil = rs.getDate("bookingUntil");
                String email = rs.getString("email");
                String statusRequestID = rs.getString("statusRequestID");
                dto = new RequestDTO(requestID, email, statusRequestID, bookDate, bookingUntil);
                result.add(dto);
            }
        } catch (Exception e) {
            closeMyConnection();
        }
        return result;
    }

    public List<RequestDTO> requestListHistory(String email) throws Exception {
        List<RequestDTO> result = null;
        RequestDTO dto;
        try {
            String sql = "select requestID, bookDate, bookingUntil, statusRequestID From tblRequests Where email=? And statusRequestID='New' Or email=? And statusRequestID='Accept' Order By bookDate DESC";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, email);
            preStm.setString(2, email);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int requestID = Integer.parseInt(rs.getString("requestID"));
                Timestamp bookDate = rs.getTimestamp("bookDate");
                Date bookingUntil = rs.getDate("bookingUntil");
                String statusRequestID = rs.getString("statusRequestID");
                dto = new RequestDTO(requestID, email, statusRequestID, bookDate, bookingUntil);
                result.add(dto);
            }
        } catch (Exception e) {
            closeMyConnection();
        }
        return result;
    }

    public boolean updateRequest(String status, int requestID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblRequests set statusRequestID = ? Where requestID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, status);
            preStm.setInt(2, requestID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeMyConnection();
        }
        return check;
    }

    public boolean deleteRequest(int requestID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblRequests set statusRequestID = 'Delete' Where requestID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, requestID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeMyConnection();
        }
        return check;
    }

    public List<RequestDTO> searchRequest(String statusRequestID, String searchEmail, int index) throws Exception {
        List<RequestDTO> result = null;
        RequestDTO dto;
        try {
            String sql = "select requestID, email, bookDate, bookingUntil, statusRequestID From tblRequests Where statusRequestID = ? And email like ? Order By bookDate DESC , requestID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, statusRequestID);
            preStm.setString(2, "%" + searchEmail + "%");
            preStm.setInt(3, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int requestID = Integer.parseInt(rs.getString("requestID"));
                String email = rs.getString("email");
                Timestamp bookDate = rs.getTimestamp("bookDate");
                Date bookingUntil = rs.getDate("bookingUntil");
                dto = new RequestDTO(requestID, email, statusRequestID, bookDate, bookingUntil);
                result.add(dto);
            }
        } catch (Exception e) {
            closeMyConnection();
        }
        return result;
    }

    public List<RequestDTO> searchDateRequest(String bookDate, String email, int index) throws Exception {
        List<RequestDTO> result = null;
        RequestDTO dto;
        try {
            String sql = "select requestID, email, bookDate, bookingUntil, statusRequestID From tblRequests Where bookDate = ? And email = ? And statusRequestID = 'New' Or bookDate = ? And email = ? And statusRequestID = 'Accept' Order By bookDate DESC , requestID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, bookDate);
            preStm.setString(2, email);
            preStm.setString(3, bookDate);
            preStm.setString(4, email);
            preStm.setInt(5, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int requestID = Integer.parseInt(rs.getString("requestID"));
                Date bookingUntil = rs.getDate("bookingUntil");
                String statusRequestID = rs.getString("statusRequestID");
                dto = new RequestDTO(requestID, email, statusRequestID, Timestamp.valueOf(bookDate), bookingUntil);
                result.add(dto);
            }
        } catch (Exception e) {
            closeMyConnection();
        }
        return result;
    }

    public int getNumberPageSearchRequest(String statusRequestID, String searchEmail) {
        try {
            String sql = "Select count(requestID) From tblRequests Where statusRequestID = ? And email like ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, statusRequestID);
            preStm.setString(2, "%" + searchEmail + "%");
            rs = preStm.executeQuery();
            if (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 20;
                if (total % 20 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return 0;
    }

    public RequestDTO requestDetailList(int requestID) throws Exception {
        RequestDTO result = new RequestDTO();
        List<ProductDTO> productList = null;
        ProductDTO dto;
        try {
            String sql = "Select P.productName, P.image, P.color , D.quantity From tblRequests R Join tblRequestsDetails D On R.requestID=? And R.requestID=D.requestID Join tblProducts P On D.productID=P.productID";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, requestID);
            rs = preStm.executeQuery();
            productList = new ArrayList<>();
            float total = 0;
            while (rs.next()) {
                String productName = rs.getString("productName");
                String image = rs.getString("image");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String color = rs.getString("color");
                dto = new ProductDTO(productName, image, color, quantity);
                productList.add(dto);
            }
            result.setListProduct(productList);
            result.setRequestID(requestID);
        } catch (Exception e) {
            closeMyConnection();
        }
        return result;
    }
  
}
