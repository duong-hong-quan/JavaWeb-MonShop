/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.homecontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quandh.account.AccountDAO;
import quandh.account.AccountDTO;
import quandh.util.MyAppConstants;

/**
 *
 * @author PC_HONGQUAN
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDTO result;
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(MyAppConstants.LoginAndLogoutFeatures.LOGINPAGEJSP);
        String error = null;
        try {

            String email = request.getParameter("email").trim();
            String password = request.getParameter("password").trim();
            String redirectToCart = request.getParameter("redirectToCart");
            boolean redirect = Boolean.parseBoolean(redirectToCart);
            AccountDAO dao = new AccountDAO();
            result = dao.checkLogin(new AccountDTO(email, password));
            HttpSession session = request.getSession();

            if (result != null) {
                if (redirect) {
                    url = siteMaps.getProperty(MyAppConstants.ViewFeatures.VIEW_CART);
                } else {
                    url = siteMaps.getProperty(MyAppConstants.ViewFeatures.VIEW_SHOP);
                }

            } else {
                error = "Invalid username or password!";
            }

            session.setAttribute("account", result);

            request.setAttribute("login_result", result);
            request.setAttribute("error", error);

        } catch (NamingException ex) {
            log("LoginServlet NamingException " + ex.getMessage());
        } catch (SQLException ex) {
            log("LoginServlet SQLException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("LoginServlet ClassNotFound " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
