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
public class ProductDTO {
    private String productID, productName, image, color, categoryID;
    private int quantity, levelUser, quantityRequest = 1;
    private boolean status;
    private Date createProductDate, bookingUntil;

    public ProductDTO() {
    }
    
    public ProductDTO(String productName, String image, String color, int quantityRequest) {
        this.productName = productName;
        this.image = image;
        this.color = color;
        this.quantityRequest = quantityRequest;
    }
    
    public ProductDTO(String productID, String productName, String image, String color, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.color = color;
        this.quantity = quantity;
    }
    
    public ProductDTO(String productID, String productName, String image, String color, String categoryID, int quantity, Date createProductDate) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.color = color;
        this.categoryID = categoryID;
        this.quantity = quantity;
        this.createProductDate = createProductDate;
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLevelUser() {
        return levelUser;
    }

    public void setLevelUser(int levelUser) {
        this.levelUser = levelUser;
    }

    public int getQuantityRequest() {
        return quantityRequest;
    }

    public void setQuantityRequest(int quantityRequest) {
        this.quantityRequest = quantityRequest;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateProductDate() {
        return createProductDate;
    }

    public void setCreateProductDate(Date createProductDate) {
        this.createProductDate = createProductDate;
    }

    public Date getBookingUntil() {
        return bookingUntil;
    }

    public void setBookingUntil(Date bookingUntil) {
        this.bookingUntil = bookingUntil;
    }

}
