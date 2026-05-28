<%-- 
    Document   : CookieFormPractice
    Created on : May 24, 2026, 1:00:21 AM
    Author     : khateeb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cookie Form Practice</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="h1 text-center my-3">Registration Form uses cookies</div>
            <form action="cki1" method="POST" class="row justify-content-center">
                <div class="col-md-7 my-2">
                    <label for="fname">First Name:</label>
                    <input type="text" class="form-control" id="fname" placeholder="Enter First Name" name="fname"/>
                </div>
                <div class="col-md-7 my-2">
                    <label for="lname">Last Name:</label>
                    <input type="text" class="form-control form-label" id="lname" placeholder="Enter Last Name" name="lname"/>
                </div>               
                <input type="submit" value="Register" class="btn btn-primary col-md-7 my-3"/>
            </form>
        </div>
    </body>
</html>
