/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.ProductDAO;
import duylp.daos.RequestDAO;
import duylp.daos.RequestDetailDAO;
import duylp.dtos.RequestDTO;
import duylp.dtos.RequestDetailDTO;
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
@WebServlet(name = "UpdateRequestController", urlPatterns = {"/UpdateRequestController"})
public class UpdateRequestController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            String cbxStatus = request.getParameter("cbxStatus");
            String txtRequestID = request.getParameter("txtRequestID");
            int requestID = Integer.parseInt(txtRequestID);
            RequestDAO dao = new RequestDAO();
            
            if (cbxStatus.equals("Delete")) {
                RequestDetailDAO daoD = new RequestDetailDAO();
                List<RequestDetailDTO> dtoD = daoD.requestQuanlityList(requestID);
                ProductDAO daoP = new ProductDAO();             
                if (dao.deleteRequest(requestID)) {
                    for (RequestDetailDTO x : dtoD) {
                        daoP.updateQuanlity(x.getQuantity(), x.getProductID());
                    }
                }
            } else {
                dao.updateRequest(cbxStatus, requestID);
            }
            
            List<RequestDTO> resultReq = dao.requestList(1);
            int numberPageReq = dao.getNumberPageRequest();
            request.setAttribute("REQUESTLIST", resultReq);
            request.setAttribute("NUMBERPAGEREQ", numberPageReq);
        } catch (Exception e) {
            log("ERROR at UpdateRequestController: " + e.getMessage());
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
