/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.homecontroller;

import quandh.cart.CartObj;
import quandh.products.ProductDAO;
import quandh.products.ProductDTO;
import quandh.util.MyAppConstants;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author PC_HONGQUAN
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/additemtocart"})
public class AddToCartServlet extends HttpServlet {


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
        String url = siteMaps.getProperty(MyAppConstants.ViewFeatures.VIEW_SHOP);
        try {
            //1. Customer goes to cart place
            HttpSession session = request.getSession(true);
            //2. Customer takes his/her cart
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartObj();
            }
            //3. Customer drops item to cart
            String sku = request.getParameter("sku");
            String quantity = request.getParameter("quantity");
            ProductDAO dao = new ProductDAO();
            ProductDTO product = dao.getProductBySKU(sku);
            if (quantity != null) {
                cart.addProductToCart(sku, product);
                cart.addItemToCart(sku, Integer.parseInt(quantity));
                url = siteMaps.getProperty(MyAppConstants.ViewFeatures.VIEW_PRODUCT);
               
                request.setAttribute("sku", sku);
            } else {
                cart.addProductToCart(sku, product);
                cart.addItemToCart(sku, 1);
            }

            session.setAttribute("CART", cart);

        } catch (ClassNotFoundException ex) {
            log("AddToCartServlet ClassNotFound " + ex.getMessage());
        } catch (NullPointerException ex) {
            log("AddToCartServlet NullPointerException " + ex.getMessage());
        } catch (NamingException ex) {
            log("AddToCartServlet NamingException " + ex.getMessage());
        } catch (SQLException ex) {
            log("AddToCartServlet SQLException " + ex.getMessage());
        } finally {
            //4. Customer continously goes shopping
            request.getRequestDispatcher(url).forward(request, response);
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
