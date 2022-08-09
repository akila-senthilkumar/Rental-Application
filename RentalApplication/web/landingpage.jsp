<%-- 
    Document   : index
    Created on : Dec 12, 2021, 1:55:01 PM
    Author     : Sri Siva Murugan V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>House Rental Application</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <style><%@include file="/WEB-INF/resources/css/style1.css"%></style>
      
    </head>
    <body class="landingpage-body"><div class="container">
    <center>
        
        <div class="signup-form">
            <h1>House Rentals</h1>
            
            <div class="landingpage-form">
            <form action="User" method="post">
		<h2>Register</h2>

                <div class="successMessage">
                    <%=(request.getAttribute("successMessage") == null) ? ""
                      : request.getAttribute("successMessage")%>
                 </div>
                 <div class="errorMessage">
                     <%=(request.getAttribute("errorMessage") == null) ? ""
                      : request.getAttribute("errorMessage")%>
                 </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="fname" placeholder="FullName" required="required">
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="Email" required="required">
                </div>
		<div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Password" required="required">
                </div>
		<div class="form-group">
                    <input type="password" class="form-control" name="confirm_password" placeholder="Confirm Password" required="required">
                </div>        
        
		<div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
                    <div class="text-center mt-1"> <a href="index.jsp" style="color: white; text-decoration: none" class="btn btn-lg btn-success btn-block">About</a></div>
                </div>
            </form>
            </div>
            
            <div class="text-center">Already have an account? <a href="login.jsp" class="landingpage-a">Sign in</a></div>
            <div class="landindpage-head">
                Owner Registration?
                <a href='ownerlogin.jsp'>Register here</a>
            </div>
    </div>

    </center></div>
    </body>
</html>
