<%-- 
    Document   : ownerhome
    Created on : Jan 18, 2022, 10:02:55 AM
    Author     : Damodharan R
--%>

<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Blob"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>House Rentals</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <style><%@include file="/WEB-INF/resources/css/style1.css"%></style>
        <style>
            
            .Nav{
                top: 150px;
                left: 0;
                width: 230px;
                background-color: lightblue;
                position: fixed;
                height:100%;
                font-size: 25px;
                padding: 20px;
                margin-bottom: 4px;
            }
            .tablehouse{
                margin-top: 30px;
                margin-left: 300px;
            }
            .tablehouse h1{
                text-align: center;
                margin-left: 25px;
                margin-right: 25px;
                font-size: 25px;
            }
            .tablehouse table{
                margin-left: 140px;
            }
            a{
                text-decoration: none;
                color: #000;
            }
            a:hover{
                text-decoration: underline;
            }
            .jumbotron, .jumbotron-fluid
            {
                padding: 10px;
                margin: 0;
            }
        </style>
    </head>
    <body>
        <div class="jumbotron jumbotron-fluid">
            <h1 class="display-6 offset-1">Owner Homes</h1>
            <div class="welcome-note mt-3 offset-1">
            <%
            
//             String n=(String)session.getAttribute("email");
             String uname =(String)session.getAttribute("name");
             out.print("Welcome ");
             
             out.println(uname);
             out.println("<br>");
             out.println("<br>");
        %>
            
        </div></div>
        <div class="Nav">
            <br/><!-- comment -->
            <br/>
            <h2>Menu</h2><br/>
            <a href="ownerhome.jsp"><b>Home</b></a>
        <br><br>
        <a href="Registerhome.jsp">Add Home</a>
        <br><br>
        <a href="Logout">Logout</a>
        </div>
        <div class="tablehouse mt-5">
        <%
             Blob image = null;
            Connection con = null;
             byte[] imgData = null ;
            Statement stmt = null;
            ResultSet rs = null;
            
            
                  

                try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalapp","root","");
//                String q1 = "select * from availablehomes where ownername=?";
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from availablehomes where ownername=\'"+uname+"\'");
                
                out.println("<table border='2'>");
                out.println("<tr>");
                out.println("<th>Owner name</th>");
                out.println("<th>Phone no</th>");
                out.println("<th>Address</th>");
                out.println("<th>Villa Name</th>");
                out.println("<th>Home Specification</th>");
                out.println("<th>Rent Per Month</th>");
                out.println("<th>Image</th>");
                out.println("<th>Update</th>");
                out.println("<th>Delete</th>");
                out.println("</tr>");
               // out.println("<th>picture</th>");
                while(rs.next()) {
                    
//                   image = rs.getBlob(7);
//                   imgData = image.getBytes(1,(int)image.length());
                    String i = rs.getString("villaname");
                    out.println("<tr>");
                    out.println("<td>"+ rs.getString("ownername") +"</td>");
                    out.println("<td>"+ rs.getString("phoneno") +"</td>");
                    out.println("<td>"+ rs.getString("villaname") +"</td>");
                    out.println("<td>"+ rs.getString("address") +"</td>");
                    out.println("<td>"+ rs.getString("homespec") +"</td>");
                    out.println("<td>"+ rs.getString("rpm") +"</td>");
                   byte[] bytearray = new byte[1048576];
                   int size=0;
                   image = rs.getBlob("imagehouse");
                   imgData = image.getBytes(1,(int)image.length());


                   Base64.Encoder encoder = Base64.getEncoder();
                  
                   String encoding = "data:image/jpg;base64," + encoder.encodeToString(imgData);

                    out.println("<td>");
                        out.println("<img src='" + encoding +"' alt=\"\" height=\"70\" width=\"70\">");

                    out.println("</td>");
                      out.println("<td>"+ "<a class='btn btn-warning' href='Updatehome?id="+ i +"'> Update </a>"+ "</td>");
                      out.println("<td>"+ "<a class='btn btn-danger' href='Deletehome?id="+ i +"'> Delete </a>"+ "</td>");
                    out.println("</tr>");
                                   
                }
                out.println("</table>");
                // display the image
             
                } catch (Exception e) {
                out.println("Unable To Display image");
                out.println("Image Display Error=" + e.getMessage());
                
                } 





         %>
        </div>

    </body>
</html>


