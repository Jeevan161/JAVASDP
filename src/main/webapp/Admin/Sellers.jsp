<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.cta
{
	display:flex;
	justify-content:center;
	align-items:center;
	background:#e5e5e5;
	height:100vh;
}

table {
	 border-collapse: collapse;
	 box-shadow: 0 5px 10px #e1e5ee;
		border-radius:15px;
	 text-align: left;
	 background:white;
	 margin-top:13%;
	 overflow: hidden;
}
 table thead {
	 box-shadow: 0 5px 10px #e1e5ee;
}
 table th {
	 padding: 1rem 2rem;
	 text-transform: uppercase;
	  background-color: #c4cadf;
	 letter-spacing: 0.1rem;
	 font-size: 0.7rem;
	 font-weight: 900;
}
 table td {
	 padding: 1rem 2rem;
}
 table a {
	 text-decoration: none;
	 color: #2962ff;
}
 table .status {
	 border-radius: 0.2rem;
	 background-color: red;
	 padding: 0.2rem 1rem;
	 text-align: center;
}
 table .status-pending {
	 background-color: #fff0c2;
	 color: #a68b00;
}
 table .status-paid {
	 background-color: #c8e6c9;
	 color: #388e3c;
}
 table .status-unpaid {
	 background-color: #ffcdd2;
	 color: #c62828;
}
 table .amount {
	 text-align: right;
}
 table tr:nth-child(even) {
	 background-color: #f4f6fb;
}
 
    .check-column {
      width: 30px;
      text-align: center;
    }

    .search-container {
      margin-bottom: 20px;
    }

    .search-container input[type=text] {
      padding: 6px;
      margin-top: 8px;
      font-size: 14px;
      border: none;
      width: 80%;
    }
    table tr {
  transition: all 0.3s ease-in-out;
}

table tr:hover {
  background-color: #e6f7ff;
  transform: scale(1.02);
}
table {
  opacity: 0;
  animation: fadeIn 0.5s ease forwards;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateX(100%);
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
}

tr {
  animation: slideIn 0.5s ease forwards;
}

@keyframes slideIn {
  from {
    opacity: 0;
    transform: translateX(100%);
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
}


    .search-container button {
      float: right;
      padding: 6px 10px;
      margin-top: 8px;
      margin-right: 16px;
      background: #ddd;
      font-size: 14px;
      border: none;
      cursor: pointer;
    }

    .search-container button:hover {
      background: #ccc;
    }

    .select-all {
      margin-bottom: 10px;
    }

    .select-all label {
      font-weight: bold;
    }

    .select-all input[type=checkbox] {
      margin-right: 5px;
    }
    .toggle-switch {
  display: inline-block;
  position: relative;
}

.toggle-label {
  display: flex;
  justify-content: space-between;
  width: 80px;
  background-color: red; /* Start with "False" in red */
  border-radius: 20px;
  padding: 5px;
  cursor: pointer;
}

.toggle-label .true {
  width: 50%;
  color: white;
  text-align: center;
  background-color: green; /* "True" in green */
  border-radius: 20px 0 0 20px;
  transition: background-color 0.3s;
}

.toggle-label .false {
  width: 50%;
  color: white;
  text-align: center;
  border-radius: 0 20px 20px 0;
  transition: background-color 0.3s;
}

#toggle {
  display: none;
}

#toggle:checked + .toggle-label {
  background-color: green; /* When checked, switch to "True" in green */
}

#toggle:checked + .toggle-label .true {
  background-color: red; /* "False" in red */
}
    </style>
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
 
</head>
<body>


<%@ include file="../Admin/Navbar.jsp" %>
<div class="cta">
 <table id="myTable" style="margin:20px;">
    <thead>
      <tr>
            <th>Seller Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Address</th>
            <th>Contact No</th>
            <th>Role</th>
            <th>OTP Verification</th>
            <th>Admin Verification</th>
            <th>Action</th>

        </tr>
    </thead>
     <tbody>
        <c:forEach items="${sellers}" var="sell">
            <tr>
                <td>${sell.name}</td>
                <td>${sell.email}</td>
                <td>${sell.gender}</td>
                <td>${sell.address}</td>
                <td>${sell.contactno}</td>
                <td>Seller</td>
                      <td>${sell.otpVerified}</td>
                <td>${sell.adminVerified}</td>
                <td><button><a href="/admin/${sell.id}">Update</a> </button>/<button><a href="/seller/delete/${sell.id}">Delete</a> </button> </td>
            	
  
</div>
            	</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>