/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.ProductDAO;
import duylp.dtos.ProductDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Le Phuoc Duy
 */
@WebServlet(name = "LoadProduct", urlPatterns = {"/LoadProduct"})
public class LoadProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ProductDAO daoPro = new ProductDAO();
            List<ProductDTO> resultProUS = daoPro.productListUS(1);
            List<ProductDTO> resultProUSE = daoPro.productListUSE(1);
            List<ProductDTO> resultProUSI = daoPro.productListUSI(1);
            List<ProductDTO> resultProUSO = daoPro.productListUSO(1);
            int numberPageUS = daoPro.getNumberPageUS();
            
            request.setAttribute("PRODUCTLISTUS", resultProUS);
            request.setAttribute("PRODUCTLISTUSE", resultProUSE);
            request.setAttribute("PRODUCTLISTUSI", resultProUSI);
            request.setAttribute("PRODUCTLISTUSO", resultProUSO);
            request.setAttribute("NUMBERPAGEUS", numberPageUS);

        } catch (Exception e) {
            log("ERROR at LoadProduct: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("user.jsp").forward(request, response);
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
