/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.dtos;

import java.sql.Timestamp;

/**
 *
 * @author Le Phuoc Duy
 */
public class UserDTO {
    
    private String userID, userName, password, email, phoneNumber, photo, roleID, statusUserID;
    private boolean statusPromotion;
    private Timestamp promotionDate;
    private int rank;

    public UserDTO(String password) {
        this.password = password;
    }
        
    public UserDTO(String userID, String userName, String photo, Timestamp promotionDate, int rank) {
        this.userID = userID;
        this.userName = userName;
        this.photo = photo;
        this.promotionDate = promotionDate;
        this.rank = rank;
    }

    public UserDTO(String userID, String userName, String email, String phoneNumber, String photo, String roleID) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
        this.roleID = roleID;
    }
    
    public UserDTO(String userName, String password, String email, String phoneNumber, String photo, boolean statusPromotion, int rank) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
        this.statusPromotion = statusPromotion;
        this.rank = rank;
    }
        
    public UserDTO(String userID, String userName, String password, String email, String phoneNumber, String photo, String roleID, String statusUserID, boolean statusPromotion) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
        this.roleID = roleID;
        this.statusUserID = statusUserID;
        this.statusPromotion = statusPromotion;
    }
  
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getStatusUserID() {
        return statusUserID;
    }

    public void setStatusUserID(String statusUserID) {
        this.statusUserID = statusUserID;
    }

    public boolean isStatusPromotion() {
        return statusPromotion;
    }

    public void setStatusPromotion(boolean statusPromotion) {
        this.statusPromotion = statusPromotion;
    }

    public Timestamp getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(Timestamp promotionDate) {
        this.promotionDate = promotionDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
}
