<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" 
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="../CSS/style.css">
    <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
    <link rel="stylesheet" href="../CSS/product.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script>
      AOS.init();
    </script>
    <link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"
/>

<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <title>Home</title>
</head>
<body>
   <%@ include file="../Templates/Navbar.jsp" %>

    <section id="hero">
        <h4 style="margin: 0;font-size: 28px;letter-spacing: 1px;font-weight: 900;">Empowering Rural Success</h4>
        <h1 class="one"  >Cultivating Farms, Enriching Lives.</h1>
        <p class="para" >Begin Your Path to a Flourishing Future: Growing Wealth, Growing Wellness.</p>
        <button style="margin-top: 15px; font-size: 18px;letter-spacing: 1px;font-weight: 500;"><a href="products.html" style="color: #088178;text-decoration:none;">Products</a></button>

    </section>

    <section id="feature" class="section-p1">
        <div class="fe-box">
            <img src="../images/FreeShiping .jpg" alt="FreeShiping" width="170px" height="170px">
            <h6 style="margin: 0;color: #385a64;">Free Shipping</h6>
        </div>
        <div class="fe-box">
            <img src="../images/onlineOrder.jpg" alt="FreeShiping" width="170px" height="170px">
            <h6 style="margin: 0;background:#cfe4f9;">Online Order</h6>
        </div>
        <div class="fe-box">
            <img src="../images/SaveMoney.jpg" alt="FreeShiping" width="170px" height="170px">
            <h6 style="margin: 0;color: #ff735c; background-color: #ebebeb;">Save Money</h6>
        </div>
        <div class="fe-box">
            <img src="../images/StayHealthy.jpg" alt="FreeShiping" width="170px" height="170px">
            <h6 style="margin: 0;background-color: #d5f8e7;color: #2b468b;">Stay Healthy</h6>
        </div>
        <div class="fe-box">
            <img src="../images/Farmer.jpg" alt="FreeShiping" width="170px" height="170px">
            <h6 style="margin: 0;background-color: #eff8ff;">Support Farmers</h6>
        </div>
        <div class="fe-box">
            <img src="../images/CustomerSupport.jpg" alt="FreeShiping" width="170px" height="170px">
            <h6 style="margin: 0;">24/7 Support</h6>
        </div>
        </section>
        <div class="horizontal-border"></div>
        
          <div class="section-heading">
           <span><center>Photo Gallery</center></span>
          </div>
 
        <section class="section-p1" style="padding-top: 0px;">
          <div  class="ff" style=" margin-top:5px;width: 100%;">
        <div  class="sliderdiv">
          <div class="swiper mySwiper">
            <div class="swiper-wrapper">
              <div class="swiper-slide"><img src="../images/p1.jpg"></div>
              <div class="swiper-slide"><img src="../images/p2.jpg"></div>
              <div class="swiper-slide"><img src="../images/p3.jpg"></div>
              <div class="swiper-slide"><img src="../images/p4.jpg"></div>
              <div class="swiper-slide"><img src="../images/p5.jpg"></div>
              <div class="swiper-slide"><img src="../images/p6.jpg"></div>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-pagination"></div>
          </div>
      </div>
    </section>
    <div class="horizontal-border"></div>
    <div class="section-heading">
      <span><center>Top Selling </center></span>
     </div>
    <section class="section-p1 top-products-section">
      
        <!-- Products Card -->
        <div class="Product-container">
            <div class="product-image" >
              <img src="../images/tomato-img1.png" alt="">
            </div>
            <div class="product-description">
              <div class="name">
                <h1>Tomato</h1> 
                <i class="fi fi-bs-indian-rupee-sign" style="margin-top: 50px;">₹ 99/kg</i>
              </div>
              <div class="product-container-btn">
                <button id="addtocart" onclick="window.location.href='cart.html';" >Add to Cart</button>
              </div>
            </div> 
        </div>
        <!-- - -->
          <!-- Products Card -->
          <div class="Product-container">
            <div class="product-image">
              <img src="../images/rice-img1.jpg" alt="">
            </div>
            <div class="product-description">
              <div class="name">
                <h1>Rice</h1> 
                <i class="fi fi-bs-indian-rupee-sign" style="margin-top: 50px;">₹ 70/kg</i>
              </div>
              <div class="product-container-btn">
                <button id="addtocart" onclick="window.location.href='cart.html';" >Add to Cart</button>
              </div>
            </div> 
        </div>
        <!-- - -->
          <!-- Products Card -->
          <div class="Product-container">
            <div class="product-image">
              <img src="../images/potato-img1.jpg" alt="">
            </div>
            <div class="product-description">
              <div class="name">
                <h1>Potato</h1> 
                <i class="fi fi-bs-indian-rupee-sign" style="margin-top: 50px;">₹ 48/kg</i>
              </div>
              <div class="product-container-btn">
                <button id="addtocart" onclick="window.location.href='cart.html';" >Add to Cart</button>
              </div>
            </div> 
        </div>
        <!-- - -->
        
          <!-- Products Card -->
          <div class="Product-container">
            <div class="product-image">
              <img src="../images/wheat-img1.png" alt="">
            </div>
            <div class="product-description">
              <div class="name">
                <h1>Wheat</h1> 
                <i class="fi fi-bs-indian-rupee-sign" style="margin-top: 50px;">₹ 115/kg</i>
              </div>
              <div class="product-container-btn">
                <button id="addtocart" onclick="window.location.href='cart.html';" >Add to Cart</button>
              </div>
            </div> 
        </div>
        <!-- - -->
          <!-- Products Card -->
          <div class="Product-container">
            <div class="product-image">
              <img src="../images/onion-img1.png" alt="">
            </div>
            <div class="product-description">
              <div class="name">
                <h1>Onion</h1> 
                <i class="fi fi-bs-indian-rupee-sign" style="margin-top: 50px;">₹ 69/kg</i>
              </div>
              <div class="product-container-btn">
                <button id="addtocart" onclick="window.location.href='cart.html';" >Add to Cart</button>
              </div>
            </div> 
        </div>
        <div>

 
</section>

          <!-- Swiper JS -->
          <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
        
          <!-- Initialize Swiper -->
          <script>
            var swiper = new Swiper(".mySwiper", {
              spaceBetween: 30,
              centeredSlides: true,
              autoplay: {
                delay: 2500,
                disableOnInteraction: false,
              },
              pagination: {
                el: ".swiper-pagination",
                clickable: true,
              },
              navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev",
              },
            });
          </script>
        
   
    <!-- <footer class="section-p1">
        <div class="col">
            <img src="images/logo.png" class="logo" width="275px" height="60px" alt="Logo">
            <h3><strong>Contactw</strong></h3>
        </div>

    </footer> -->
      
    
    <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>

   
</body>
</html>