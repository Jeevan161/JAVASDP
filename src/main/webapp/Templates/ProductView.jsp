<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/product.css">
    <link rel="stylesheet" href="../CSS/productview.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
   
   
    <title>${pro.name}</title>
</head>
<body>
<%@ include file="../Templates/Navbar.jsp" %>
    <section class="section-p1 ">
        <div class="product-view">
        <section class="left-product-view">
            <img src="../images/${pro.img_url}" style="margin:10px 60px;height:400px;" width=500px >
        </section>
        <section class="right-product-view">
            <div class="product-view-description">
                <h1>${pro.name}</h1>
                <p>Quality rating</p>
                <span class="fa fa-star checked" style="color: #E5b80B; font-size: 22px; "></span>
                <span class="fa fa-star checked" style="color: #E5b80B; font-size: 22px;"></span>
                <span class="fa fa-star checked" style="color: #E5b80B; font-size: 22px;"></span>
                <span class="fa fa-star checked" style="color: #E5b80B; font-size: 22px;"></span>
                <span class="fa fa-star checked" style="color: #E5b80B; font-size: 22px;"></span>
                <div class="label-tag-product">
                    <strong>Top Selling</strong>
                </div>
            </div>
            <div class="product-view-price">
                <h2>₹ ${pro.discount} /${pro.unit}</h2>
                <p>Orginal price ₹${pro.cost}/${pro.unit}</p>
            </div>
            <div class="product-view-buttons">
                <button id="buynow">Buy Now</button>
                <button id="addtocart" onclick="window.location.href='cart.html';">Add to cart</button>
            </div>
        </div>

    </section>

</body>
</html>