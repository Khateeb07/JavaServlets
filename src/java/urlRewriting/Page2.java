/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package urlRewriting;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author khateeb
 */
public class Page2 extends HttpServlet {

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
            String id=request.getParameter("uid");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Session1</title>");
            out.println("<link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container-fluid\">");
            DAO md=new DAO();
            String driver="com.mysql.cj.jdbc.Driver";
            try {
                Connection con=md.toConnect(driver);
                PreparedStatement pstm=con.prepareStatement("SELECT firstname, lastname, age FROM users WHERE(uid=?);");
                pstm.setString(1, id);
                ResultSet rs=md.toFetch(pstm);
                if(rs.next()) {
                    String fn=rs.getString("firstname");
                    String ln=rs.getString("lastname");
                    String age=rs.getString("age");
                    out.println("<div class=\"h1\">User Details</div>");
                    out.println("<div class=\"card\" style=\"width: 18rem;\">");
                        out.println("<div class=\"card-body\">");
                            out.println("<h5 class='card-text'>First name: "+fn+"</h5>");
                            out.println("<h5 class='card-text'>Last name: "+ln+"</h5>");
                            out.println("<h5 class='card-text'>Age: "+age+"</h5>");
                        out.println("</div></div>");
                }
                md.toClose();
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } catch(ClassNotFoundException | SQLException e) {
                out.println("<h3>Exception occurred: "+e.getMessage()+"</h3>");
            }
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
