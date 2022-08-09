/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.*;

/**
 *
 * @author Sri Siva Murugan V
 */

@WebServlet(urlPatterns = {"/Owner"})
public class Owner extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     Connection con;
    PreparedStatement pat;
    int row;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        String successMessage="";
        String errorMessage = "";
       try
       {
         String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
//        String cpass = request.getParameter("confirm_password");
        if (Pattern.matches("^[A-Za-z]\\w{5,29}$", uname) == false){
          errorMessage = "Enter a valid name. Must have atleast 6 characters.";
          request.setAttribute("errorMessage", errorMessage);
          request.getRequestDispatcher("/ownerSignUp.jsp").forward(request, response);
        }
        if (pass.length() < 8){
          errorMessage = "Password length must be more than 8 characters";
          request.setAttribute("errorMessage", errorMessage);
          request.getRequestDispatcher("/ownerSignUp.jsp").forward(request, response);
        }
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/rentalapp", "root", "");
         
         pat = con.prepareStatement("insert into owner values(?,?,?)");
         pat.setString(1,uname);
         pat.setString(2,email);
         pat.setString(3, pass);

         row = pat.executeUpdate();
         
         if(row > 0)
         {
             successMessage = "registered successfully please login";
             request.setAttribute("successMessage", successMessage);
             request.getRequestDispatcher("/ownerSignUp.jsp").forward(request, response);
              //out.println("user registered");
         }
        
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
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
