/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.ProductDAO;
import duylp.daos.RequestDAO;
import duylp.daos.UserDAO;
import duylp.dtos.LPDErrorObject;
import duylp.dtos.ProductDTO;
import duylp.dtos.RequestDTO;
import duylp.dtos.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import recaptcha.VerifyUtils;

/**
 *
 * @author Le Phuoc Duy
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ADMIN = "admin.jsp";
    private static final String USER = "user.jsp";
    private static final String INVALID = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = INVALID;
        try {
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            LPDErrorObject errorObj = new LPDErrorObject();
            boolean valid = true;
            if (!email.matches("^[\\w]{1,}+@([\\w]{1,}\\.[\\w]{1,}+|[\\w]{1,}\\.[\\w]{1,}\\.[\\w]{1,})$")) {
                valid = false;
                errorObj.setEmailError("Email is not in the correct format");
            }
            if (password.length() == 0) {
                errorObj.setPasswordError("Password can't be blank");
                valid = false;
            }
            if (valid) {
                valid = VerifyUtils.verify(gRecaptchaResponse);
                UserDAO dao = new UserDAO();
                UserDTO result = dao.checkLogin(email, password);
                if (!valid) {
                    errorObj.setCaptchaError("Captcha invalid!");
                    url = INVALID;
                    request.setAttribute("INVALID", errorObj);
                } else {
                    if (result == null) {
                        request.setAttribute("ERROR", "Invalid UserID or Password");
                        request.setAttribute("COLOR", "alert-danger");
                    } else {
                        HttpSession session = request.getSession();
                        session.setAttribute("FULLNAME", result.getFullname());
                        session.setAttribute("ROLEID", result.getRoleID());
                        session.setAttribute("EMAIL", email);
                        ProductDAO daoPro = new ProductDAO();
                        List<ProductDTO> resultProUS = daoPro.productListUS(1);
                        List<ProductDTO> resultProUSE = daoPro.productListUSE(1);
                        List<ProductDTO> resultProUSI = daoPro.productListUSI(1);
                        List<ProductDTO> resultProUSO = daoPro.productListUSO(1);
                        List<ProductDTO> resultProLD = daoPro.productListLD(1);
                        List<ProductDTO> resultProLDE = daoPro.productListLDE(1);
                        List<ProductDTO> resultProLDI = daoPro.productListLDI(1);
                        List<ProductDTO> resultProLDO = daoPro.productListLDO(1);
                        int numberPageUS = daoPro.getNumberPageUS();
                        int numberPageLD = daoPro.getNumberPageLD();
                        
                        RequestDAO daoReq = new RequestDAO();
                        List<RequestDTO> resultReq = daoReq.requestList(1);
                        int numberPageReq = daoReq.getNumberPageRequest();
                        if (result.getRoleID().equals("AD") && result.getStatusUserID().equals("Active")) {
                            request.setAttribute("REQUESTLIST", resultReq);
                            request.setAttribute("NUMBERPAGEREQ", numberPageReq);
                            url = ADMIN;
                        } else if (result.getRoleID().equals("US") && result.getStatusUserID().equals("Active")) {
                            request.setAttribute("PRODUCTLISTUS", resultProUS);
                            request.setAttribute("PRODUCTLISTUSE", resultProUSE);
                            request.setAttribute("PRODUCTLISTUSI", resultProUSI);
                            request.setAttribute("PRODUCTLISTUSO", resultProUSO);
                            request.setAttribute("NUMBERPAGEUS", numberPageUS);
                            url = USER;
                        } else if (result.getRoleID().equals("LD") && result.getStatusUserID().equals("Active")) {
                            request.setAttribute("PRODUCTLISTLD", resultProLD);
                            request.setAttribute("PRODUCTLISTLDE", resultProLDE);
                            request.setAttribute("PRODUCTLISTLDI", resultProLDI);
                            request.setAttribute("PRODUCTLISTLDO", resultProLDO);
                            request.setAttribute("NUMBERPAGELD", numberPageLD);
                            url = USER;
                        } else {
                            request.setAttribute("ERROR", "You role is invalid");
                            request.setAttribute("COLOR", "alert-danger");
                        }
                    }
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
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
