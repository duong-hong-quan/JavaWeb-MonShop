/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.admincontroller;

import java.io.IOException;
import java.io.PrintWriter;
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
import quandh.account.AccountDTO;
import quandh.orders.OrdersDAO;
import quandh.products.ProductDAO;
import quandh.util.MyAppConstants;
import quandh.util.Util;

/**
 *
 * @author PC_HONGQUAN
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {

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
        String url = siteMaps.getProperty(MyAppConstants.AdminFeatures.DASHBOARD_PAGE);;
        try {
            HttpSession session = request.getSession(false);
            AccountDTO account = (AccountDTO) session.getAttribute("account");
            if (account == null || account.getRole().getId() == 2) {
                url = siteMaps.getProperty(MyAppConstants.ViewFeatures.NOTFOUND);
            }
            String day = Util.getDateNow();
            int totalRevenue = 0;
            int totalRevenueAtNow = 0;

            int totalProduct = 0;

            int orderCount = 0;
            int totalOrdersPending = 0;
            int totalOrdersCompleted = 0;
            int countLowStokProducts = 0;

            OrdersDAO dao = new OrdersDAO();
            ProductDAO pDao = new ProductDAO();

            orderCount = dao.totalOrder();
            totalOrdersPending = dao.totalOrdersFollowStatusByAdmin(1);
            totalOrdersCompleted = dao.totalOrdersFollowStatusByAdmin(3);

            totalRevenue = dao.totalRevenue();
            totalRevenueAtNow = dao.totalRevenueAtNow();

            totalProduct = pDao.totalProducts();
            countLowStokProducts = pDao.countLowStokProducs();

            request.setAttribute("orderCount", orderCount);
            request.setAttribute("totalOrdersPending", totalOrdersPending);
            request.setAttribute("totalOrdersCompleted", totalOrdersCompleted);

            request.setAttribute("totalRevenue", totalRevenue);
            request.setAttribute("totalRevenueAtNow", totalRevenueAtNow);

            request.setAttribute("totalProduct", totalProduct);
            request.setAttribute("countLowStokProducts", countLowStokProducts);

            request.setAttribute("day", day);

        } catch (ClassNotFoundException ex) {
            log("DashboardServlet ClassNotFound " + ex.getMessage());
        } catch (NamingException ex) {
            log("DashboardServlet NamingException " + ex.getMessage());
        } catch (SQLException ex) {
            log("DashboardServlet SQLException " + ex.getMessage());
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
