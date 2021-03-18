<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>	
<meta charset="UTF-8">

<style>
 
body{min-width:530px; }



.index{
font-size: 5rem;
width: 100%;
height: 200px;
text-align: center;
margin-top: 30px;
}
.index_text{
text-decoration: none;
}
.nav{
width: 100%;
height: 60px;
font-size: 2rem;
text-align: right;	

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
height: 100px;
float: left; 
width: 100%;
 margin: 0 auto; 
text-align: center;
font-size: 2rem;
background-color: #ddd;
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
	
		<c:if test="${sessionScope.id!=null}">
			<li><a href="logout" onc>로그아웃</a></li>
		</c:if>
		<c:if test="${sessionScope.id==null}">
			<c:if test="${sessionScope.id!='admin' }">
				<li><a href="login">Login</a></li>
				<li><a href="join">Join</a></li>
			</c:if>
		</c:if>
		<c:if test="${sessionScope.id=='admin' }">
			<li><a href="productUpload">상품 등록</a></li>
			<li><a href="productUpload"> 관리</a></li>
		</c:if>
		<c:if test="${sessionScope.id!=null}">
			<c:if test="${sessionScope.id!='admin' }">
				<li>Cart</li>
				<li>MyPage</li>
			</c:if>
		</c:if>
	</ul>
</div>
<div class="index">
	<a href="index" class="index_text">LIPHOP</a>
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