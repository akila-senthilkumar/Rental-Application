import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.util.regex.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akila Senthilkumar
 */

@WebServlet("/Homeadd")
@MultipartConfig(maxFileSize = 16177215)

public class Homeadd extends HttpServlet{
    Connection con;
    PreparedStatement pat;
    int row;
    String successMessage="";
    String errorMessage = "";
    public void doPost(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
            rsp.setContentType("text/html");
            PrintWriter out = rsp.getWriter();
           HttpSession session=req.getSession(false);
            String user = (String)session.getAttribute("name");
            String ownername = user;
            String phoneno = req.getParameter("phoneno");
            String villaname = req.getParameter("hname");
            String address = req.getParameter("address");
            String homespec = req.getParameter("hspec");
            String rpm = req.getParameter("rpm");
            
//            if (Pattern.matches("^[1-9]{1}[0-9]{9}$", phoneno) == false){
//                errorMessage = "Enter a valid phone number";
//                req.setAttribute("errorMessage", errorMessage);
//                req.getRequestDispatcher("/RegisterHome.jsp").forward(req, rsp);
//            }
            InputStream inputStream = null;
           
            Part filePart = req.getPart("photo");
                     
            inputStream = filePart.getInputStream();

        try {
             
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rentalapp", "root", "");
            pat = con.prepareStatement("insert into availablehomes(ownername,phoneno,villaname,address,homespec,rpm,imagehouse)values(?,?,?,?,?,?,?)");
            pat.setString(1,ownername);
            pat.setString(2,phoneno);
            pat.setString(3, villaname);
            pat.setString(4,address);
            pat.setString(5,homespec);
            pat.setString(6,rpm);
           
            if(inputStream != null)
            {  
                 pat.setBlob(7, inputStream);
            }
           
            row = pat.executeUpdate();
           
           
            if(row > 0)
            {
                //rsp.sendRedirect("ownerhome.jsp");
                req.getRequestDispatcher("/ownerhome.jsp").forward(req, rsp);
//                out.println("Home added successfully");
//                out.println("<a href='ownerhome.jsp'>Go back!!</a>");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Homeadd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Homeadd.class.getName()).log(Level.SEVERE, null, ex);
        }
 

    }
}

