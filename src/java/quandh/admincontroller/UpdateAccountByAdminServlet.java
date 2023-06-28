/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.admincontroller;

import quandh.account.AccountDAO;
import quandh.account.AccountDTO;
import quandh.account.AccountInsertError;
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
import java.util.Properties;

/**
 * @author PC_HONGQUAN
 */
@WebServlet(name = "UpdateAccountByAdminServlet", urlPatterns = {"/updateaccountbyadmin"})
public class UpdateAccountByAdminServlet extends HttpServlet {


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
        String url = siteMaps.getProperty(MyAppConstants.AdminFeatures.MANAGE_USER_ACTION);
        boolean error = false;
        AccountInsertError e = new AccountInsertError();
        int row = 0;
        try {
            String email = request.getParameter("email").trim();
            String password = request.getParameter("password").trim();
            String address = request.getParameter("address").trim();
            String phonenum = request.getParameter("phonenum").trim();
            String roleId = request.getParameter("roleId").trim();

            if (address.isEmpty()) {
                e.setAddressIsEmptyError("Address field cannot be left empty.");
                error = true;

            }
            if (password.length() < 8 || password.length() > 20) {
                e.setPasswordLengthError("Password field must be at least 8 characters and at most 20 characters.");
                error = true;

            }
            if (password.length() == 0) {
                e.setPasswordLengthError("Password  field cannot be left empty..");
                error = true;

            }
            if (phonenum.isEmpty()) {
                e.setPhonenumIsEmptyError("Phone number field cannot be left empty.");
                error = true;

            }
            if (Util.isNumber(phonenum) == false && !phonenum.isEmpty()) {
                e.setPhonenumIsNotNumberError("Phone number field must contain only numbers");
                error = true;

            }

            if (error == true) {
                request.setAttribute("INSERTERR", e);
            }
            if (error == false) {
                AccountDTO dto = new AccountDTO(email, password, null, null,
                        address, phonenum, false,
                        new RoleDTO(Integer.parseInt(roleId)));
                AccountDAO dao = new AccountDAO();
                row = dao.updateAccountByAdmin(dto);

            }

        } catch (NamingException ex) {
            log("UpdateAccountByAdminServlet NamingException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("UpdateAccountByAdminServlet ClassNotFound " + ex.getMessage());
        } catch (SQLException ex) {
            log("UpdateAccountByAdminServlet SQLException " + ex.getMessage());
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
