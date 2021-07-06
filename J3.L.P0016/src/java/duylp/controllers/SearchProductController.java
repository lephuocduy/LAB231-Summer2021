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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Le Phuoc Duy
 */
@WebServlet(name = "SearchProductController", urlPatterns = {"/SearchProductController"})
public class SearchProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            HttpSession session = request.getSession();
            String roleID = (String)session.getAttribute("ROLEID");
            String search = request.getParameter("txtSearch");
            String index = request.getParameter("index");
            int indexPage = 0;
            if (index == null) {
                indexPage = 1;
            } else {
                indexPage = Integer.parseInt(index);
            }

            ProductDAO daoPro = new ProductDAO();
            List<ProductDTO> resultUS = daoPro.findByLikeProductNameUS(search, indexPage);
            List<ProductDTO> resultLD = daoPro.findByLikeProductNameLD(search, indexPage);
            List<ProductDTO> resultProUS = daoPro.productListUS(indexPage);
            List<ProductDTO> resultProUSE = daoPro.productListUSE(indexPage);
            List<ProductDTO> resultProUSI = daoPro.productListUSI(indexPage);
            List<ProductDTO> resultProUSO = daoPro.productListUSO(indexPage);
            List<ProductDTO> resultProLD = daoPro.productListLD(indexPage);
            List<ProductDTO> resultProLDE = daoPro.productListLDE(indexPage);
            List<ProductDTO> resultProLDI = daoPro.productListLDI(indexPage);
            List<ProductDTO> resultProLDO = daoPro.productListLDO(indexPage);
            int numberPageUS = daoPro.getNumberPageLikeUS(search);
            int numberPageLD = daoPro.getNumberPageLikeLD(search);
            if (roleID.equals("US")) {
                request.setAttribute("INFOUS", resultUS);
                request.setAttribute("PRODUCTLISTUS", resultProUS);
                request.setAttribute("PRODUCTLISTUSE", resultProUSE);
                request.setAttribute("PRODUCTLISTUSI", resultProUSI);
                request.setAttribute("PRODUCTLISTUSO", resultProUSO);
                request.setAttribute("NUMBERPAGEUS", numberPageUS);
            } else {
                request.setAttribute("INFOLD", resultLD);
                request.setAttribute("PRODUCTLISTLD", resultProLD);
                request.setAttribute("PRODUCTLISTLDE", resultProLDE);
                request.setAttribute("PRODUCTLISTLDI", resultProLDI);
                request.setAttribute("PRODUCTLISTLDO", resultProLDO);
                request.setAttribute("NUMBERPAGELD", numberPageLD);
            }
        } catch (Exception e) {
            log("ERROR at SearchProductController: " + e.getMessage());
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
