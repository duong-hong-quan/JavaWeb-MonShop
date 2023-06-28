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
@WebServlet(name = "ShopServlet", urlPatterns = {"/shop"})
public class ShopServlet extends HttpServlet {

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
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            CategoryDAO categorydao = new CategoryDAO();
            ArrayList<CategoryDTO> categories = categorydao.getAllCategory();
            ProductDAO productdao = new ProductDAO();
            int countPage = productdao.getNumberPageTotal();
            request.setAttribute("countPage", countPage);

            ArrayList<ProductDTO> products = productdao.getPaging(Integer.parseInt(index));

            request.setAttribute("categories", categories);
            request.setAttribute("products", products);
        } catch (ClassNotFoundException ex) {
            log("ShopServlet ClassNotFound " + ex.getMessage());
        } catch (NamingException ex) {
            log("ShopServlet NamingException " + ex.getMessage());
        } catch (NullPointerException ex) {
            log("ShopServlet NullPointerException " + ex.getMessage());
        } catch (SQLException ex) {
            log("ShopServlet SQLException " + ex.getMessage());
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
