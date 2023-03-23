/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.categories;

/**
 *
 * @author PC_HONGQUAN
 */
public class CategoryInsertError {

    private String idIsDuplicatedError;
    private String isDigitError;
    private String idIsEmptyError;
    private String categoryNameIsEmptyError;

    public String getIdIsEmptyError() {
        return idIsEmptyError;
    }

    public void setIdIsEmptyError(String idIsEmptyError) {
        this.idIsEmptyError = idIsEmptyError;
    }

    public String getCategoryNameIsEmptyError() {
        return categoryNameIsEmptyError;
    }

    public void setCategoryNameIsEmptyError(String categoryNameIsEmptyError) {
        this.categoryNameIsEmptyError = categoryNameIsEmptyError;
    }
    

    public String getIdIsDuplicatedError() {
        return idIsDuplicatedError;
    }

    public void setIdIsDuplicatedError(String idIsDuplicatedError) {
        this.idIsDuplicatedError = idIsDuplicatedError;
    }

    public String getIsDigitError() {
        return isDigitError;
    }

    public void setIsDigitError(String isDigitError) {
        this.isDigitError = isDigitError;
    }

}
