/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.HistoryDAO;
import duylp.daos.UserDAO;
import duylp.dtos.HistoryDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Le Phuoc Duy
 */
@WebServlet(name = "HistoryListController", urlPatterns = {"/HistoryListController"})
public class HistoryListController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(HistoryListController.class);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            String userID = (String) session.getAttribute("USERID");
            HistoryDAO daoH = new HistoryDAO();
            UserDAO dao = new UserDAO();
            boolean status = dao.findByUserID(userID).isStatusPromotion();
            if (status) {
                request.setAttribute("STATUS", "You are currently on the promotion list");
                request.setAttribute("COLOR", "green");  
            } else {
                request.setAttribute("STATUS", "You are not currently on the promotion list");
                request.setAttribute("COLOR", "red");
            }
            List<HistoryDTO> result = daoH.historyList(userID);
            request.setAttribute("HISTORYLIST", result);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            request.getRequestDispatcher("history.jsp").forward(request, response);
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
