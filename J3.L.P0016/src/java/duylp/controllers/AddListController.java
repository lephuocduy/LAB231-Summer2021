/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.dtos.ListRequestDTO;
import duylp.dtos.ProductDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Le Phuoc Duy
 */
@WebServlet(name = "AddListController", urlPatterns = {"/AddListController"})
public class AddListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            String name = (String)session.getAttribute("FULLNAME");
            ListRequestDTO list = (ListRequestDTO) session.getAttribute("list");
            if (list == null && name == null) {
                list = new ListRequestDTO();
            } else if (list == null) {
                list = new ListRequestDTO(name);
            }
            String productID = request.getParameter("txtProductID");
            String productName = request.getParameter("txtProductName");
            String quantityRequest = request.getParameter("txtQuantityRequest");
            String quantity = request.getParameter("txtQuantity");
            String image = request.getParameter("txtImage");
            String color = request.getParameter("txtColor");
            ProductDTO dto = new ProductDTO(productID, productName, image, color, Integer.parseInt(quantityRequest));
            
            list.addList(dto);
            session.setAttribute("list", list);
            session.setAttribute("QUANTITY", quantity);
        } catch (Exception e) {
            log("ERROR at AddListController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("SearchProductController").forward(request, response);
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
