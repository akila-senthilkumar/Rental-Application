
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

@WebServlet("/Bookhome")
public class Bookhome extends HttpServlet{
    
    public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();  
        
        HttpSession session=req.getSession(false);
        String user = (String)session.getAttribute("email");
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
             out.println(user);
             out.println("<br>");
             out.println("<br>");
             out.println("<a href='home.jsp'>Home</a>");
             out.println("<br>");
             out.println("<br>");
             out.println("<a href='yourhome'>your Home</a>");
             out.println("<br>");
             out.println("<br>");
             out.println("<a href='Logout'>Logout</a>");
          out.println("</div>");
        
        String villaname = req.getParameter("id");
        String oname = req.getParameter("owner");
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
            String sql = "SELECT * FROM availablehomes WHERE villaname=? and ownername =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, villaname);
            statement.setString(2, oname);
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                String pricepermonth = result.getString("rpm");
                int price = Integer.parseInt(pricepermonth);
                int totalprice = price*12;
                String totalamount = String.valueOf(totalprice);
                
              out.println("<form action='Book'>");
               out.println("<tr>");
                  out.println("<td>Enter your Name</td>");
                  out.println("<td> <input type='text' name='yname' value='' required/> </td>");
                out.println("</tr>");
                 out.println("<tr>");
                  out.println("<td>your email</td>");
                  out.println("<td> <input type='text' name='yemail' value = '"+ user +"' readonly/> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Owner Name</td>");
                  out.println("<td> <input type='text' name='oname' value = '"+ result.getString("ownername") +"' readonly/> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Phone Number</td>");
                  out.println("<td> <input type='tel' pattern='[1-9]{1}[0-9]{9}' name='ono' value = '"+ result.getString("phoneno") +"' readonly/> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Villa Name</td>");
                  out.println("<td> <input type='text' name='vname' value = '"+ result.getString("villaname") +"' readonly/> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Address</td>");
                  out.println("<td> <input type='text' name='addr' value = '"+ result.getString("address") +"' readonly/> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Home Specification</td>");
                  out.println("<td> <input type='text' name='ohomespec' value = '"+ result.getString("homespec") +"' readonly/> </td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>Price per month</td>");
                  out.println("<td> <input type='number' name='rpm' value = '"+ result.getString("rpm") +"' readonly/> </td>");
                out.println("</tr>");
                
                out.println("<tr>");
                  out.println("<td>Total amount to be paid</td>");
                  out.println("<td> <input type='number' name='totalamount' value = '"+ totalamount +"' readonly/> </td>");
                out.println("</tr>");
                
                 out.println("<tr>");
                  out.println("<td> <a href='home.jsp' />Back</td>");
                  out.println("<td> <input type='submit'  value = 'Bookyourhome' /></td>");
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
}
