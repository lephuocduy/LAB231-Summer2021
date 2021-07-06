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
public class LPDErrorObject {
    
    private String userIDError, passwordError;
    private String newUserIDError, newUserNameError, newPasswordError, newConfirmError, newEmailError, newPhoneNumberError, newPhotoError;
    private String newRoleIDError, newRoleNameError;
    private String oldPasswordError;
    
    public LPDErrorObject() {
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getNewUserIDError() {
        return newUserIDError;
    }

    public void setNewUserIDError(String newUserIDError) {
        this.newUserIDError = newUserIDError;
    }

    public String getNewUserNameError() {
        return newUserNameError;
    }

    public void setNewUserNameError(String newUserNameError) {
        this.newUserNameError = newUserNameError;
    }

    public String getNewPasswordError() {
        return newPasswordError;
    }

    public void setNewPasswordError(String newPasswordError) {
        this.newPasswordError = newPasswordError;
    }

    public String getNewConfirmError() {
        return newConfirmError;
    }

    public void setNewConfirmError(String newConfirmError) {
        this.newConfirmError = newConfirmError;
    }

    public String getNewEmailError() {
        return newEmailError;
    }

    public void setNewEmailError(String newEmailError) {
        this.newEmailError = newEmailError;
    }

    public String getNewPhoneNumberError() {
        return newPhoneNumberError;
    }

    public void setNewPhoneNumberError(String newPhoneNumberError) {
        this.newPhoneNumberError = newPhoneNumberError;
    }

    public String getNewPhotoError() {
        return newPhotoError;
    }

    public void setNewPhotoError(String newPhotoError) {
        this.newPhotoError = newPhotoError;
    }

    public String getNewRoleIDError() {
        return newRoleIDError;
    }

    public void setNewRoleIDError(String newRoleIDError) {
        this.newRoleIDError = newRoleIDError;
    }

    public String getNewRoleNameError() {
        return newRoleNameError;
    }

    public void setNewRoleNameError(String newRoleNameError) {
        this.newRoleNameError = newRoleNameError;
    }

    public String getOldPasswordError() {
        return oldPasswordError;
    }

    public void setOldPasswordError(String oldPasswordError) {
        this.oldPasswordError = oldPasswordError;
    }
   
}
