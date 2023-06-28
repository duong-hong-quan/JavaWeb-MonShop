/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.categories;

import quandh.util.DBHelper;

import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author PC_HONGQUAN
 */
public class CategoryDAO implements Serializable {

    private ArrayList<CategoryDTO> categories;

    public ArrayList<CategoryDTO> getCategories() {
        return categories;
    }

    public ArrayList<CategoryDTO> getAllCategory() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT * FROM Categories";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                while (rs.next()) {
                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");
                    CategoryDTO categorydto = new CategoryDTO(category_id, category);

                    if (this.categories == null) {
                        categories = new ArrayList<>();
                    }
                    categories.add(categorydto);
                }
            }
            return this.categories;

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

    public boolean createCategory(CategoryDTO dto) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int row = 0;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO Categories "
                        + "(category_id, category_name) "
                        + "VALUES (?, ?);";
                ps = con.prepareStatement(sql);
                ps.setInt(1, dto.getId());
                ps.setString(2, dto.getCategory());
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

}
