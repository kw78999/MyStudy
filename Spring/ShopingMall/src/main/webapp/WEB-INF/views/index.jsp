<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="Include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopingMall Index</title>
<style>

.main_Image{ 
width: 100%;
}
.main_Product{
width: 100%;
margin:auto;
align-content: center;
}
.main_Product h1{
font-size: 4rem;
margin-bottom: 80px;
text-align: center;
}
.product_Ul{
list-style-type: none;
margin: auto;
display: table; 
}
.product_Ul li{
float: left;
margin-left:60px;
margin-right: 20px;
}
.product{
width: 350px;
height:620px;


}
.product_img{
width: 350px;
height: 500px;
}
</style>
</head>
<body>
<img src="resources/img/main.jpg" class="main_Image">

<div class="main_Product">
<h1>New Product</h1>
	<ul class="product_Ul">
		<li><div class="product" >
		<img src="resources/img/p1.jpg" class="product_img"onclick="location.href='productDetails'">
		<br><a>Category</a><br><a>Product</a><br><a><b>128,000</b></a>
		</div></li>
		<li><div class="product">
		<img src="resources/img/p3.jpg" class="product_img">
		<br><a>Category</a><br><a>Product</a><br><a><b>128,000</b></a>
		</div></li>
		<li><div class="product">
		<img src="resources/img/p4.jpg" class="product_img">
		<br><a>Category</a><br><a>Product</a><br><a><b>128,000</b></a>
		</div></li>
		<li><div class="product">
		<img src="resources/img/p5.gif" class="product_img">
		<br><a>Category</a><br><a>Product</a><br><a><b>128,000</b></a>
		</div></li>
		<li><div class="product">
		<img src="resources/img/p5.gif" class="product_img">
		<br><a>Category</a><br><a>Product</a><br><a><b>128,000</b></a>
		</div></li>
		<li><div class="product">
		<img src="resources/img/p4.jpg" class="product_img">
		<br><a>Category</a><br><a>Product</a><br><a><b>128,000</b></a>
		</div></li>
		<li><div class="product">
		<img src="resources/img/p4.jpg" class="product_img">
		<br><a>Category</a><br><a>Product</a><br><a><b>128,000</b></a>
		</div></li>
		<li><div class="product">
		<img src="resources/img/p4.jpg" class="product_img">
		<br><a>Category</a><br><a>Product</a><br><a><b>128,000</b></a>
		</div></li>
	</ul>

</div>


<%@include file="Include/footer.jsp" %>
</body>
</html>