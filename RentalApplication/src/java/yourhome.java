
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akila Senthilkumar
 */

@WebServlet("/yourhome")
public class yourhome extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
         rsp.setContentType("text/html");
         PrintWriter out = rsp.getWriter();
         
         HttpSession session=req.getSession(false);
        String user = (String)session.getAttribute("email");
          out.println("<style>");    
                 out.println(".Nav {");
                 out.println("top: 170px;");
                 out.println("left:0;");
                 out.println("width:230px;");
                 out.println("background-color: lightblue;");
                 out.println("position:fixed;");
                 out.println("height:100%;");
                 out.println("font-size:25px;");
                 out.println("padding:20px;");
                 out.println("margin-bottom:4px;box-shadow: 0 8px 16px -6px black;");
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
                 out.println(".yourhome {");
                   
                    out.println("margin-left:300px;");
                  out.println("}");
                   out.println("a{");
                  out.println("text-decoration:none;");
                  out.print("color: #000;");
                 out.println("}");
                 out.println("a:hover{");
                  out.println("text-decoration:underline;");
                 out.println("}");
                 out.println(".yourhome table{");
                   
                   out.println("margin-left:150px");
                 out.println("}");
                  out.println(".yourhome td{");
                   out.println("padding-top:12px");
                   out.println("padding-bottom:12px");
                   out.println("text-align:left;");
                   out.println("background-color:rgba(0, 128, 0, 0.3);");
                   out.println("color:black;");
                   out.println("border: 1px solid #ddd;");
                   out.println("  padding: 8px;");
                 out.println("}");
                 
                 out.println(".jumbotron, .jumbotron-fluid{");
                    
                    out.println("padding-top: 10px !important;");
                    out.println("padding-bottom: 10px !important;");
//                    out.println("position: fixed;");
                    out.println("width: 100%;");
                    out.println("background-color: #FCE181;");
                    out.println("color: #000;");
                    out.println("box-shadow: 0 8px 16px -6px black;");
                out.println("}");
          out.println("</style>");
          out.println("<div class=\"sticky-top\">");
          out.println("<div class='jumbotron jumbotron-fluid'>");
          out.println("<h1 class='display-6 offset-1'>");
            out.println("Available Homes");
            out.println("</h1>");
            out.println("<div class='welcome-note mt-3 offset-1'>");
            out.print("Welcome ");
             out.println(user);
             out.println("<br>");
             out.println("<br>");
             out.println("<br>");
             out.println("</div>");
             out.println("</div>");
             out.println("</div>");
          out.println("<div class='Nav'>");
          out.println("Menu");
             out.println("<br>");
             out.println("<br>");
             out.println("<br>");
//             out.println(user);
//             out.println("<br>");
//             out.println("<br>");
             out.println("<a href='home.jsp'>Home</a>");
             out.println("<br>");
             out.println("<br>");
             out.println("<a href='yourhome'><b>Your Home</b></a>");
             out.println("<br>");
             out.println("<br>");
             out.println("<a href='Logout'>Logout</a>");
          out.println("</div>");
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalapp","root","");
            String sql = "SELECT * FROM bookedhomes where youremail=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet result = statement.executeQuery();
            
            while(result.next())
            {
                out.println("<br/><br/>");
                out.println("<div class='yourhome'>");
                out.println("<table border='2'>");
                out.println("<tr>");
                 out.println("<td>your Name</td>");
                 out.println("<td>"+ result.getString("yourname")+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                 out.println("<td>your Email</td>");
                 out.println("<td>"+ result.getString("youremail")+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                 out.println("<td>Owner Name</td>");
                 out.println("<td>"+ result.getString("ownername")+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                 out.println("<td>Owner phonenumber</td>");
                 out.println("<td>"+ result.getString("phoneno")+"</td>");
                out.println("</tr>");
                 out.println("<tr>");
                 out.println("<td>Villaname</td>");
                 out.println("<td>"+ result.getString("villaname")+"</td>");
                out.println("</tr>");
                 out.println("<tr>");
                 out.println("<td>Address</td>");
                 out.println("<td>"+ result.getString("Address")+"</td>");
                out.println("</tr>");
                 out.println("<tr>");
                 out.println("<td>Homespecification</td>");
                 out.println("<td>"+ result.getString("homespec")+"</td>");
                out.println("</tr>");
                 out.println("<tr>");
                 out.println("<td>Rent Per Month</td>");
                 out.println("<td>"+ result.getString("rpm")+"</td>");
                out.println("</tr>");
                 out.println("<tr>");
                 out.println("<td>Total amount paid</td>");
                 out.println("<td>"+ result.getString("total")+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                 out.println("<td>To Delete this home</td>");
                out.println("<td>"+ "<button><a href='DeleteBookedhome?id="+ result.getString("villaname") +"&owner="+ result.getString("ownername") +"'> Delete Home</a>"+ "</button></td>");
//                 out.println("<td>"+ result.getString("total")+"</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</div>");
                out.println("<br>");
            }
            
           

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(yourhome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(yourhome.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
