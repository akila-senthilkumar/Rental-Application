/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.*;
 
/**
 *
 * @author Damodharan R
 */

@WebServlet(urlPatterns = {"/Updatehome"})
public class Updatehome extends HttpServlet {

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();  
        
        HttpSession session=request.getSession(false);
        String user = (String)session.getAttribute("email");
        String uname = (String)session.getAttribute("name");
          out.println("<style>");    
                 out.println(".Nav {");
                 out.println("top:0;");
                 out.println("left:0;");
                 out.println("width:230px;");
                 out.println("background-color: lightblue;");
                 out.println("position:fixed;");
                 out.println("height:100%;");
                 out.println("font-size:25px;");
                 out.println("padding:20px;");
                 out.println("margin-bottom:4px;");
                 out.println("}");
                 out.println(".tablebook th, .tablebook td{");
                   out.println("padding-top:12px");
                   out.println("padding-bottom:12px");
                   out.println("text-align:left;");
                   out.println("background-color:rgba(0, 128, 0, 0.3);");
                   out.println("color:black;");
                   out.println("border: 1px solid #ddd;");
                   out.println("  padding: 8px;");
                 out.println("}");
                 out.println(".tablebook {");
                   out.println("margin-top:30px;");
                 out.println("}");
                 out.println(".tablebook input[type=submit] {");
                    out.println("cursor:pointer;");
                 out.println("}");
                 out.println("a{");
                  out.println("text-decoration:none;");
                 out.println("}");
                 out.println("a:hover{");
                  out.println("text-decoration:underline;");
                 out.println("}");
          out.println("</style>");  
          out.println("<div class='Nav'>");
          out.println("Welcome");
             out.println("<br>");
             out.println("<br>");
             out.println("<br>");
             out.println(uname);
             out.println("<br>");
             out.println("<br>");
             out.println("<a href='ownerhome.jsp'>Home</a>");
             out.println("<br>");
             out.println("<br>");
             out.println("<a href='Registerhome.jsp'>Add Home</a>");
             out.println("<br>");
             out.println("<br>");
//             out.println("<a href='Deletehome.jsp'>Delete Home</a>");
//             out.println("<br>");
//             out.println("<br>");
             out.println("<a href='Logout'>Logout</a>");
          out.println("</div>");
        
        String villaName = request.getParameter("id");
        out.println("<div class='tablebook'>");
        out.println("<center>");
        out.println("<table border='2'>");
        out.println("<tr>");
          out.println("<th> Details </th>");
          out.println("<th>Information about home</th>");
        out.println("</tr>");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalapp","root","");
            String sql = "SELECT * FROM availablehomes WHERE villaname=? and ownername=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, villaName);
            statement.setString(2, uname);
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                String pricepermonth = result.getString("rpm");
//                int price = Integer.parseInt(pricepermonth);
//                int totalprice = price*12;
//                String totalamount = String.valueOf(totalprice);
                
              out.println("<form action='Update'>");
               out.println("<tr>");
                  out.println("<td>Owner Name</td>");
                  out.println("<td> <input type='text' name='oname' value='"+uname+"' readonly/> </td>");
                out.println("</tr>");
//                 out.println("<tr>");
//                  out.println("<td>your email</td>");
//                  out.println("<td> <input type='text' name='yemail' value = '"+ user +"' readonly/> </td>");
//                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Phone Number</td>");
                  out.println("<td> <input type='tel' pattern='[1-9]{1}[0-9]{9}' name='ono' value = '"+ result.getString("phoneno") +"' /> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Villa Name</td>");
                  out.println("<td> <input type='text' name='vname' value = '"+ result.getString("villaname") +"' readonly/> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Address</td>");
                  out.println("<td> <input type='text' name='addr' value = '"+ result.getString("address") +"' /> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Home Specification</td>");
                  out.println("<td> <input type='text' name='ohomespec' value = '"+ result.getString("homespec") +"' /> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Price per month</td>");
                  out.println("<td> <input type='number' name='rpm' value = '"+ result.getString("rpm") +"' /> </td>");
                out.println("</tr>");
                
                 out.println("<tr>");
                  out.println("<td> <a href='ownerhome.jsp' />Back</td>");
                  out.println("<td> <input type='submit'  value = 'Update home' /></td>");
                out.println("</tr>");
                
               out.println("</form>");
               out.println("</div>");
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bookhome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Bookhome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        out.println("</center>");
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
