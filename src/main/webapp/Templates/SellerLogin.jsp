<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href ="../CSS/login.css">
    <title>Login</title>
    
</head>
<body>
<form action="checkProducerLogin" method="post">
    <div class="container">
        <div class="dimg">
           <a href="/"> <img src="../images/logo.png" width="85%" ></a>
            <span>Not a member?<a href="register">Signup</a> </span>
            <span><a href="login">Customer Login</a></span>
            <span><a href="adminlogin">Admin Login</a></span>
        </div>
        <div class="vl"></div>
        <div class="sidecon">
            <img style="margin-top: 30px;"  src="../images/user.png" width="80px" height="80px">
            <h1>Seller Login</h1>
            <div class="inp">
            
                <input type="text" name="name" id="username" placeholder="Username" required>
            </div>
            <div class="inp">
               
                <input type="password" name="password" id="password" placeholder="Password" required>
                
            </div>
            <div >
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" onclick="myFunction()">
                <label for="password">Show password </label>  
            </div>
            
            <button class="btn" type="submit">Submit</button>
        </div>
    </div>
    </form>
    <script>
        function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
    </script>
</body>
</html>