/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.account;

import quandh.roles.RoleDTO;
import quandh.util.DBHelper;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author PC_HONGQUAN
 */
public class AccountDAO {

    private ArrayList<AccountDTO> accountList;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NamingException {
        AccountDAO dao = new AccountDAO();
        ArrayList<AccountDTO> accountList = dao.getAccountByName("a");
        System.out.println(accountList);
    }

    public ArrayList<AccountDTO> getAccountList() {
        return accountList;
    }

    public ArrayList<AccountDTO> getAllAccount(int index) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM ACCOUNT A INNER JOIN ROLES R "
                        + "ON A.role_id = R.role_id WHERE is_deleted = 0 "
                        + "ORDER BY a.email  OFFSET ? ROWS "
                        + "FETCH FIRST 10 ROWS ONLY";
                ps = con.prepareStatement(sql);
                ps.setInt(1, (index - 1) * 10);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String image = rs.getString("image");
                    String fullname = rs.getString("fullname");
                    String address = rs.getString("address");
                    String phonenum = rs.getString("phone_number");
                    boolean isDeleted = rs.getBoolean("is_deleted");
                    int role = rs.getInt("role_id");
                    String role_name = rs.getString("role_name");
                    RoleDTO roledto = new RoleDTO(role, role_name);
                    AccountDTO account = new AccountDTO(email, password, image, fullname, address, phonenum, isDeleted, roledto);
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();

                    }
                    this.accountList.add(account);
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
        return this.accountList;
    }

    public ArrayList<AccountDTO> getAccountByName(String txtSearch) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                con = DBHelper.makeConnection();
                String sql = "SELECT * FROM ACCOUNT A INNER JOIN ROLES R "
                        + "ON A.role_id = R.role_id WHERE is_deleted = 0 "
                        + "AND A.fullname LIKE ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + txtSearch + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String image = rs.getString("image");
                    String fullname = rs.getString("fullname");
                    String address = rs.getString("address");
                    String phonenum = rs.getString("phone_number");
                    boolean isDeleted = rs.getBoolean("is_deleted");
                    int role = rs.getInt("role_id");
                    String role_name = rs.getString("role_name");
                    RoleDTO roledto = new RoleDTO(role, role_name);
                    AccountDTO account = new AccountDTO(email, password, image, fullname, address, phonenum, isDeleted, roledto);
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();

                    }
                    this.accountList.add(account);
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
        return this.accountList;
    }

    public AccountDTO checkLogin(AccountDTO acc) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AccountDTO account = null;
        try {

            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = " SELECT * FROM ACCOUNT A INNER JOIN ROLES R "
                        + "ON A.role_id = R.role_id WHERE is_deleted = 0 "
                        + "AND email = ? and password = ?";

                ps = con.prepareStatement(sql);
                ps.setString(1, acc.getEmail());
                ps.setString(2, acc.getPassword());
                rs = ps.executeQuery();
                if (rs.next()) {
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String image = rs.getString("image");
                    String fullname = rs.getString("fullname");
                    String address = rs.getString("address");
                    String phonenum = rs.getString("phone_number");
                    boolean isDeleted = rs.getBoolean("is_deleted");
                    int role = rs.getInt("role_id");
                    String role_name = rs.getString("role_name");
                    RoleDTO roledto = new RoleDTO(role, role_name);
                    account = new AccountDTO(email, password, image, fullname, address, phonenum, isDeleted, roledto);
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

        return account;
    }

    public int insertAccount(AccountDTO acc) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int row = 0;
        try {

            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "INSERT INTO Account (email, password, image, fullname, address, phone_number, is_deleted, role_id) "
                        + "VALUES "
                        + "(?, ?, ?, ?, ?, ?, ?, ?);";
                ps = con.prepareStatement(sql);
                ps.setString(1, acc.getEmail());
                ps.setString(2, acc.getPassword());
                ps.setString(3, acc.getImage());
                ps.setString(4, acc.getFullname());
                ps.setString(5, acc.getAddress());
                ps.setString(6, acc.getPhonenum());
                ps.setBoolean(7, false);
                ps.setInt(8, acc.getRole().getId());
                row = ps.executeUpdate();

            }
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return row;
    }

    public int updateAccount(AccountDTO acc) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE Account "
                        + "SET password = ?, "
                        + "    image = ?, "
                        + "    fullname = ?, "
                        + "    address = ?, "
                        + "    phone_number = ?, "
                        + "    is_deleted = 0, "
                        + "    role_id = ? "
                        + "WHERE email = ?;";

                ps = con.prepareStatement(sql);
                ps.setString(1, acc.getPassword());
                ps.setString(2, acc.getImage());
                ps.setString(3, acc.getFullname());
                ps.setString(4, acc.getAddress());
                ps.setString(5, acc.getPhonenum());
                ps.setInt(6, acc.getRole().getId());
                ps.setString(7, acc.getEmail());

                result = ps.executeUpdate();
            }

        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;

    }

    public int updateAccountByAdmin(AccountDTO acc) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            con = DBHelper.makeConnection();
            String sql = "UPDATE Account "
                    + "SET password = ?, "
                    + "address = ?, "
                    + "phone_number = ?, "
                    + "role_id = ? "
                    + "WHERE email = ?;";

            ps = con.prepareStatement(sql);
            ps.setString(1, acc.getPassword());
            ps.setString(2, acc.getAddress());
            ps.setString(3, acc.getPhonenum());
            ps.setInt(4, acc.getRole().getId());
            ps.setString(5, acc.getEmail());

            result = ps.executeUpdate();

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean deleteAccount(AccountDTO acc) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int row = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE Account "
                        + "SET is_deleted = 1"
                        + "WHERE email = ?;";
                ps = con.prepareStatement(sql);
                ps.setString(1, acc.getEmail());
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

    public int getNumberPageTotalAdmin() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        int countPage = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) FROM Account";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
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
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return countPage;

    }
}
