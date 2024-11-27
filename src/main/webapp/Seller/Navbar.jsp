<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" 
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="../CSS/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../JS/script.js"></script>
<title>Insert title here</title>
</head>
<body>
<section id="header" class="header">   
    <a href="/"><img src="../images/logo.png" style="padding-left:20px ;" class="logo" width="250px" height="60px" alt="Logo"></a>
     <div>
         <ul style="margin-top: 39px;" id="cs-navbar" class="cs-navbar">
             <li><a class="active ah" href="/seller/home">Home</a></li>
             <li><a class="ah" href="/seller/addproduct">Add Products</a></li>
             <li><a class="ah" href="/seller/products">View Products</a></li>
             <li><a class="ah" href="about.html">Sales</a></li>
             <li><a  class="ah" href="/seller/contactus">Feedback</a></li>
             <li><a class="ah" href="#"><i class="fa-solid fa-bag-shopping"></i></a></li>
             <li><a href="/login"><button class="btn">Logout</button></a></li>   
         </ul>
         <input type="checkbox" id="check" onclick="toggleNavbar()" style="justify-self: left;">
     <label for="check">
         <i class="fas fa-bars" id="btn"></i>
         <i class="fas fa-times" id="cancel"></i>
     </label>  
     </div>
 </section>
</body>
</html>