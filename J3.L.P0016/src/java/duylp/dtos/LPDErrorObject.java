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
    
    private String emailError, passwordError;
    private String newEmailError, newFullnameError, newPasswordError, newConfirmError, newPhoneNumberError, newAddressError;
    private String captchaError;

    public LPDErrorObject() {
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getNewEmailError() {
        return newEmailError;
    }

    public void setNewEmailError(String newEmailError) {
        this.newEmailError = newEmailError;
    }

    public String getNewFullnameError() {
        return newFullnameError;
    }

    public void setNewFullnameError(String newFullnameError) {
        this.newFullnameError = newFullnameError;
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

    public String getNewPhoneNumberError() {
        return newPhoneNumberError;
    }

    public void setNewPhoneNumberError(String newPhoneNumberError) {
        this.newPhoneNumberError = newPhoneNumberError;
    }

    public String getNewAddressError() {
        return newAddressError;
    }

    public void setNewAddressError(String newAddressError) {
        this.newAddressError = newAddressError;
    }
    
    public String getCaptchaError() {
        return captchaError;
    }

    public void setCaptchaError(String captchaError) {
        this.captchaError = captchaError;
    } 
}
