/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.admincontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quandh.orders.OrdersDAO;
import quandh.orders.OrdersDTO;
import quandh.util.MyAppConstants;

/**
 *
 * @author PC_HONGQUAN
 */
@WebServlet(name = "SearchOrderByNameServlet", urlPatterns = {"/searchorderbyname"})
public class SearchOrderByNameServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(MyAppConstants.AdminFeatures.MANAGE_ORDER_PAGE);
        try {
            String txtSearch = request.getParameter("txtSearch").trim();
            OrdersDAO dao = new OrdersDAO();
            ArrayList<OrdersDTO> orders = dao.getOrderByNameOfUser(txtSearch);
            int orderCompleted = dao.totalOrdersFollowStatusByAdmin(3);
            int orderInprogress = dao.totalOrdersFollowStatusByAdmin(2);
            int orderPending = dao.totalOrdersFollowStatusByAdmin(1);
            request.setAttribute("orderPending", orderPending);
            request.setAttribute("orderInprogress", orderInprogress);
            request.setAttribute("orderCompleted", orderCompleted);
            request.setAttribute("orders", orders);
            request.setAttribute("txtSearch", txtSearch);
        } catch (NamingException ex) {
            log("SearchOrderByNameServlet NamingException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("SearchOrderByNameServlet ClassNotFound " + ex.getMessage());
        } catch (SQLException ex) {
            log("SearchOrderByNameServlet SQLException " + ex.getMessage());
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
