/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.UserDAO;
import duylp.dtos.LPDErrorObject;
import duylp.dtos.UserDTO;
import duylp.utils.PasswordEncryption;
import java.io.IOException;
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
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePasswordController"})
public class ChangePasswordController extends HttpServlet {
    
    private static final Logger LOGGER = Logger.getLogger(ChangePasswordController.class);
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "admin.jsp";
    private static final String INVALID = "changePassword.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("txtUserID");
            String oldPassword = request.getParameter("txtOldPassword");
            String newPassword = request.getParameter("txtNewPassword");
            String newConfirm = request.getParameter("txtNewConfirm");
            String oldPasswordEncryption = PasswordEncryption.toHexString(PasswordEncryption.getSHA256(oldPassword));
            LPDErrorObject errorObj = new LPDErrorObject();
            UserDAO dao = new UserDAO();
            String checkOldPassword = dao.findByUserID(userID).getPassword();
            boolean valid = true;
            if (oldPassword.length() == 0) {
                valid = false;
                errorObj.setOldPasswordError("Old password can't be blank");
            } else if (!oldPasswordEncryption.equals(checkOldPassword)) {
                valid = false;
                errorObj.setOldPasswordError("Your old password is not correct");
            }
            if (newPassword.length() == 0) {
                valid = false;
                errorObj.setNewPasswordError("New password can't be blank");
            }
            if (!newConfirm.equals(newPassword)) {
                valid = false;
                errorObj.setNewConfirmError("Confirm must match Password");
            }
            if (valid) {
                url = SUCCESS;
                String passwordEncryption = PasswordEncryption.toHexString(PasswordEncryption.getSHA256(newPassword));
                dao.changePassword(passwordEncryption, userID);
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
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
