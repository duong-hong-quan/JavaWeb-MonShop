/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.products;

import quandh.productstatuses.ProductStatusesDTO;
import quandh.categories.CategoryDTO;

/**
 *
 * @author PC_HONGQUAN
 */
public class ProductDTO {

    private String sku;
    private String name;
    private String img;
    private float price;
    private int quantity;
    private String description;
    private CategoryDTO category;
    private ProductStatusesDTO status;
    private boolean deleted;

    public ProductDTO() {
    }

    public ProductDTO(String sku, float price, int quantity, ProductStatusesDTO status) {
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

   
    public ProductDTO(String sku) {
        this.sku = sku;
    }

    public ProductDTO(String name, String img, float price) {
        this.name = name;
        this.img = img;
        this.price = price;

    }

    public ProductDTO(String sku, String name, String img, float price, int quantity, String description, CategoryDTO category, ProductStatusesDTO status, boolean deleted) {
        this.sku = sku;
        this.name = name;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.status = status;
        this.deleted = deleted;
    }

    /**
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public CategoryDTO getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    /**
     * @return the status
     */
    public ProductStatusesDTO getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ProductStatusesDTO status) {
        this.status = status;
    }

    /**
     * @return the deleted
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * @param deleted the deleted to set
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "sku=" + sku + ", name=" + name + ", img=" + img + ", price=" + price + ", quantity=" + quantity + ", description=" + description + ", category=" + category + ", status=" + status + ", deleted=" + deleted + '}' + "\n";
    }

}
