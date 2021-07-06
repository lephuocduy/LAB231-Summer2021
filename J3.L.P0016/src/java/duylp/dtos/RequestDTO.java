/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.dtos;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Le Phuoc Duy
 */
public class RequestDTO {
    
    private int requestID;
    private String email, statusRequestID;
    private Timestamp bookDate;
    private Date bookingUntil;
    private List<ProductDTO> listProduct;
    
    public RequestDTO() {
        this.listProduct = new ArrayList<>();
    }
    
    public RequestDTO(int requestID, String email, String statusRequestID, Timestamp bookDate, Date bookingUntil) {
        this.requestID = requestID;
        this.email = email;
        this.statusRequestID = statusRequestID;
        this.bookDate = bookDate;
        this.bookingUntil = bookingUntil;
        this.listProduct = new ArrayList<>();
    }
    
    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBookDate() {
        return bookDate;
    }

    public void setBookDate(Timestamp bookDate) {
        this.bookDate = bookDate;
    }

    public Date getBookingUntil() {
        return bookingUntil;
    }

    public void setBookingUntil(Date bookingUntil) {
        this.bookingUntil = bookingUntil;
    }
    
    public String getStatusRequestID() {
        return statusRequestID;
    }

    public void setStatusRequestID(String statusRequestID) {
        this.statusRequestID = statusRequestID;
    }

    public List<ProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }
    
}
