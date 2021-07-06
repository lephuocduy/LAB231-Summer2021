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
@WebServlet(name = "InsertRoleController", urlPatterns = {"/InsertRoleController"})
public class InsertRoleController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(InsertRoleController.class);
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "admin.jsp";
    private static final String INVALID = "insertRole.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String newRoleID = request.getParameter("txtNewRoleID");
            String newRoleName = request.getParameter("txtNewRoleName");
            LPDErrorObject errorObj = new LPDErrorObject();
            RoleDAO dao = new RoleDAO();
            boolean checkUserID = dao.checkRoleID(newRoleID);
            boolean valid = true;
            if (newRoleID.length() == 0) {
                valid = false;
                errorObj.setNewRoleIDError("Role ID can't be blank");
            } else if (checkUserID == true) {
                valid = false;
                errorObj.setNewRoleIDError("Role ID is existed");
            }
            if (newRoleName.length() == 0) {
                valid = false;
                errorObj.setNewRoleNameError("Role Name can't be blank");
            }
            if (valid) {
                RoleDTO dto = new RoleDTO(newRoleID, newRoleName);
                if (dao.insertRole(dto)) {
                    url = SUCCESS;
                    HttpSession session = request.getSession();
                    List<RoleDTO> resultRoleList = dao.listRole();
                    session.setAttribute("ROLELIST", resultRoleList);
                    UserDAO daoList = new UserDAO();
                    List<UserDTO> resultList = daoList.list();
                    request.setAttribute("LIST", resultList);                    
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
