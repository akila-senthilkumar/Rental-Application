<%-- 
    Document   : login
    Created on : Dec 12, 2021, 10:01:27 PM
    Author     : Akila Senthilkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Login</title>
        <style><%@include file="/WEB-INF/resources/css/style1.css"%></style>
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
          <h2 font-family: cursive; font-size: 20;">Login to see and book house</h2>
          <br>
          <br>
          <form action="Login" class="login-form">
              <input class="loginform-details" type="email" name="username" placeholder="Email" id="e" required/>
              <br>
              <br>
              <input class="loginform-details" type="password" name="password" placeholder="Password" required/>
              <br>
              <br>
              <input onclick="validate()" type="submit" value="Login" class="btn btn-lg btn-primary">
          </form>
          <div class="text-center mt-3">Don't have an account? <a href="landingpage.jsp" class="landingpage-a mt-2" style="color: #000">Create an account</a></div>
      </center>
    </body>
</html>
