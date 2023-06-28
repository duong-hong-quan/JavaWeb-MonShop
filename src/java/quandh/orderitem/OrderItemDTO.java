/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.orderitem;

import quandh.orders.OrdersDTO;
import quandh.products.ProductDTO;

/**
 * @author PC_HONGQUAN
 */
public class OrderItemDTO {

    private int id;
    private OrdersDTO order;
    private ProductDTO product;
    private int quantity;
    private float price;
    private float subtotal;

    public OrderItemDTO() {
    }

    public OrderItemDTO(OrdersDTO order, ProductDTO product, int quantity, float price, float subtotal) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }

    public OrderItemDTO(int id, OrdersDTO order, ProductDTO product, int quantity, float price, float subtotal) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the order
     */
    public OrdersDTO getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(OrdersDTO order) {
        this.order = order;
    }

    /**
     * @return the product
     */
    public ProductDTO getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(ProductDTO product) {
        this.product = product;
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
     * @return the subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" + "id=" + id + ", order=" + order + ", product=" + product + ", quantity=" + quantity + ", price=" + price + ", subtotal=" + subtotal + '}';
    }

}
