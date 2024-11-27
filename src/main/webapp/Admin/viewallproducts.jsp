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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Products</title>
</head>
<body>
    <%@ include file="../Templates/Navbar.jsp" %>
    <div class="section-heading page-top">
        <span><center>Products </center></span>
       </div>
       <section class="section-p1 top-products-section " style="padding: 10px 60px;">
      
       <c:forEach items="${plist}" var="pro">
       <!-- Products Card -->
       <div  id="myDiv" class="Product-container">
        <div class="product-image">
          <a href="productview"><img src="../images/${pro.img_url}" alt=""></a>
        </div>
        <div class="product-description">
          <div class="name">
            <h1>${pro.name}</h1> 
            <i class="fi fi-bs-indian-rupee-sign" style="margin-top: 50px;">₹  ${pro.cost}/kg</i>
          </div>
          <div class="product-container-btn">
            <button id="addToCartButton">Add to Cart</button>
          </div>
        </div> 
    </div>
    </c:forEach>
    <!-- - -->
      
           
    </div>
    
       

</section>
<script>
    var myDiv = document.getElementById("myDiv");
    var addToCartButton = document.getElementById("addToCartButton");

    function redirectToProductView() {
        window.location.href = "productview";
    }

    function redirectToCart() {
        window.location.href = "cart.html";
    }

    myDiv.onclick = function(event) {
        if (event.target !== addToCartButton) {
            redirectToProductView();
        }
    };

    addToCartButton.onclick = function(event) {
        event.stopPropagation();
        redirectToCart();
    };
</script>
</body>
</html>