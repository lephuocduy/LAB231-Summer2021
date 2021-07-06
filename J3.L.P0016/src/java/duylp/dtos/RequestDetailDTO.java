/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.dtos;

/**
 *
 * @author Le Phuoc Duy
 */
public class RequestDetailDTO {
    
    private String productID;
    private int detailID, quantity, requestID;
    
    public RequestDetailDTO(String productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    
}
