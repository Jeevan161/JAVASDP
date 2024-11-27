<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD Product</title>
 <style>
        hr.rounded {
    border-top: 2px solid #bbb;
    border-radius: 5px;
    margin-right: 15px;;
}
.c
{
    display:flex;
    height:100vh;
    align-items:center;
    justify-content:center;

}


.main-con
{

    background:#c4cadf;
    display:flex;
    width:75%;
    align-items:center;
    margin-top:4%;
    height:75%;
    border-radius:10px;
}
.def_profile
{
    border-radius:20px;
    margin:45px;
    width:425px;
    height:375px;
}
.mcleft
{
    display:flex;
    flex-direction:column;
}

.upbtn
{
     width:100%;
    font-size:16px;
     border-radius: 10px;
    background:#00ADB5    ;
    color:white;
      border:#393E46 solid;
      font-weight: bold;
      min-width: 80px;
      height:40px;
      display:flex;
      align-items:center;
      justify-content:center;

}

.vl {
  border-left: 2px solid grey;
  height: 60vh;
  margin-left:20px;
}
.labe
{
    font-weight:500;
    width : 150px;
    padding-right:10px;
}
.inp
{
    font-size:16px;
    padding:6px;
    border-radius:5px;
    border:#CDF0EA 2.5px solid;
    width:65%;

}


.mcright
{
    width:100%;
    height:100%;
}


.parent1 {

    display: grid;
    grid-template-columns: 1fr 1fr;
    width:100%;
    height:100%;
    align-self: start;
    grid-template-rows: repeat(9, 0.62fr);
    padding-left:30px;
    padding-top:20px;
    padding-bottom:20px;
    grid-column-gap: 0px;
    grid-row-gap: 0px;
}

.div1 { grid-area: 1 / 1 / 2 / 3; }
.div2 { grid-area: 2 / 1 / 3 / 3;}
.div3 { grid-area: 3 / 1 / 4 / 3; }
.div4 { grid-area: 4 / 1 / 5 / 3;}
.div5 { grid-area: 5 / 1 / 6 / 3; }
.div6 { grid-area: 6 / 1 / 7 / 3;}
.div7 { grid-area: 7 / 1 / 8 / 3; }

.div9 { grid-area: 8 / 1 / 9 / 3;}
.div10 { grid-area: 9 / 1 / 10 / 3;}

.d
{
    align-self:center;
    align-items:center;
    display:flex;
    justify-content:start;
}
.dobtn
{

     font-size:16px;
     border-radius: 10px;
     background:#00ADB5    ;
     color:white;
     border:#393E46 solid;
     font-weight: bold;
     min-width: 80px;
     height:40px;
     display:flex;
     align-items:center;
     justify-content:center;
     padding:20px;


}
.filebtn
{
    opacity:0;
    width: 30%;
    padding: 5px;
    cursor: pointer;
}

    </style>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
   
</head>
<body>
	<%@ include file="../Seller/Navbar.jsp" %>
	<form method="post" action="addproductaction"  enctype="multipart/form-data">
	 <div class="c" >
<div class="main-con">

    <div class="mcleft" >
      
        <img src="../images/product_preview.png" id="image-preview" style="margin-bottom:0px;"  class="def_profile">
        
        <div style="padding:20px;margin:0px;;">
          <button class="upbtn" type="file" id="img_btn"> <input type="file" id="image-selector" name="productImage" class="filebtn" style="position:fixed;" required> <img src="../images/Upload.png"width="30px" height="25px;">&nbsp;&nbsp;&nbsp;Upload Profile</button>
        </div>
    </div>
    <div class="vl"></div>
    <div class="mcright">

            <div class="parent1">

                <div class="div1 d">
                    <label for="product_name" class="labe">Product Name :</label>
                    <input id="product_name" type="text" name="name" value="" class="inp" required>
                </div>
                <div class="div2 d">
                    <label for="category" class="labe">Type :</label>
                     <input id="product_name" type="text" name="type" value="" class="inp" required>
                </div>
                        <div class="div3 d">
                             <label for="subcategory" class="labe">Subcategory:</label>
						    <select id="subcategory" name="subcategoryId" class="inp" required>
						         <option value="">Select a Subcategory</option>
                                <!-- Iterate over categories -->
                                <c:forEach items="${subcategoryList}" var="subcategory">
                                    <option value="${subcategory.id}">${subcategory.name}</option>
                                </c:forEach>
						    </select>
                        </div>		
                <div class="div4 d">
                     <label for="product_description" class="labe">Description  :</label>
                     <textarea id="product_description" class="inp" name="description" rows="3" required ></textarea>
                </div>
				<div class="div5 d ">
                    <label for="product_price" class="labe">Quantity  :</label>
                    <input id="product_price" type="number" class="inp" name="quantity"  value=""   required>
                </div>
                <div class="div6 d ">
						<div class="div6 d ">
                    <label for="product_price" class="labe" style="width: 128px;">Price  :</label>
                    <input id="product_price" type="number" class="inp" name="cost" value="" required="">
                    <label for="product_discount" class="labe" style="width: 200px;margin-left: 20px;">Discount  :</label>
                    <input id="product_discount" type="number" class="inp" name="dis_cost" value="" required="" style="width: 180px;margin-right: 20px;">
                </div>
                </div>
                <div class="div7 d ">
                   <label for="product_unit" class="labe" >Unit Type  :</label>
                    <input id="product_unit" type="text" class="inp" name="unit" value="" required="">
                </div>
                <div class="div9 d">
                      <label for="product_area" class="labe" >Cultivated Area :</label>
                    <input id="product_area" type="text" class="inp" name="area" value="" required="">
                </div>
                <div class="div10 d" style="justify-content:center;padding-top:15px;">
                    <button id="edit-btn" class="dobtn"  type="submit"> Add Product</button>
                </div>


            </div>

    </div>
</div>
</div>
</form>
<script>
    // Get the input element and preview image element
    const imageSelector = document.getElementById('image-selector');
    const imagePreview = document.getElementById('image-preview');
  
    // Add an event listener to the input element
    imageSelector.addEventListener('change', (event) => {
      // Get the selected file
      const file = event.target.files[0];
  
      // Create a FileReader object to read the file
      const reader = new FileReader();
  
      // Set up a function to run when the file is loaded
      reader.onload = (event) => {
        // Update the preview image source with the loaded file data
        imagePreview.src = event.target.result;
      };
  
      // Read the file as a data URL
      reader.readAsDataURL(file);
    });
    
  </script>
    

</body>
</html>