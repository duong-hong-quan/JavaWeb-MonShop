/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.products;

import quandh.categories.CategoryDTO;
import quandh.productstatuses.ProductStatusesDTO;
import quandh.util.DBHelper;

import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author PC_HONGQUAN
 */
public class ProductDAO implements Serializable {

    private ArrayList<ProductDTO> products;

    public ArrayList<ProductDTO> getProducts() {
        return products;
    }

    public ArrayList<ProductDTO> getAllProductForAdmin(int index) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id WHERE p.is_deleted = 0 "
                        + "ORDER BY p.sku "
                        + "OFFSET ? ROWS "
                        + "FETCH FIRST 10 ROWS ONLY";
                ps = con.prepareStatement(sql);
                ps.setInt(1, (index - 1) * 10);
                rs = ps.executeQuery();

                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }

    public ArrayList<ProductDTO> getLowStolkProducts() throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id "
                        + "WHERE quantity < 10 AND p.is_deleted = 0;";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }

    public ProductDTO getProductBySKU(String skuPrimary) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id "
                        + "WHERE sku = ?  AND NOT PS.product_status_id = 3 AND is_deleted = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, skuPrimary);
                rs = stm.executeQuery();

                if (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    return productDTO;
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

        return null;
    }

    public ArrayList<ProductDTO> getProducPagingtByCid(String id, int index) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id "
                        + "WHERE c.category_id = ?  AND NOT PS.product_status_id = 3 AND is_deleted = 0 "
                        + "ORDER BY p.sku "
                        + "OFFSET ? ROWS "
                        + "FETCH FIRST 6 ROWS ONLY";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                stm.setInt(2, (index - 1) * 6);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }

    public ArrayList<ProductDTO> getProductBySortPriceLowToHigh() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id "
                        + "WHERE PS.product_status_id = 1 AND is_deleted = 0 "
                        + "ORDER BY p.price ASC";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }

    public ArrayList<ProductDTO> getProductBySortPriceHighToLow() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id "
                        + "WHERE PS.product_status_id = 1 AND is_deleted = 0 "
                        + "ORDER BY p.price DESC";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }

    public ArrayList<ProductDTO> getProductBySortLastInsert() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id "
                        + "WHERE NOT PS.product_status_id = 3 AND is_deleted = 0 "
                        + "ORDER BY p.sku DESC";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }

    public ArrayList<ProductDTO> getTop4Last() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT TOP 4 p.*, ps.*, c.* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id "
                        + "WHERE NOT PS.product_status_id = 3 AND is_deleted = 0 "
                        + "ORDER BY p.sku DESC";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }

    public ArrayList<ProductDTO> getProductByName(String txtSearch) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id "
                        + " WHERE p.product_name LIKE ? AND NOT PS.product_status_id = 3 AND is_deleted = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + txtSearch + "%");
                rs = stm.executeQuery();

                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }

    public int totalProducts() throws ClassNotFoundException, SQLException, NamingException {
        int total = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) AS total_products "
                        + "FROM Products "
                        + "WHERE is_deleted = 0 AND product_status_id = 1;";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    total = rs.getInt("total_products");
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

    public int countLowStokProducs() throws ClassNotFoundException, SQLException, NamingException {
        int total = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) AS low_stock_products "
                        + "FROM Products p "
                        + "WHERE p.quantity <= 10 AND p.is_deleted = 0; ";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    total = rs.getInt("low_stock_products");
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

    public boolean createProduct(ProductDTO dto) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int row = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO Products "
                        + "(sku, product_name, image, price, "
                        + "quantity, description, "
                        + "category_id, product_status_id, is_deleted) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getSku());
                ps.setString(2, dto.getName());
                ps.setString(3, dto.getImg());
                ps.setFloat(4, dto.getPrice());
                ps.setInt(5, dto.getQuantity());
                ps.setString(6, dto.getDescription());
                ps.setInt(7, dto.getCategory().getId());
                ps.setInt(8, dto.getStatus().getId());
                ps.setBoolean(9, false);
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

    public boolean deleteProduct(ProductDTO dto) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int row = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE Products SET is_deleted = 1 WHERE sku = ?;";
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getSku());

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

    public boolean updateProduct(ProductDTO dto) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        int row = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE Products SET quantity = ?, "
                        + "price = ?, product_status_id = ? WHERE sku = ?;";
                ps = con.prepareStatement(sql);
                ps.setInt(1, dto.getQuantity());
                ps.setFloat(2, dto.getPrice());
                ps.setInt(3, dto.getStatus().getId());
                ps.setString(4, dto.getSku());
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

    public int getNumberPageTotal() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        int countPage = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) FROM Products WHERE is_deleted = 0";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    int total = rs.getInt(1);
                    countPage = total / 6;
                    if (total % 6 != 0) {
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

    public int getNumberPageTotalAdmin() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        int countPage = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) FROM Products";
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

    public int getNumberPageCategoryTotal(String id) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int countPage = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(*) FROM Products p where p.category_id = ? AND p.is_deleted = 0";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int total = rs.getInt(1);
                    countPage = total / 6;
                    if (total % 6 != 0) {
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

    public ArrayList<ProductDTO> getPaging(int index) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "SELECT* "
                        + "FROM Products p "
                        + "INNER JOIN ProductStatuses ps ON p.product_status_id = ps.product_status_id "
                        + "INNER JOIN Categories c ON p.category_id = c.category_id WHERE is_deleted = 0 "
                        + "AND NOT ps.product_status_id = 3 "
                        + "ORDER BY p.sku "
                        + "OFFSET ? ROWS "
                        + "FETCH FIRST 6 ROWS ONLY";
                ps = con.prepareStatement(sql);
                ps.setInt(1, (index - 1) * 6);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("product_name");
                    String img = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    boolean deleted = rs.getBoolean("is_deleted");

                    int ps_id = rs.getInt("product_status_id");
                    String ps_status = rs.getString("product_status");

                    int category_id = rs.getInt("category_id");
                    String category = rs.getString("category_name");

                    CategoryDTO categorydto = new CategoryDTO(category_id, category);
                    ProductStatusesDTO statusDTO = new ProductStatusesDTO(ps_id, ps_status);
                    ProductDTO productDTO = new ProductDTO(sku, name, img, price, quantity, description, categorydto, statusDTO, deleted);
                    if (this.products == null) {
                        products = new ArrayList<>();
                    }
                    products.add(productDTO);
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

        return products;
    }


}
