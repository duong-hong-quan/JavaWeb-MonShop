/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.products;

/**
 *
 * @author PC_HONGQUAN
 */
public class ProductInsertError {

    private String skuIsExistError;
    
    private String skuIsEmptyError;
    private String productNameIsEmptyError;
    private String imageIsEmptyError;
    private String priceIsEmptyError;
    private String quantityIsEmptyError;
    private String descriptionIsEmptyError;
    private String priceIsNumberError;
    private String quantityIsNumberError;

    public String getSkuIsExistError() {
        return skuIsExistError;
    }

    public void setSkuIsExistError(String skuIsExistError) {
        this.skuIsExistError = skuIsExistError;
    }

    public String getSkuIsEmptyError() {
        return skuIsEmptyError;
    }

    public void setSkuIsEmptyError(String skuIsEmptyError) {
        this.skuIsEmptyError = skuIsEmptyError;
    }

    public String getProductNameIsEmptyError() {
        return productNameIsEmptyError;
    }

    public void setProductNameIsEmptyError(String productNameIsEmptyError) {
        this.productNameIsEmptyError = productNameIsEmptyError;
    }

    public String getImageIsEmptyError() {
        return imageIsEmptyError;
    }

    public void setImageIsEmptyError(String imageIsEmptyError) {
        this.imageIsEmptyError = imageIsEmptyError;
    }

    public String getPriceIsEmptyError() {
        return priceIsEmptyError;
    }

    public void setPriceIsEmptyError(String priceIsEmptyError) {
        this.priceIsEmptyError = priceIsEmptyError;
    }

    public String getQuantityIsEmptyError() {
        return quantityIsEmptyError;
    }

    public void setQuantityIsEmptyError(String quantityIsEmptyError) {
        this.quantityIsEmptyError = quantityIsEmptyError;
    }

    public String getDescriptionIsEmptyError() {
        return descriptionIsEmptyError;
    }

    public void setDescriptionIsEmptyError(String descriptionIsEmptyError) {
        this.descriptionIsEmptyError = descriptionIsEmptyError;
    }

    public String getPriceIsNumberError() {
        return priceIsNumberError;
    }

    public void setPriceIsNumberError(String priceIsNumberError) {
        this.priceIsNumberError = priceIsNumberError;
    }

    public String getQuantityIsNumberError() {
        return quantityIsNumberError;
    }

    public void setQuantityIsNumberError(String quantityIsNumberError) {
        this.quantityIsNumberError = quantityIsNumberError;
    }

}
