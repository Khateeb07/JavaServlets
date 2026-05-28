/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package httpSessionObject;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author khateeb
 */
public class HttpSession1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fn=request.getParameter("fname");
            String ln=request.getParameter("lname");
            HttpSession session=request.getSession(true);
            session.setAttribute("fname", fn);
            session.setAttribute("lname", ln);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Session1</title>");
            out.println("<link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container-fluid\">");
            out.println("<div class=\"h1 text-center my-3\">Registration Form</div>");
            out.println("<form action=\"ck2\" method=\"POST\" class=\"row justify-content-center\">");
            out.println("<div class=\"col-md-7 my-2\">");
            out.println("<label for=\"age\">Age:</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"age\" placeholder=\"Enter your age\" name=\"age\"/></div>");
            out.println("<div class=\"col-md-7 my-2\">");
            out.println("<label for=\"college\">College:</label>");
            out.println("<input type=\"text\" class=\"form-control form-label\" id=\"college\" placeholder=\"Enter your college\" name=\"college\"/></div>");
            out.println("<input type=\"submit\" value=\"Register\" class=\"btn btn-primary col-md-7 my-3\"/>");
            out.println("</form></div>");
            out.println("</body>");
            out.println("</html>");
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
