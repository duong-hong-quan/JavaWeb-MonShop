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
import quandh.products.ProductDAO;
import quandh.products.ProductDTO;
import quandh.products.ProductInsertError;
import quandh.productstatuses.ProductStatusesDTO;
import quandh.util.MyAppConstants;
import quandh.util.Util;

/**
 *
 * @author PC_HONGQUAN
 */
@WebServlet(name = "UpdateProductBySkuServlet", urlPatterns = {"/updateproductbysku"})
public class UpdateProductBySkuServlet extends HttpServlet {


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
        String url = siteMaps.getProperty(MyAppConstants.AdminFeatures.MANAGE_PRODUCT_ACTION);
        boolean error = false;
        ProductInsertError p = new ProductInsertError();
        try {
            String sku = request.getParameter("sku").trim();
            String quantity = request.getParameter("quantity").trim();
            String price = request.getParameter("price").trim();
            String sId = request.getParameter("sId").trim();
//            int id = Integer.parseInt(sId);

            if (price.isEmpty()) {
                error = true;
                p.setPriceIsEmptyError("Price cannot be left empty");
            } else if (Util.isNumber(price) == false) {
                error = true;
                p.setPriceIsNumberError("Price is a number");
            }
            if (quantity.isEmpty()) {
                error = true;
                p.setQuantityIsEmptyError("Quantity cannot be left empty");
            } else if (Util.isNumber(quantity) == false) {
                error = true;
                p.setPriceIsNumberError("Quantity is a number");
            }

            if (error == true) {
                request.setAttribute("INSERT_ERROR", p);
            }
            ProductDTO dto = new ProductDTO(sku, Float.parseFloat(price), Integer.parseInt(quantity), new ProductStatusesDTO(Integer.parseInt(sId), null));
            ProductDAO dao = new ProductDAO();
            dao.updateProduct(dto);

        } catch (NamingException ex) {
            log("UpdateProductBySkuServlet NamingException " + ex.getMessage());
        } catch (NumberFormatException ex) {
            log("UpdateProductBySkuServlet NumberFormatException " + ex.getMessage());

        } catch (NullPointerException ex) {
            log("UpdateProductBySkuServlet NullPointerException " + ex.getMessage());

        } catch (ClassNotFoundException ex) {
            log("UpdateProductBySkuServlet ClassNotFound " + ex.getMessage());
        } catch (SQLException ex) {
            log("UpdateProductBySkuServlet SQLException " + ex.getMessage());
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
