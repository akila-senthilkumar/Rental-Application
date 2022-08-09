
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
 * @author Sri Siva Murugan V
 */

@WebServlet("/Login")
public class Login extends HttpServlet{
    
   public void doGet(HttpServletRequest req,HttpServletResponse rsp) throws IOException,ServletException{
       rsp.setContentType("text/html");
       PrintWriter out = rsp.getWriter();
       try {
           
           String email = req.getParameter("username");
           String password = req.getParameter("password");
           
           Class.forName("com.mysql.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalapp","root","");
           String sql = "SELECT * FROM users WHERE email = ? and password = ?";
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1, email);
           statement.setString(2, password);
           ResultSet result = statement.executeQuery();
           while(result.next())
           {
               HttpSession session = req.getSession();
               session.setAttribute("email",result.getString("email"));
               rsp.sendRedirect("home.jsp");
           }
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
