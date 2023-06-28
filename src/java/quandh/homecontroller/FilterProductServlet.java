/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.homecontroller;

import quandh.categories.CategoryDAO;
import quandh.categories.CategoryDTO;
import quandh.products.ProductDAO;
import quandh.products.ProductDTO;
import quandh.util.MyAppConstants;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author PC_HONGQUAN
 */
@WebServlet(name = "FilterProductServlet", urlPatterns = {"/filterproduct"})
public class FilterProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(MyAppConstants.ViewFeatures.SHOP_PAGE);
        try {
            String filter = request.getParameter("filter");
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            String category_id = request.getParameter("cid");

            if (filter.equals("Filter By Category")) {
                CategoryDAO categorydao = new CategoryDAO();
                ArrayList<CategoryDTO> categories = categorydao.getAllCategory();
                request.setAttribute("categories", categories);
                ProductDAO productdao = new ProductDAO();
                int countPage = productdao.getNumberPageCategoryTotal(category_id);
                request.setAttribute("countPage2", countPage);
                ArrayList<ProductDTO> products = productdao.getProducPagingtByCid(category_id, Integer.parseInt(index));
                request.setAttribute("products", products);
                request.setAttribute("cid", category_id);

            }
//            High to low
            if (filter.equals("High To low")) {
                CategoryDAO categorydao = new CategoryDAO();
                ArrayList<CategoryDTO> categories = categorydao.getAllCategory();
                request.setAttribute("categories", categories);
                ProductDAO productdao = new ProductDAO();
                ArrayList<ProductDTO> products = productdao.getProductBySortPriceHighToLow();
                request.setAttribute("products", products);
            }
            //            Low to High

            if (filter.equals("Low To High")) {
                CategoryDAO categorydao = new CategoryDAO();
                ArrayList<CategoryDTO> categories = categorydao.getAllCategory();
                request.setAttribute("categories", categories);
                ProductDAO productdao = new ProductDAO();
                ArrayList<ProductDTO> products = productdao.getProductBySortPriceLowToHigh();
                request.setAttribute("products", products);

            }
//            New Products
            if (filter.equals("New Products")) {
                CategoryDAO categorydao = new CategoryDAO();
                ArrayList<CategoryDTO> categories = categorydao.getAllCategory();
                request.setAttribute("categories", categories);
                ProductDAO productdao = new ProductDAO();
                ArrayList<ProductDTO> products = productdao.getProductBySortLastInsert();
                request.setAttribute("products", products);
            }
//            Filter by name
            if (filter.equals("Search Products")) {
                String txtSearch = request.getParameter("txtSearch");
                if (!txtSearch.isEmpty()) {
                    CategoryDAO categorydao = new CategoryDAO();
                    ArrayList<CategoryDTO> categories = categorydao.getAllCategory();
                    request.setAttribute("categories", categories);
                    ProductDAO productdao = new ProductDAO();
                    ArrayList<ProductDTO> products = productdao.getProductByName(txtSearch);
                    request.setAttribute("products", products);
                    request.setAttribute("txtSearch", txtSearch);

                }
            }

        } catch (ClassNotFoundException ex) {
            log("FilterCategoryServlet ClassNotFoundException " + ex.getMessage());
        } catch (NamingException ex) {
            log("FilterCategoryServlet NamingException " + ex.getMessage());
        } catch (SQLException ex) {
            log("FilterCategoryServlet SQLException " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
