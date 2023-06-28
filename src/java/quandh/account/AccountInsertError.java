/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.account;

/**
 * @author PC_HONGQUAN
 */
public class AccountInsertError {

    private String emailFormatError;
    private String emailIsEmptyError;
    private String fullnameIsEmptyError;
    private String addressIsEmptyError;
    private String phonenumIsEmptyError;
    private String phonenumIsNotNumberError;

    private String passwordLengthError;
    private String passwordNotMatch;

    private String accountIsExisted;

    public String getPhonenumIsNotNumberError() {
        return phonenumIsNotNumberError;
    }

    public void setPhonenumIsNotNumberError(String phonenumIsNotNumberError) {
        this.phonenumIsNotNumberError = phonenumIsNotNumberError;
    }

    public String getEmailFormatError() {
        return emailFormatError;
    }

    public void setEmailFormatError(String emailFormatError) {
        this.emailFormatError = emailFormatError;
    }

    public String getEmailIsEmptyError() {
        return emailIsEmptyError;
    }

    public void setEmailIsEmptyError(String emailIsEmptyError) {
        this.emailIsEmptyError = emailIsEmptyError;
    }

    public String getFullnameIsEmptyError() {
        return fullnameIsEmptyError;
    }

    public void setFullnameIsEmptyError(String fullnameIsEmptyError) {
        this.fullnameIsEmptyError = fullnameIsEmptyError;
    }

    public String getAddressIsEmptyError() {
        return addressIsEmptyError;
    }

    public void setAddressIsEmptyError(String addressIsEmptyError) {
        this.addressIsEmptyError = addressIsEmptyError;
    }

    public String getPhonenumIsEmptyError() {
        return phonenumIsEmptyError;
    }

    public void setPhonenumIsEmptyError(String phonenumIsEmptyError) {
        this.phonenumIsEmptyError = phonenumIsEmptyError;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public String getPasswordNotMatch() {
        return passwordNotMatch;
    }

    public void setPasswordNotMatch(String passwordNotMatch) {
        this.passwordNotMatch = passwordNotMatch;
    }

    public String getAccountIsExisted() {
        return accountIsExisted;
    }

    public void setAccountIsExisted(String accountIsExisted) {
        this.accountIsExisted = accountIsExisted;
    }

}
