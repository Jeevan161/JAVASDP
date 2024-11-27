<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/product.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="script.js"></script>
        <link rel="stylesheet" href ="../CSS/register.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Products</title>
</head>
<body>
    <%@ include file="../Admin/Navbar.jsp" %>
    <form action="/admin/updateuser" method ="post">
	 <div class="sidecon" style="width:450px;margin-top:100px;background:#c4cadf;">
            <h1 style="margin: 20px 0px 5px 0px;">Edit</h1>
            <div class="inp">
                
                <input type="text" id="fullname" name = "name" value="${seller.name}" required placeholder="Enter Full Name">
            </div>
            <div class="inp">
              
                <input type="email" name="email" value="${seller.email}"  readonly id="email" placeholder="Enter Email" required>
            </div>

            
            <div class="inp">
            
                <textarea  id="username" name="address" required placeholder="Address">${seller.address}</textarea>
            </div>
            <div class="inp">
                
                <input type="text" name="contactno" value="${seller.contactno}" required placeholder="Contact Number"  pattern="[7-9]{1}[0-9]{9}"   >
                
            </div>
            <div class="inp">
             <div class="inp ss" style="padding:0px;">
            <label style="justify-content:center" >
				  
				  OTP Verified  :
				</label><br>
				</div>
            <div class="inp ss" style="padding:0px;">
              <label style="width:100px;padding: 0px;" >
				  <input type="radio" name="otp" value="True">
				  True
				</label>
				
				<label style="width:100px;">
				  <input type="radio" name="otp" value="False">
				  False
				</label>
            </div>
            </div>  <div class="inp">
             <div class="inp ss" style="padding:0px;">
            <label style="justify-content:center" >
				  
				  Admin Verified  :
				</label><br>
				</div>
            <div class="inp ss" style="padding:0px;">
              <label style="width:100px;padding: 0px;" >
				  <input type="radio" name="admin" value="True">
				  True
				</label>
				
				<label style="width:100px;">
				  <input type="radio" name="admin" value="False">
				  False
				</label>
            </div>
            </div>
            <span> </span>
            <button class="btn">Submit</button>
        </div>
        

    </form>
</body>
</html>