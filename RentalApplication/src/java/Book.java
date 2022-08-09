
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akila Senthilkumar
 */

@WebServlet("/Book")
public class Book extends HttpServlet{
//    public static Message prepareMessage(Session session,String from,String youremail)
//    {
//        System.out.println("Hello");
//        try
//        {
//           Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(youremail));
//            message.setSubject("yourhome booked successfully through rentals app!!");
//            message.setText("This is test line");
//            return message;
//        } catch(Exception ex){
//                        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        String yourname =req.getParameter("yname");
        String youremail = req.getParameter("yemail");
        String ownername =req.getParameter("oname");
        String ownerphone =req.getParameter("ono");
        String villaname=req.getParameter("vname");
        String address=req.getParameter("addr");
        String homespecification=req.getParameter("ohomespec");
        String rentpermonth=req.getParameter("rpm");
        String totalamount=req.getParameter("totalamount");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalapp","root","");
            PreparedStatement ps = connection.prepareStatement("delete from availablehomes where ownername=? and phoneno=?");
            ps.setString(1, ownername);
            ps.setString(2, ownerphone);
            
            int i = ps.executeUpdate();

        if(i > 0) {
            ps = connection.prepareStatement("insert into bookedhomes(yourname,youremail,ownername,phoneno,villaname,Address,homespec,rpm,total)VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1,yourname);
            ps.setString(2,youremail);
            ps.setString(3,ownername);
            ps.setString(4,ownerphone);
            ps.setString(5,villaname);
            ps.setString(6,address);
            ps.setString(7,homespecification);
            ps.setString(8,rentpermonth);
            ps.setString(9,totalamount);
            int row = ps.executeUpdate();
            if(row > 0)
            {
                  
              String to = youremail;
              String subject = "your home booked successfully using Rentals";
              String msg = "Thank you for using our service.\n\nWe are extremely pleased to inform you that your home has been booked successfully. \n\nReference details: \nThe owner's name is "+ownername+"\nAddress is "+address+"\nThe Total amount to be paid is for a year is "+totalamount+"\nHouse specifications is "+homespecification+".\n\nWe appreciate your support.\n\nFor any enquiries, call "+ownerphone+".";
              Mailer.send(to, subject, msg);  
              out.println("<center>");
              out.println("We have sent your home details to your email ID for reference");
              out.println("<br>");
              out.println("your home booked successfully...");
              out.println("<br>");
              out.println("<td> <a href='yourhome' />view your Home</td>");
              out.println("</center>");
            }
        }
        
        


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
