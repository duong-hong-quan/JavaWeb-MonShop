/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.productstatuses;

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
public class ProductStatusesDAO {

    private ArrayList<ProductStatusesDTO> statusList;

    /**
     * @return the statusList
     */
    public ArrayList<ProductStatusesDTO> getStatusList() {
        return statusList;
    }

    public ArrayList<ProductStatusesDTO> getAll() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM ProductStatuses";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("product_status_id");
                    String status = rs.getString("product_status");
                    ProductStatusesDTO dto = new ProductStatusesDTO(id, status);
                    if (this.statusList == null) {
                        this.statusList = new ArrayList<>();
                    }
                    this.statusList.add(dto);
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

        return this.statusList;
    }
}
