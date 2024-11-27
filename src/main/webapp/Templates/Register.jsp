<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href ="../CSS/register.css">
    <title>Register</title>
    
</head>
<body>
<form action="addproducer" method="post" >
    <div class="container">
        <div class="dimg">
            <a href="/"> <img src="../images/logo.png" width="85%" ></a>
            <span>Already a member?<a href="login">Login.</a></span>
        </div>
        <div class="vl"></div>
        <div class="sidecon">
            <img style="margin-top: 15px;"  src="../images/user.png" width="80px" height="80px">
           
            <h1 style="margin: 0px 0px 5px 0px;">Register</h1>
            <div class="inp">
                
                <input type="text" id="fullname" name = "name" required placeholder="Enter Full Name">
            </div>
            <div class="inp ss">
              <label style="width:100px;">
				  <input type="radio" name="gender" value="male" required>
				  Male
				</label>
				
				<label style="width:100px;">
				  <input type="radio" name="gender" value="female" required>
				  Female
				</label>
				
				<label style="width:100px;">
				  <input type="radio" name="gender" value="other" required>
				  Other
				</label>
            </div>
            <div class="inp">
              
                <input type="email" name="email"  id="email" placeholder="Enter Email" required>
            </div>
            <div class="inp">
            
                <input type="password" id="password" name="password" required placeholder="Password">
                
            </div>
            
            <div class="inp">
            
                <textarea  id="username" name="address" required placeholder="Address"></textarea>
            </div>
            <div class="inp">
                
                <input type="text" name="contactno" required placeholder="Contact Number"  pattern="[7-9]{1}[0-9]{9}"   >
                
            </div>
             <div class="inp ss">
              <label style="width:100px;">
				  <input type="radio" name="userType" value="customer">
				  Customer
				</label>
				
				<label style="width:100px;">
				  <input type="radio" name="userType" value="seller">
				  Seller
				</label>
            </div>
            <span> </span>
            <button class="btn">Submit</button>
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