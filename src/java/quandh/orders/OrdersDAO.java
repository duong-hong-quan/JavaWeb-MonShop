/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.orders;

import quandh.account.AccountDTO;
import quandh.cart.CartObj;
import quandh.ordertatuses.OrderStatusesDTO;
import quandh.products.ProductDTO;
import quandh.util.DBHelper;

import javax.naming.NamingException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author PC_HONGQUAN
 */
public class OrdersDAO {

    private ArrayList<OrdersDTO> orders;

    /**
     * @return the orders
     */
    public ArrayList<OrdersDTO> getOrders() {
        return orders;
    }

    public String getDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String day = currentDate.format(formatter);
        return day;
    }

    public void checkout(String email, CartObj cart) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Statement stm = null;
        try {
            // Connect to database
            con = DBHelper.makeConnection();
            if (con != null) {
                String day = getDate();
                // Prepare statement for inserting into the Order table
                String insertOrderSQL = "INSERT INTO Orders (email, order_date, total, order_status_id) VALUES (?, ?, ?, ?)";
                pstmt = con.prepareStatement(insertOrderSQL);
                pstmt.setString(1, email);
                pstmt.setString(2, day);
                pstmt.setDouble(3, cart.getTotalPrice());
                pstmt.setInt(4, 1); // 1 = pending status

                // Execute statement and get the generated order ID
                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating order failed, no rows affected.");
                }

                String selectIDOrder = "SELECT MAX(o.order_id) FROM Orders o";
                stm = con.createStatement();
                rs = stm.executeQuery(selectIDOrder);
                int orderId = -1;
                if (rs.next()) {
                    orderId = rs.getInt(1);
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }

                // Prepare statement for inserting into the OrderItem table
                for (Map.Entry<String, Integer> entry : cart.getItems().entrySet()) {
                    String selectProductSql = "SELECT * FROM PRODUCTS WHERE SKU = ?";
                    PreparedStatement productPs = con.prepareStatement(selectProductSql);
                    productPs.setString(1, entry.getKey());
                    ResultSet productRs = productPs.executeQuery();
                    if (productRs.next()) {
                        String skuDTO = productRs.getString("sku");
                        int quantityDTO = productRs.getInt("quantity");

                        String insertOrderDetailSQL = "INSERT INTO OrderItem (order_id, sku, quantity, price, subtotal) VALUES (?, ?, ?, ?, ?)";
                        pstmt = con.prepareStatement(insertOrderDetailSQL);

                        String sku = entry.getKey();
                        int quantity = entry.getValue();
                        ProductDTO product = cart.getProducts().get(sku);
                        double price = product.getPrice();
                        double subtotal = price * quantity;
                        pstmt.setInt(1, orderId);
                        pstmt.setString(2, sku);
                        pstmt.setInt(3, quantity);
                        pstmt.setDouble(4, price);
                        pstmt.setDouble(5, subtotal);
                        pstmt.executeUpdate();

                        int newQuantity = quantityDTO - quantity;
                        String updateProductSql = "UPDATE PRODUCTS SET quantity = ? WHERE SKU = ?";
                        PreparedStatement updatePs = con.prepareStatement(updateProductSql);
                        updatePs.setInt(1, newQuantity);
                        updatePs.setString(2, skuDTO);
                        updatePs.executeUpdate();
                    }

                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }

        }
    }

    public ArrayList<OrdersDTO> getOrderByStatus(AccountDTO acc, int status) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select o.order_id,o.order_date,o.total, os.order_status "
                        + "from orders o inner join OrderStatuses os "
                        + "on o.order_status_id = os.order_status_id "
                        + "Where o.email = ? "
                        + "AND o.order_status_id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, acc.getEmail());
                ps.setInt(2, status);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    String orderDate = rs.getString("order_date");
                    float total = rs.getFloat("total");
                    String orderStatus = rs.getString("order_status");
                    OrdersDTO dto = new OrdersDTO(orderId, orderDate, total, new OrderStatusesDTO(status, orderStatus));
                    if (this.orders == null) {
                        this.orders = new ArrayList<>();
                    }
                    this.orders.add(dto);
                }
            }
            return this.orders;

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

    public ArrayList<OrdersDTO> getAllOrderByStatus(int status, int index) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select * "
                        + "from orders o inner join OrderStatuses os "
                        + "on o.order_status_id = os.order_status_id inner join Account a on  o.email = a.email "
                        + "where o.order_status_id = ? "
                        + "ORDER BY o.order_id  OFFSET ? ROWS "
                        + "FETCH FIRST 10 ROWS ONLY";
                ps = con.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setInt(2, (index - 1) * 10);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String email = rs.getString("email");
                    String fullname = rs.getString("fullname");
                    String phonenum = rs.getString("phone_number");
                    String address = rs.getString("address");

                    AccountDTO account = new AccountDTO(email, null, null, fullname, address, phonenum, false, null);

                    int orderId = rs.getInt("order_id");
                    String orderDate = rs.getString("order_date");
                    float total = rs.getFloat("total");
                    String orderStatus = rs.getString("order_status");
                    int orderStatusId = rs.getInt("order_status_id");

                    OrdersDTO dto = new OrdersDTO(orderId, account, orderDate, total, new OrderStatusesDTO(orderStatusId, orderStatus));
                    if (this.orders == null) {
                        this.orders = new ArrayList<>();
                    }
                    this.orders.add(dto);
                }
            }
            return this.orders;

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

    public ArrayList<OrdersDTO> getOrderByNameOfUser(String txtSearch) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select * "
                        + "from orders o inner join OrderStatuses os "
                        + "on o.order_status_id = os.order_status_id inner join Account a on  o.email = a.email "
                        + "where a.email LIKE ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + txtSearch + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String email = rs.getString("email");
                    String fullname = rs.getString("fullname");
                    String phonenum = rs.getString("phone_number");
                    String address = rs.getString("address");

                    AccountDTO account = new AccountDTO(email, null, null, fullname, address, phonenum, false, null);

                    int orderId = rs.getInt("order_id");
                    String orderDate = rs.getString("order_date");
                    float total = rs.getFloat("total");
                    String orderStatus = rs.getString("order_status");
                    int orderStatusId = rs.getInt("order_status_id");

//                OrdersDTO dto = new OrdersDTO(orderId, orderDate, total, new OrderStatusesDTO(orderId, orderStatus));
                    OrdersDTO dto = new OrdersDTO(orderId, account, orderDate, total, new OrderStatusesDTO(orderStatusId, orderStatus));
                    if (this.orders == null) {
                        this.orders = new ArrayList<>();
                    }
                    this.orders.add(dto);
                }
            }
            return this.orders;

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

    public int totalOrder() throws ClassNotFoundException, SQLException, NamingException {
        int total = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) AS total_orders "
                        + "FROM Orders;";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    total = rs.getInt("total_orders");
                }
            }

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
        return total;
    }

    public int totalOrdersFollowStatusByAdmin(int status) throws ClassNotFoundException, SQLException, NamingException {
        int total = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) AS total_peding_orders "
                        + "FROM Orders WHERE order_status_id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, status);
                rs = ps.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("total_peding_orders");
                }
            }

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
        return total;
    }

    public int totalOrdersFollowStatusByUser(AccountDTO acc, int status) throws ClassNotFoundException, SQLException, NamingException {
        int total = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) AS total_completed_orders "
                        + "FROM Orders WHERE order_status_id = ? AND email = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setString(2, acc.getEmail());
                rs = ps.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("total_completed_orders");
                }
            }

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
        return total;
    }

    public int totalRevenue() throws ClassNotFoundException, SQLException, NamingException {
        int total = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT SUM(total) AS total_revenue "
                        + "FROM Orders;";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    total = rs.getInt("total_revenue");
                }
            }

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
        return total;
    }

    public int totalRevenueAtNow() throws ClassNotFoundException, SQLException, NamingException {
        int total = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT SUM(total) AS daily_total_revenue "
                        + "FROM Orders "
                        + "WHERE order_date = ?;";
                ps = con.prepareStatement(sql);
                ps.setString(1, getDate());
                rs = ps.executeQuery();
                if (rs.next()) {
                    total = rs.getInt("daily_total_revenue");
                }
            }

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
        return total;
    }

    public boolean updateStatusOrder(String order_id, String status_id) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int row = 0;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE Orders "
                        + "SET order_status_id = ? "
                        + "WHERE order_id = ?;";
                ps = con.prepareStatement(sql);
                ps.setString(1, status_id);
                ps.setString(2, order_id);
                row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }

        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public int getNumberPageTotal(int status) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int countPage = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT  COUNT(*) FROM Orders o Where o.order_status_id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, status);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int total = rs.getInt(1);
                    countPage = total / 10;
                    if (total % 10 != 0) {
                        countPage++;
                    }
                }
            }
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
        return countPage;

    }
}
