/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.orders;

import quandh.account.AccountDTO;
import quandh.ordertatuses.OrderStatusesDTO;

/**
 *
 * @author PC_HONGQUAN
 */
public class OrdersDTO {
    private int id;
    private AccountDTO account;
    private String orderDate;
    private float total;
    private OrderStatusesDTO orderStatus;

    public OrdersDTO() {
    }

    public OrdersDTO(int id, String orderDate, float total, OrderStatusesDTO OrderStatus) {
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
        this.orderStatus = OrderStatus;
    }

    public OrdersDTO(int id, AccountDTO account, String orderDate, float total, OrderStatusesDTO OrderStatus) {
        this.id = id;
        this.account = account;
        this.orderDate = orderDate;
        this.total = total;
        this.orderStatus = OrderStatus;
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
     * @return the account
     */
    public AccountDTO getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the orderStatus
     */
    public OrderStatusesDTO getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(OrderStatusesDTO orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" + "id=" + id + ", account=" + account + ", orderDate=" + orderDate + ", total=" + total + ", OrderStatus=" + orderStatus + '}';
    }
    
    
    
}
