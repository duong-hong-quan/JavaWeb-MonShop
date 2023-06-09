/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.homecontroller;

import quandh.account.AccountDTO;
import quandh.cart.CartObj;
import quandh.orders.OrdersDAO;
import quandh.util.MyAppConstants;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * @author PC_HONGQUAN
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet {

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
        String url = siteMaps.getProperty(MyAppConstants.LoginAndLogoutFeatures.LOGINPAGEJSP);
        boolean redirect = false;
        try {
            OrdersDAO dao = new OrdersDAO();
//            Customer goes to his her cart place
            HttpSession session = request.getSession(false);
            if (session != null) {
                AccountDTO account = null;
                account = (AccountDTO) session.getAttribute("account");
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (account != null) {
                    if (cart != null) {
                        Map<String, Integer> items = cart.getItems();
                        if (items != null) {
//                        Customer remove items from list
                            dao.checkout(account.getEmail(), cart);
//                            Util.sendEmail(account, cart);

                        }
                        url = siteMaps.getProperty(MyAppConstants.ViewFeatures.VIEW_SHOP);

                        session.removeAttribute("CART");

                    }
                } else {
                    redirect = true;
                    siteMaps.getProperty(MyAppConstants.LoginAndLogoutFeatures.LOGINPAGEJSP);
                    String msg = "Please login to check out";
                    request.setAttribute("msgCart", msg);
                    request.setAttribute("redirectToCart", redirect);

                }

            }

        } catch (NamingException ex) {
            log("CheckOutServlet NamingException " + ex.getMessage());
        } catch (SQLException ex) {
            log("CheckOutServlet SQLException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("CheckOutServlet ClassNotFoundException " + ex.getMessage());
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
