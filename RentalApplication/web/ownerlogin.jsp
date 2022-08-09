<%-- 
    Document   : ownerlogin
    Created on : Jan 18, 2022, 10:03:36 AM
    Author     : Akila Senthilkumar
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Owner Login</title>
        <style><%@include file="/WEB-INF/resources/css/style1.css"%></style>
<!--        <style>
            body{
                background-color: #4b0082;
            }
            form{
                width: 330px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-left: 20px;
                padding-right: 20px;
                background-color: crimson;
                z-index: -1;
            }
            form input[type=email],input[type=password]{
                width: 280px;
                height: 35px;
                
            }
            form input[type=submit]{
                width: 100px;
                height: 35px;
                background-color: #4b0082;
                color: white;
                border: #4b0082;
                cursor: pointer;
            }
        </style>-->	
	<script type="text/javascript">
            function validate() {
  
                var user = document.getElementById("e").value;
                var user2 = document.getElementById("e");
                var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                if (re.test(user)) {
                    //alert("done");
                    return true;
                }
                else {
                    user2.style.border = "yellow solid 3px";
                    return false;
                }
            }
        </script>
    </head>
    <body>
      <center>
        
          <h1>House Rentals</h1>
          <br>
          <br>
          <h2>Login to Register your House</h2>
          <br>
          <br>
          <form action="ownerlogin" class="login-form">
              
              <input class="loginform-details" type="email" name="username" placeholder="Email" required/>
              <br>
              <br>
              <input class="loginform-details" type="password" name="password" placeholder="Password" required/>
              <br>
              <br>
              <input onclick="validate()" type="submit" value="Login" class="btn btn-lg btn-primary">
          </form>
          <br>
          <br>
          <div class="text-center"> Don't have an account? <a href="ownerSignUp.jsp" style="color: #000">Owner Sign Up</a></div>
          <div class="text-center mt-3">User Sign Up? <a href="landingpage.jsp" class="landingpage-a mt-2" style="color: #000">Sign-Up</a></div>
      </center>
    </body>
</html>

