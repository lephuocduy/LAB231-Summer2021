/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.RoleDAO;
import duylp.daos.UserDAO;
import duylp.dtos.LPDErrorObject;
import duylp.dtos.RoleDTO;
import duylp.dtos.UserDTO;
import duylp.utils.PasswordEncryption;
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private static final String ADMIN = "admin.jsp";
    private static final String USER = "user.jsp";
    private static final String INVALID = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = INVALID;
        try {
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            LPDErrorObject errorObj = new LPDErrorObject();
            boolean valid = true;
            if (userID.length() == 0) {
                valid = false;
                errorObj.setUserIDError("UserID can't be blank");
            }
            if (password.length() == 0) {
                valid = false;
                errorObj.setPasswordError("Password can't be blank");
            }
            if (valid) {
                String passwordEncryption = PasswordEncryption.toHexString(PasswordEncryption.getSHA256(password));
                UserDAO dao = new UserDAO();
                String result = dao.checkLogin(userID, passwordEncryption);
                UserDTO info = dao.findByUserID(userID);
                HttpSession session = request.getSession();
                session.setAttribute("LOGIN", result);
                session.setAttribute("USERID", userID);
                session.setAttribute("USERNAME", info.getUserName());
                List<UserDTO> resultList = dao.list();

                RoleDAO daoRole = new RoleDAO();
                List<RoleDTO> resultRoleList = daoRole.listRole();
                if (result.equals("inactive")) {
                    request.setAttribute("ERROR", "Your account is inactive");
                } else if (result.equals("failed")) {
                    request.setAttribute("ERROR", "User ID or password is incorrect");
                } else if (result.equals("AD")) {
                    url = ADMIN;
                    request.setAttribute("LIST", resultList);
                    session.setAttribute("ROLELIST", resultRoleList);
                } else {
                    url = USER;
                    session.setAttribute("PHOTO", info.getPhoto());
                    session.setAttribute("EMAIL", info.getEmail());
                    session.setAttribute("PHONENUMBER", info.getPhoneNumber());
                    boolean statusPromotion = info.isStatusPromotion();
                    int rank = info.getRank();
                    if (statusPromotion) {
                        session.setAttribute("STATUS", "You are currently on the promotion list with rank is: " + rank);
                        session.setAttribute("COLOR", "green");
                    } else {
                        session.setAttribute("STATUS", "You are not currently on the promotion list");
                        session.setAttribute("COLOR", "red");
                    }
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
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
