/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.orderitem;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import quandh.products.ProductDTO;
import quandh.util.DBHelper;

/**
 *
 * @author PC_HONGQUAN
 */
public class OrderItemDAO implements Serializable {

    private ArrayList<OrderItemDTO> orderItems;

    /**
     * @return the orderItems
     */
    public ArrayList<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public ArrayList<OrderItemDTO> getOrderItemByOrderId(int id) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT p.product_name, "
                        + "p.image,p.price,oi.quantity, oi.subtotal  "
                        + "FROM OrderItem oi INNER JOIN Orders o "
                        + "ON oi.order_id = o.order_id  "
                        + "INNER JOIN Products p ON oi.sku = p.sku "
                        + "WHERE o.order_id = ? ";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productName = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    float subtotal = rs.getFloat("subtotal");
                    ProductDTO productDTO = new ProductDTO(productName, img, price);
                    OrderItemDTO orderItemDTO = new OrderItemDTO(null, productDTO, quantity, price, subtotal);
                    if (this.orderItems == null) {
                        this.orderItems = new ArrayList<>();
                    }
                    this.orderItems.add(orderItemDTO);
                }
            }
            return this.orderItems;

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

   
}
