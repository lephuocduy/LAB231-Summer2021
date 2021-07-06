/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.UserDAO;
import duylp.dtos.LPDErrorObject;
import duylp.dtos.UserDTO;
import duylp.utils.UploadPhoto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Le Phuoc Duy
 */
@MultipartConfig
@WebServlet(name = "UpdateUserController", urlPatterns = {"/UpdateUserController"})
public class UpdateUserController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(UpdateUserController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String newUserID = request.getParameter("txtNewUserID");
            String newUserName = request.getParameter("txtNewUserName");
            String newEmail = request.getParameter("txtNewEmail");
            String newPhoneNumber = request.getParameter("txtNewPhoneNumber");
            String newPhoto = request.getParameter("photo");
            String newRole = request.getParameter("cbxNewRole");
            UploadPhoto uploadPhoto = new UploadPhoto();
            String fileName = uploadPhoto.uploadFile(request);
            LPDErrorObject errorObj = new LPDErrorObject();
            boolean valid = true;
            if (newUserName.length() == 0) {
                valid = false;
                errorObj.setNewUserNameError("User Name can't be blank");
            }
            if (!newEmail.matches("^[\\w]{1,}+@([\\w]{1,}\\.[\\w]{1,}+|[\\w]{1,}\\.[\\w]{1,}\\.[\\w]{1,})$")) {
                valid = false;
                errorObj.setNewEmailError("Email is not in the correct format");
            }
            if (!newPhoneNumber.matches("^[0-9]{10}$")) {
                valid = false;
                errorObj.setNewPhoneNumberError("Phone number is not in the correct format");
            }
            UserDTO dto = null;
            UserDAO dao = new UserDAO();
            if (valid) {
                if (fileName.isEmpty()) {
                    dto = new UserDTO(newUserID, newUserName, newEmail, newPhoneNumber, newPhoto, newRole);
                } else {
                    dto = new UserDTO(newUserID, newUserName, newEmail, newPhoneNumber, fileName, newRole);
                }
                dao.updateUser(dto);
            } else {
                request.setAttribute("INVALID", errorObj);
            }
            List<UserDTO> resultList = dao.list();
            request.setAttribute("LIST", resultList);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
