/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.admincontroller;

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
import quandh.categories.CategoryDTO;
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
@WebServlet(name = "InsertProductServlet", urlPatterns = {"/insertproduct"})
public class InsertProductServlet extends HttpServlet {


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
        String url = siteMaps.getProperty(MyAppConstants.AdminFeatures.LOAD_CREATE_PRODUCT_ACTION);
        boolean error = false;
        boolean result = false;
        ProductInsertError p = new ProductInsertError();
        try {
            String sku = request.getParameter("sku").trim();
            String pName = request.getParameter("pName").trim();
            String image = request.getParameter("image").trim();
            String price = request.getParameter("price").trim();
            String quantity = request.getParameter("quantity").trim();
            String description = request.getParameter("description").trim();
            String cId = request.getParameter("cId").trim();
            String sId = request.getParameter("sId").trim();

            if (sku.isEmpty()) {
                error = true;
                p.setSkuIsEmptyError("SKU cannot be left empty");
            }
            if (pName.isEmpty()) {
                error = true;
                p.setProductNameIsEmptyError("Product name cannot be left empty");
            }
            if (image.isEmpty()) {
                error = true;
                p.setImageIsEmptyError("Product name cannot be left empty");
            }
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
            if (description.isEmpty()) {
                error = true;
                p.setDescriptionIsEmptyError("Description cannot be left empty");
            }

            if (error == true) {
                request.setAttribute("INSERT_ERROR", p);
            }
            ProductDTO dto = new ProductDTO(sku, pName, image, Float.parseFloat(price),
                    Integer.parseInt(quantity), description, new CategoryDTO(Integer.parseInt(cId), null),
                    new ProductStatusesDTO(Integer.parseInt(sId), null), false);
            ProductDAO dao = new ProductDAO();
            result = dao.createProduct(dto);
            if (result) {
                url = siteMaps.getProperty(MyAppConstants.AdminFeatures.MANAGE_PRODUCT_ACTION);
            }
        } catch (ClassNotFoundException ex) {
            log("InsertProductServlet ClassNotFound " + ex.getMessage());
        } catch (NamingException ex) {
            log("InsertProductServlet NamingException " + ex.getMessage());
        } catch (NumberFormatException ex) {
            log("InsertProductServlet NumberFormatException " + ex.getMessage());
        } catch (SQLException ex) {
            log("InsertProductServlet SQLException " + ex.getMessage());
            p.setSkuIsExistError("SKU is dupplicated");
            request.setAttribute("INSERT_ERROR", p);

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
