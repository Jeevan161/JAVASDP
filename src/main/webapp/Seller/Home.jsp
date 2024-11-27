<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
    .tx
    {
    	margin: 100px 0px 0px 50px;
    }
    
    </style>
<title>Admin Home</title>
</head>
<body>
	<%@ include file="../Seller/Navbar.jsp" %>
	<section class="tx">
	<div><h1>Welcome ${user.name}</h1></div>
</section>
	
	
</body>
</html>