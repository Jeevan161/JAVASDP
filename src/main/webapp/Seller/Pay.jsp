<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../cart.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   
    <style>

        table
        {
            border-spacing: 0 10px;
        
        }
        th,td
        {
            border:1px solid #E8E8E8;
        }
        tr
        {
        
        }
        th {
            background-color: #e0e4ff;
            color: black;
        }
        td
        {
            background-color: rgba(255,255,255,0.7);
        }
        .table_headW
        {
            padding:10px;
        }
        table
        {
            width:100%;
        }
        .table_text
        {
        text-align:center;
        
           font-size:18px;
           font-weight:500;
        }
        </style>
    <title>My Cart</title>
    </head>
<body>
   <%@ include file="../Templates/Navbar.jsp" %>
    <section class="cart-container section-p1" style="margin-top:150px;">

        <div style="display:flex;justify-content:center;align-items:center;flex-direction: column;">
        <div style="width:500px;">
        <table class="product_table">
          <tr>
            <th style="border-radius: 10px 0 0 10px; font-size:20px; padding:5px;">Name</th>
            <th style=" font-size:20px;padding:5px;">Quantity</th>
            <th style="border-radius:0 10px 10px  0; font-size:20px;padding:5px;">Price</th>
          </tr>
        
            <tr>
              <td style="padding:10px;border-radius: 10px 0 0 10px;padding:5px;text-align:center;">Rice</td>
              <td style="padding:10px;text-align:center; ">
        <input style="width:50px;" type="number" name="quantity" value="1" min="1" onchange="updatePrice(this, value)">
        
        
        
              </td>
              <td style="padding:10px;border-radius:0 10px 10px  0;text-align:center;"><span class="product_price">48</span></td>
            </tr>

          <tr>
            <td  style="padding:10px;border-radius: 10px 0 0 10px;padding:5px;text-align:center;" colspan="2">Total:</td>
            <td style="padding:10px;border-radius:0 10px 10px  0;text-align:center;" ><span id="total_price">48</span></td>
          </tr>
        </table>
            </div>

            
            <button  class="btn btn-primary" type="button" onclick="CreateOrderID(1000, 125, '1000 INR - 125 Contacts')" style="width:500px;padding:15px;background-color: #e0e4ff;color:#08817c;font-weight:600;font-size:15px;border-radius:20px;  onclick="CreateOrderID(1000, 125, '1000 INR - 125 Contacts')">Check Out</button>

            </div>
	

</body>
<script>

var xhttp = new XMLHttpRequest();
function CreateOrderID(amount, contactCounts, description) {
	var totalAmountElement = document.getElementById("total_price");
    var tt = parseFloat(totalAmountElement.textContent);
    totalAmount = tt*100;
    xhttp.open("GET", "/seller/payment/createOrderId/"+totalAmount, false);
    xhttp.send();
    var razorpayOrderId = xhttp.responseText;
    console.log("razorpayOrderId" + razorpayOrderId);
    OpenCheckout(amount, contactCounts, razorpayOrderId, description);
}
</script>

<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
function OpenCheckout(amount, contactCounts, razorpayOrderId, description) {
var options = {
    "key": "${rzp_key_id}", 
    "amount": totalAmount.toString(), 
    "currency": "INR",
    "name": "${rzp_company_name}",
    "description": description,
    "image": "/assets/users/images/logo.png",
    "order_id": razorpayOrderId, 
    "callback_url": "/payment/success/"+amount+"/"+contactCounts+"/${rzp_company_name}/${rzp_currency}/"+description,
    "notes": {
        "description": description,
        "company_name": "${rzp_company_name}",
    },
    "theme": {
        "color": "#004A55"
    }
};
var rzp1 = new Razorpay(options);
rzp1.on('payment.failed', function (response){
        console.log(response.error.code);
        console.log(response.error.description);
        console.log(response.error.source);
        console.log(response.error.step);
        console.log(response.error.reason);
        console.log(response.error.metadata.order_id);
        console.log(response.error.metadata.payment_id);
});
rzp1.open();
e.preventDefault();
}
</script>
  <script>
        function updatePrice(input, price) {
          var quantity = input.value;
          var value = quantity * price;
          var row = input.parentNode.parentNode;
          row.querySelector('.product_price').innerHTML = value.toFixed(2);
          updateTotalPrice();
        }
        
        function updateTotalPrice() {
          var total = 0;
          var prices = document.querySelectorAll('.product_price');
          for (var i = 0; i < prices.length; i++) {
            total += parseFloat(prices[i].innerHTML);
          }
          document.querySelector('#total_price').innerHTML = total.toFixed(2);
        }
        </script>
</html>