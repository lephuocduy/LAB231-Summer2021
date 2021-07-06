/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.UserDAO;
import duylp.dtos.LPDErrorObject;
import duylp.dtos.UserDTO;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
@WebServlet(name = "CreateUserController", urlPatterns = {"/CreateUserController"})
public class CreateUserController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "sendEmail.jsp";
    private static final String INVALID = "createUser.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = ERROR;
        try {
            String newEmail = request.getParameter("txtNewEmail");
            String newFullname = request.getParameter("txtNewFullname");
            String newPassword = request.getParameter("txtNewPassword");
            String newConfirm = request.getParameter("txtNewConfirm");
            String newPhoneNumber = request.getParameter("txtNewPhoneNumber");
            String newAddress = request.getParameter("txtNewAddress");
            LPDErrorObject errorObj = new LPDErrorObject();
            boolean valid = true;
            if (!newEmail.matches("^[\\w]{1,}+@([\\w]{1,}\\.[\\w]{1,}+|[\\w]{1,}\\.[\\w]{1,}\\.[\\w]{1,})$")) {
                valid = false;
                errorObj.setNewEmailError("Email is not in the correct format");
            }
            if (newFullname.length() == 0) {
                valid = false;
                errorObj.setNewFullnameError("Full Name can't be blank");
            }
            if (newPassword.length() == 0) {
                valid = false;
                errorObj.setNewPasswordError("Password can't be blank");
            }
            if (!newConfirm.equals(newPassword)) {
                valid = false;
                errorObj.setNewConfirmError("Confirm must match Password");
            }
            if (!newPhoneNumber.matches("^[0-9]{10}$")) {
                valid = false;
                errorObj.setNewPhoneNumberError("Phone number is not in the correct format");
            }
            if (newAddress.length() == 0) {
                valid = false;
                errorObj.setNewAddressError("Address can't be blank");
            }
            UserDTO dto = new UserDTO(newEmail, newFullname, newPassword, newPhoneNumber, newAddress, "US", "New", Date.valueOf(LocalDate.now()) );
            if (valid) {
                UserDAO dao = new UserDAO();
                if (dao.insertUser(dto)) {
                    url = SUCCESS;
                    HttpSession session = request.getSession();
                    session.setAttribute("NEWEMAIL", newEmail);
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at CreateUserController: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                url = INVALID;
                LPDErrorObject errorObj = new LPDErrorObject();
                errorObj.setNewEmailError("Email is existed");
                request.setAttribute("INVALID", errorObj);
            }
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
