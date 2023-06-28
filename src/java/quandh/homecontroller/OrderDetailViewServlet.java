/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.homecontroller;

import quandh.account.AccountDTO;
import quandh.orderitem.OrderItemDAO;
import quandh.orderitem.OrderItemDTO;
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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author PC_HONGQUAN
 */
@WebServlet(name = "OrderDetailViewServlet", urlPatterns = {"/orderdetails"})
public class OrderDetailViewServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(MyAppConstants.ViewFeatures.ORDER_DETAILS_PAGE);
        try {
            String orderIdStr = request.getParameter("orderid");
            String total = request.getParameter("total");
            String status = request.getParameter("status");

            if (orderIdStr != null) {
                int orderId = Integer.parseInt(orderIdStr);
                OrderItemDAO dao = new OrderItemDAO();
                OrdersDAO oDao = new OrdersDAO();
                HttpSession session = request.getSession(false);
                AccountDTO account = (AccountDTO) session.getAttribute("account");
                ArrayList<OrderItemDTO> oitems = dao.getOrderItemByOrderId(orderId);
                request.setAttribute("total", total);
                request.setAttribute("orderid", orderIdStr);
                request.setAttribute("status", status);

                request.setAttribute("oitems", oitems);
                int orderCompleted = oDao.totalOrdersFollowStatusByUser(account, 3);
                int orderInprogress = oDao.totalOrdersFollowStatusByUser(account, 2);
                int orderPending = oDao.totalOrdersFollowStatusByUser(account, 1);
                request.setAttribute("orderPending", orderPending);
                request.setAttribute("orderInprogress", orderInprogress);
                request.setAttribute("orderCompleted", orderCompleted);
            }
        } catch (NamingException ex) {
            log("OrderDetailViewServlet NamingException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("OrderDetailViewServlet ClassNotFound " + ex.getMessage());
        } catch (SQLException ex) {
            log("OrderDetailViewServlet SQLException " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
