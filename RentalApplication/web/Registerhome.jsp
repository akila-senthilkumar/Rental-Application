<%-- 
    Document   : Registerhome.jsp
    Created on : Dec 25, 2021, 1:45:49 PM
    Author     : Damodharan R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>House Registration</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <style>
            .House h1{
                font-size: 40px;
                color: #026670;
            }
            .House input[type=text]{
                width: 250px;
                height: 30px;
                padding: 5px;
            }
            
            .button-33 {
              background-color: #9fedd7;
              border-radius: 100px;
              box-shadow: rgba(2, 102, 112, .2) 0 -25px 18px -14px inset,rgba(2, 102, 112, .15) 0 1px 2px,rgba(2, 102, 112, .15) 0 2px 4px,rgba(2, 102, 112, .15) 0 4px 8px,rgba(2, 102, 112, .15) 0 8px 16px,rgba(2, 102, 112, .15) 0 16px 32px;
              color: black;
              cursor: pointer;
              display: inline-block;
              font-family: CerebriSans-Regular,-apple-system,system-ui,Roboto,sans-serif;
              padding: 7px 20px;
              text-align: center;
              text-decoration: none;
              transition: all 250ms;
              border: 0;
              font-size: 16px;
              user-select: none;
              -webkit-user-select: none;
              touch-action: manipulation;
            }

            .button-33:hover {
              box-shadow: rgba(2, 102, 112, .35) 0 -25px 18px -14px inset,rgba(2, 102, 112, .25) 0 1px 2px,rgba(2, 102, 112, .25) 0 2px 4px,rgba(2, 102, 112, .25) 0 4px 8px,rgba(2, 102, 112, .25) 0 8px 16px,rgba(2, 102, 112,.25) 0 16px 32px;
              transform: scale(1.05) rotate(-1deg);
            }
            
            body {
                background-color: #EDEAE5;
            }
            
            
            table,th,td {
                border-radius: 25px;
                padding: 15px ;
                margin: 10px;
                /*border: 2px solid black;*/
                background-color: #fef9c7;
            }
            .successMessage{
                color:green;
                font-size: 20px;
            }
            .errorMessage{
                color:red;
                font-size: 20px;
            }

        </style>
    </head>
    <body>
    <center>
        <div class="House">
        <h1>House Registration</h1>
        <div class="successMessage">
            <%=(request.getAttribute("successMessage") == null) ? ""
              : request.getAttribute("successMessage")%>
         </div>
         <div class="errorMessage">
            <%=(request.getAttribute("errorMessage") == null) ? ""
              : request.getAttribute("errorMessage")%>
         </div>
        <form action="Homeadd" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Phone Number: </td><td><input type="tel" name="phoneno" placeholder="2345769812" pattern="[1-9]{1}[0-9]{9}"required/></td>
                </tr>
                <tr>
            <td>Villa Name:  </td><td><input type="text" name="hname" placeholder="Villa Name.." required/></td>
            </tr>
            <tr>
                <td>House Address: </td><td><textarea name="address" placeholder="Address" cols="31" required></textarea></td>
            </tr>
            <tr>
            <td>House Specification:  </td><td><textarea name="hspec" placeholder="House Specification" cols="31" required=""></textarea></td>
            </tr>
            <tr>
            <td>Rent per Month: </td><td> <input type="number" name="rpm" placeholder="Rent Per Month" required/></td>
            </tr>
            <tr>
            <td>House picture: </td><td> <input type="file" name="photo" required/></td>
            </tr>
            <tr>
            <td></td><td> <input class="button-33" type="submit" value="Add your Home" /></td>
            </tr>
            </table>
            
            
            
        </form>
        </div>
    </center>
    </body>
</html>
