<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
<meta name="viewport" content="width=device-width,initial-scale=1" />	
<meta charset="UTF-8">

<style>
 
body{min-width:530px; }



.index{
font-size: 5rem;
width: 100%;
background-color: brown;
height: 200px;
text-align: center;
}
.nav{
background-color: olive;
width: 100%;
height: 60px;
font-size: 2rem;

}
.nav_ul{
list-style-type: none;
margin-top: 40px;
}
.nav_ul li{
float: left;
margin-left: 30px;
}
.category{
background-color: green;
height: 100px;
float: left; 
width: 100%;
 margin: 0 auto; 
text-align: center;
font-size: 2rem;
}
.category_ul{
list-style-type: none;
display: table; 
margin: auto; 
padding:0;
margin-bottom: 20px;
}
.category_ul li{
float: left;
margin-left: 30px;
display:inline-block;
 text-align:center;


}
</style>
</head>
<body>
<div class="nav">
	<ul class="nav_ul">
		<li><a href="login">Login</a></li>
		<li>Join</li>
		<li>Cart</li>
		<li>MyPage</li>
	</ul>
</div>
<div class="index">
	<a href="index">LIPHOP</a>
</div>

<div class="category">
		<ul class="category_ul">
			<li>New</li>
			<li>BEST 50</li>
			<li>Outer</li>
			<li>Top</li>
			<li>Bottom</li>
			<li>set</li>
			<li>Acc</li>
			<li>One Piace</li>
		</ul>
</div>



</body>
</html>