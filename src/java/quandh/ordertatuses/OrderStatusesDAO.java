/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.ordertatuses;

import quandh.util.DBHelper;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author PC_HONGQUAN
 */
public class OrderStatusesDAO {

    private ArrayList<OrderStatusesDTO> ordertatuses;

    /**
     * @return the ordertatuses
     */
    public ArrayList<OrderStatusesDTO> getOrdertatuses() {
        return ordertatuses;
    }

    public ArrayList<OrderStatusesDTO> getAll() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select * from OrderStatuses";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("order_status_id");
                    String status = rs.getString("order_status");
                    OrderStatusesDTO dto = new OrderStatusesDTO(id, status);
                    if (this.ordertatuses == null) {
                        this.ordertatuses = new ArrayList<>();
                    }
                    ordertatuses.add(dto);
                }
            }
            return this.ordertatuses;

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
    }
}
