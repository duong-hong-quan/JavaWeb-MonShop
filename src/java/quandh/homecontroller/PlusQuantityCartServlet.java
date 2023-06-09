/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
 * @author LAPTOP_HONGQUAN
 */
@WebServlet(name = "PlusQuantityCartServlet", urlPatterns = {"/plusquantity"})
public class PlusQuantityCartServlet extends HttpServlet {


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
        String url = siteMaps.getProperty(MyAppConstants.ViewFeatures.VIEW_CART);
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
            ProductDAO dao = new ProductDAO();
            ProductDTO product = dao.getProductBySKU(sku);
            cart.addProductToCart(sku, product);
            cart.addItemToCart(sku, 1);

            session.setAttribute("CART", cart);

        } catch (ClassNotFoundException ex) {
            log("PlusQuantityCartServlet ClassNotFound " + ex.getMessage());
        } catch (NamingException ex) {
            log("PlusQuantityCartServlet NamingException " + ex.getMessage());
        } catch (SQLException ex) {
            log("PlusQuantityCartServlet SQLException " + ex.getMessage());
        } finally {
            //4. Customer continously goes shopping
            response.sendRedirect(url);
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
