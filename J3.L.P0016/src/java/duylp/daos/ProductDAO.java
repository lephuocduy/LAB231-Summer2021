/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.daos;

import duylp.db.MyConnection;
import duylp.dtos.ProductDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Le Phuoc Duy
 */
public class ProductDAO {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public ProductDAO() {
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

    public List<ProductDTO> productListUS(int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where status = 1 And levelUser = 0 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> productListLD(int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where status = 1 And levelUser = 1 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> findByLikeProductNameUS(String search, int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where productName LIKE ? And status = 1 And levelUser = 0 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setInt(2, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> findByDateProductUS(String searchDate, int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID  From tblProducts Where createProductDate >= ? And status = 1 And levelUser = 0 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, searchDate);
            preStm.setInt(2, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> findByLikeProductNameLD(String search, int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where productName LIKE ? And status = 1 And levelUser = 1 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setInt(2, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> findByDateProductLD(String searchDate, int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID  From tblProducts Where createProductDate >= ? And status = 1 And levelUser = 1 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, searchDate);
            preStm.setInt(2, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> productListUSE(int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where categoryID LIKE 'E' And status = 1 And levelUser = 0 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> productListLDE(int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where categoryID LIKE 'E' And status = 1 And levelUser = 1 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> productListUSI(int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where categoryID LIKE 'I' And status = 1 And levelUser = 0 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> productListLDI(int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where categoryID LIKE 'I' And status = 1 And levelUser = 1 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> productListUSO(int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where categoryID LIKE 'O' And status = 1 And levelUser = 0 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public List<ProductDTO> productListLDO(int index) throws Exception {
        List<ProductDTO> result = null;
        ProductDTO dto;
        try {
            String sql = "Select productID, productName, quantity, image, color, createProductDate, categoryID From tblProducts Where categoryID LIKE 'O' And status = 1 And levelUser = 1 Order By productID Offset ? Rows Fetch First 20 Rows Only";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 20);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String image = rs.getString("image");
                String color = rs.getString("color");
                Date createProductDate = rs.getDate("createProductDate");
                String categoryID = rs.getString("categoryID");
                dto = new ProductDTO(productID, productName, image, color, categoryID, quantity, createProductDate);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeMyConnection();
        }
        return result;
    }

    public int getNumberPageUS() {
        try {
            String sql = "Select count(productID) From tblProducts Where levelUser = 0 And status = 1";
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

    public int getNumberPageLikeUS(String search) {
        try {
            String sql = "Select count(productID) From tblProducts Where productName LIKE ? And levelUser = 0 And status = 1";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
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

    public int getNumberPageDateUS(String searchDate) {
        try {
            String sql = "Select count(productID) From tblProducts Where createProductDate >= ? And levelUser = 0 And status = 1";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, searchDate);
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

    public int getNumberPageLD() {
        try {
            String sql = "Select count(productID) From tblProducts Where levelUser = 1 And status = 1";
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

    public int getNumberPageLikeLD(String search) {
        try {
            String sql = "Select count(productID) From tblProducts Where productName LIKE ? And levelUser = 1 And status = 1";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
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

    public int getNumberPageDateLD(String searchDate) {
        try {
            String sql = "Select count(productID) From tblProducts Where createProductDate >= ? And levelUser = 1 And status = 1";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, searchDate);
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

    public boolean updateQuanlity(int quantity, String productID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tblProducts Set quantity=quantity+? Where productID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, quantity);
            preStm.setString(2, productID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeMyConnection();
        }
        return check;
    }

}
