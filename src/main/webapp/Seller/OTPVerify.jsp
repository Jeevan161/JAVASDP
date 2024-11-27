<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href ="../CSS/register.css">
</head>
<body>
<form action="/seller/verifyOTP" method="post">
<div class="sidecon hide" style="
    background: #c6daeb;
    width: auto;">
            <img style="margin-top: 15px;"  src="../images/user.png" width="80px" height="80px">
           
            <h1 style="margin: 0px 0px 5px 0px;">Verify OTP</h1>
            OTP Sent to the Registered Email 
            <div class="inp">
                
                <input type="text" id="Enter OTP" name ="otp" style="width: 300px;margin: 0px 50px;" required placeholder="Enter OTP">
            </div>
             <button class="btn">Verify</button>
          </div>
      
    </div>
   </form> 
</body>
</html>