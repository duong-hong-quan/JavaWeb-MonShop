/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.admincontroller;

import quandh.account.AccountDAO;
import quandh.account.AccountDTO;
import quandh.roles.RoleDAO;
import quandh.roles.RoleDTO;
import quandh.util.MyAppConstants;
import quandh.util.Util;

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
@WebServlet(name = "ManageUserServlet", urlPatterns = {"/manageuser"})
public class ManageUserServlet extends HttpServlet {


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
        String url = siteMaps.getProperty(MyAppConstants.AdminFeatures.MANAGE_USER_PAGE);
//        String url = "manageuser.jsp";
        try {
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            String day = Util.getDateNow();
            AccountDAO dao = new AccountDAO();
            int totalUser = dao.getNumberPageTotalAdmin();
            request.setAttribute("totalUser", totalUser);
            ArrayList<AccountDTO> accounts = dao.getAllAccount(Integer.parseInt(index));
            RoleDAO rDao = new RoleDAO();
            ArrayList<RoleDTO> roles = rDao.getAll();
            request.setAttribute("roles", roles);
            request.setAttribute("day", day);
            request.setAttribute("accounts", accounts);

        } catch (NamingException ex) {
            log("ManageUserServlet NamingException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("ManageUserServlet ClassNotFound " + ex.getMessage());
        } catch (NullPointerException ex) {
            log("ManageUserServlet NullPointerException " + ex.getMessage());
        } catch (SQLException ex) {
            log("ManageUserServlet SQLException " + ex.getMessage());
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
