/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.admincontroller;

import java.io.IOException;
import java.io.PrintWriter;
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
import quandh.categories.CategoryDAO;
import quandh.categories.CategoryDTO;
import quandh.products.ProductDAO;
import quandh.products.ProductDTO;
import quandh.productstatuses.ProductStatusesDAO;
import quandh.productstatuses.ProductStatusesDTO;
import quandh.util.MyAppConstants;

/**
 *
 * @author PC_HONGQUAN
 */
@WebServlet(name = "ManageProductServlet", urlPatterns = {"/manageproduct"})
public class ManageProductServlet extends HttpServlet {


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
        PrintWriter out = response.getWriter();
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(MyAppConstants.AdminFeatures.MANAGE_PRODUCT_PAGE);
        try {
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            String filter = request.getParameter("filter");
            ProductDAO dao = new ProductDAO();
            CategoryDAO cDao = new CategoryDAO();
            ProductStatusesDAO pDao = new ProductStatusesDAO();

            if (filter == null || filter.equals("Product")) {
                ArrayList<ProductDTO> products = dao.getAllProductForAdmin(Integer.parseInt(index));
                request.setAttribute("products", products);
                int totalProduct = dao.getNumberPageTotalAdmin();
                request.setAttribute("totalProduct", totalProduct);
                int total = dao.countLowStokProducs();
                request.setAttribute("lowstolkproducts", total);

                int productCount = dao.totalProducts();
                request.setAttribute("productCount", productCount);

                ArrayList<CategoryDTO> categories = cDao.getAllCategory();
                request.setAttribute("categories", categories);

                ArrayList<ProductStatusesDTO> statuses = pDao.getAll();
                request.setAttribute("statuses", statuses);

            }
            if (filter.equals("Low Stolk Products")) {
                ArrayList<ProductDTO> products = dao.getLowStolkProducts();
                request.setAttribute("products", products);
                 url = siteMaps.getProperty(MyAppConstants.AdminFeatures.FEW_STOLK_LEFT_PAGE);
                int totalProduct = dao.getNumberPageTotalAdmin();
                request.setAttribute("totalProduct", totalProduct);
                int total = dao.countLowStokProducs();
                request.setAttribute("lowstolkproducts", total);

                int productCount = dao.totalProducts();
                request.setAttribute("productCount", productCount);

                ArrayList<CategoryDTO> categories = cDao.getAllCategory();
                request.setAttribute("categories", categories);

                ArrayList<ProductStatusesDTO> statuses = pDao.getAll();
                request.setAttribute("statuses", statuses);
            }

        } catch (ClassNotFoundException ex) {
            log("ManageProductServlet ClassNotFound " + ex.getMessage());
        } catch (NamingException ex) {
            log("ManageProductServlet NamingException " + ex.getMessage());
        } catch (NullPointerException ex) {
            log("ManageProductServlet NullPointerException " + ex.getMessage());
        } catch (SQLException ex) {
            log("ManageProductServlet SQLException " + ex.getMessage());
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