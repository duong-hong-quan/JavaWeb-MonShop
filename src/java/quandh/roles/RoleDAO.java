/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.roles;

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
public class RoleDAO {

    private ArrayList<RoleDTO> roles;

    /**
     * @return the roles
     */
    public ArrayList<RoleDTO> getRoles() {
        return roles;
    }

    public ArrayList<RoleDTO> getAll() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM ROLES";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("role_id");
                    String roleName = rs.getString("role_name");
                    RoleDTO role = new RoleDTO(id, roleName);
                    if (this.roles == null) {
                        this.roles = new ArrayList<>();
                    }
                    this.roles.add(role);
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
        return this.roles;
    }
}
