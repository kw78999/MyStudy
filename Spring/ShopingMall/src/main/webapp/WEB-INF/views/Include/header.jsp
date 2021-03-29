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
margin-left:0px;
display:inline-block;
 text-align:center;
 width: 150px;
}
.category_ul li:hover{
cursor: pointer;
}
</style>
<script>
function out(obj) {
	if(obj.innerHTML=='신제품'){
		obj.innerHTML="New";
	}else if(obj.innerHTML=='아우터'){
		obj.innerHTML="Outer";
	}else if(obj.innerHTML=='상의'){
		obj.innerHTML="Top";
	}else if(obj.innerHTML=='하의'){
		obj.innerHTML="Bottom";
	}else if(obj.innerHTML=='세트'){
		obj.innerHTML="set";
	}else if(obj.innerHTML=='악세서리'){
		obj.innerHTML="Acc";
	}else if(obj.innerHTML=='원피스'){
		obj.innerHTML="One Piace";
	}
}
window.addEventListener ('load', function(){
	var liArray =document.getElementsByClassName('category_li');
	
	for(var i=0; i<liArray.length; i++) {
		//상품이미지마다 온로드 시 이벤트
		liArray[i].onmouseover = function (obj) {
			obj.style.color="red";
		}(liArray[i]);



	}
});


function hover(obj) {
	if(obj.innerHTML=='New'){
		obj.innerHTML="신제품";
	}else if(obj.innerHTML=='Outer'){
		obj.innerHTML="아우터";
	}else if(obj.innerHTML=='Top'){
		obj.innerHTML="상의";
	}else if(obj.innerHTML=='Bottom'){
		obj.innerHTML="하의";
	}else if(obj.innerHTML=='set'){
		obj.innerHTML="세트";
	}else if(obj.innerHTML=='Acc'){
		obj.innerHTML="악세서리";
	}else if(obj.innerHTML=='One Piace'){
		obj.innerHTML="원피스";
	}
	
	test = function(obj) {
		if(obj.style.background==""){
			var color = 0;
			startInterval = setInterval(function() {
				color++;
				if(color<256){
					var a=255-color/2;
					var b=255-color;
					var c=100+color;
					
					obj.style.color="rgb("+c+","+c+","+c+")";
					obj.style.background="linear-gradient(to right, white, rgba("+a+","+b+",255,0.4))";
				}
				if(color==255){
					clearInterval(startInterval);
					color=0;
					//stopBack(obj);
				}
				
				
			}, 1);
		}else{
			alert(obj.style.background);
		}
		
	}(obj);
	
	
}



var color2=254;
var color3=2;
function stopBack(obj) {
	stopInterval = setInterval(function() {
		color2--;
		color3++;
		if(color2!=0){
			var a2=139+color3;
			var c2=250+color3;
			obj.style.color="rgb("+color2+","+color2+","+color2+")";
			obj.style.background="linear-gradient(to right, white, rgba("+a2+","+color3+","+c2+",0.3))";
		}
		if(color2==0){
			clearInterval(stopInterval);
			color3=2;
			color2=254;
		}
		
		
	},1);
}
</script>
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
			<li><a href="productUploadPage">상품 등록</a></li>
			<li><a href="productUploadPage"> 관리</a></li>
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
			<li  onmouseout="out(this)" class="category_li">New</li>
			<li  onmouseout="out(this)" class="category_li">Outer</li>
			<li  onmouseout="out(this)" class="category_li">Top</li>
			<li  onmouseout="out(this)" class="category_li">Bottom</li>
			<li  onmouseout="out(this)" class="category_li">set</li>
			<li  onmouseout="out(this)" class="category_li">Acc</li>
			<li  onmouseout="out(this)" class="category_li">One Piace</li>
		</ul>
</div>



</body>
</html>