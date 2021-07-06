/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.HistoryDAO;
import duylp.daos.UserDAO;
import duylp.dtos.HistoryDTO;
import duylp.dtos.UserDTO;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Le Phuoc Duy
 */
@WebServlet(name = "AddPromotionController", urlPatterns = {"/AddPromotionController"})
public class AddPromotionController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AddPromotionController.class);
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "admin.jsp";
    private static final int RANK = 5;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String newUserID = request.getParameter("txtNewUserID");
            UserDAO dao = new UserDAO();
            HistoryDAO daoH = new HistoryDAO();
            boolean checkStatus = dao.findByUserID(newUserID).isStatusPromotion();
            if (checkStatus == true) {
                request.setAttribute("ERROR", "User already exists");
                url = SUCCESS;
            } else {
                Timestamp date = new Timestamp(System.currentTimeMillis());
                HistoryDTO dtoH = new HistoryDTO(date, RANK, newUserID);
                if (dao.addPromotion(date, RANK, newUserID) && daoH.insertHistory(dtoH) ) {
                    url = SUCCESS;
                } else {
                    url = ERROR;
                    request.setAttribute("ERROR", "Add Promotion Failed");
                }
            }
            List<UserDTO> resultList = dao.list();
            request.setAttribute("LIST", resultList);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
