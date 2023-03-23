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
import quandh.categories.CategoryDAO;
import quandh.categories.CategoryDTO;
import quandh.categories.CategoryInsertError;
import quandh.util.MyAppConstants;
import quandh.util.Util;

/**
 *
 * @author PC_HONGQUAN
 */
@WebServlet(name = "InsertCategoryServlet", urlPatterns = {"/insertcategory"})
public class InsertCategoryServlet extends HttpServlet {


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
        boolean error = false;
        boolean result;
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(MyAppConstants.AdminFeatures.CREATE_CATEGORY_PAGE);
        CategoryInsertError e = new CategoryInsertError();
        try {
            String id = request.getParameter("Id").trim();
            String name = request.getParameter("name").trim();

            if (id.isEmpty()) {
                error = true;
                e.setIdIsEmptyError("ID cannot be left empty !");
            }
            if (name.isEmpty()) {
                error = true;
                e.setCategoryNameIsEmptyError("Name of Category cannot be left empty !");
            }
            if (Util.isNumber(id) == false) {
                error = true;
            }

            CategoryDTO dto = new CategoryDTO(Integer.parseInt(id), name);
            CategoryDAO dao = new CategoryDAO();
            result = dao.createCategory(dto);
            if (result == true) {
                url = siteMaps.getProperty(MyAppConstants.AdminFeatures.MANAGE_PRODUCT_ACTION);
            }

        } catch (NamingException ex) {
            log("InsertCategoryServlet NamingException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("InsertCategoryServlet ClassNotFound " + ex.getMessage());

        } catch (NumberFormatException ex) {
            log("InsertCategoryServlet NumberFormatException " + ex.getMessage());
            e.setIsDigitError("ID of category must is digit");
            request.setAttribute("INSERT_ERROR", e);
        } catch (SQLException ex) {
            log("InsertCategoryServlet SQLException " + ex.getMessage());
            e.setIdIsDuplicatedError("ID is duplicated !");
            request.setAttribute("INSERT_ERROR", e);

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
