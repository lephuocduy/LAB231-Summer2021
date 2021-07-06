/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.controllers;

import duylp.daos.RequestDAO;
import duylp.dtos.ListRequestDTO;
import duylp.dtos.RequestDTO;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
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
@WebServlet(name = "BookingController", urlPatterns = {"/BookingController"})
public class BookingController extends HttpServlet {

    private static final String ERROR = "viewBooking.jsp";
    private static final String SUCCESS = "sendRequestSuccess.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String email = (String)session.getAttribute("EMAIL");
            String txtQuantity = (String)session.getAttribute("QUANTITY");
            
            String bookingUntil = request.getParameter("bookingUntil");
            String txtQuantityRequest = request.getParameter("txtQuantityRequest");
            int quantity = Integer.parseInt(txtQuantity);
            int quantityRequest = Integer.parseInt(txtQuantityRequest);
            ListRequestDTO list = (ListRequestDTO) session.getAttribute("list");
            int requestID = utils.RamdomRequestID.randomInt(0, 9999);
            
            RequestDTO dto = new RequestDTO(requestID, email, "New", new Timestamp(System.currentTimeMillis()), Date.valueOf(bookingUntil));
            dto.getListProduct().addAll(list.getList().values());
            if (!list.getList().values().isEmpty()) {
                if (quantityRequest <= quantity) {
                    RequestDAO dao = new RequestDAO();
                    if (dao.inserRequest(dto)) {
                        url = SUCCESS;
                        session.removeAttribute("list");
                    }
                }else {
                    String requestError = "Quantity is not enough";
                    request.setAttribute("requestError", requestError);
                }
            } 
        } catch (Exception e) {
            log("ERROR at BookingController: " + e.getMessage());
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
