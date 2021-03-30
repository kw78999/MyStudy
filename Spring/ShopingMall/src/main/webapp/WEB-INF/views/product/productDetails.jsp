<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../Include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<link rel="stylesheet" media="screen and (max-width: 1024px)" href="resources/css/product_mobile.css?v5" />
<link rel="stylesheet" media="screen and (min-width: 1025px)" href="resources/css/product_desk.css?v9" /></head>
<body onload="init()">
<script>


var sellPrice;
var amount;





function optionChange(obj) {
	money=obj.value.split('$');
	document.getElementById('sellPrice').value = money[1];
	document.getElementById('amount').value=1;
	init();
}
function init () {
	sellPrice = document.getElementById('sellPrice').value;
	amount = document.getElementById('amount').value;
	document.getElementById('sum').value = sellPrice;
	change();
}

function productAdd () {
	hm = document.getElementById('amount');
	sum =document.getElementById('sum');
	hm.value ++ ;

	sum.value = parseInt(hm.value) * sellPrice;
}

function del () {
	hm = document.getElementById('amount');
	sum = document.getElementById('sum');
		if (hm.value > 1) {
			hm.value -- ;
			sum.value = parseInt(hm.value) * sellPrice;
		}
}

function change () {
	hm = document.getElementById('amount');
	sum = document.getElementById('sum');

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum.value = parseInt(hm.value) * sellPrice;
}  




window.addEventListener('load',function(){
	//모든 상품이미지 가져오기
	var imgArray =document.getElementsByClassName('img');
	
	for(var i=0; i<imgArray.length; i++) {
		//상품이미지마다 온로드 시 이벤트
		imgArray[i].onload = function (obj,str) {
			//이미지 소스 스플릿
			var imgSrc = str.split(',');
		    //3번째 이미지 있는지 검사
		    if(imgSrc[2]=="" || imgSrc[2] == null){
		    	if(imgSrc[1]=="" || imgSrc[1] == null){
		    		//이미지 1개만있음 
		    		obj.src='resources/editor/upload/'+imgSrc[0];
		    		
		    	}else{
		    		//이미지가 2개있기때문에 2개만 반복
		    		var idx2 = 0;
		    		
		    		playThumbnail = setInterval(function() {
		    			if(idx2==2){
		    				idx2=0;
		    			}
		    			obj.src = 'resources/editor/upload/'+imgSrc[idx2];
		    			
		    			idx2++;
		    		}, 1500);
		    		
		    	}
			}else{
				//이미지 3개다 있음 3개 반복
				var idx = 0;
				
				playThumbnail = setInterval(function() {
					if(idx==3){
						idx=0;
					}
						console.log(imgSrc[idx]);
						obj.src = 'resources/editor/upload/'+imgSrc[idx];
						
					
					idx++;
				}, 1500);
			}
			//매개변수 이미지 객체,이미지 속성값(hidden으로 가져옴 )
		}(imgArray[i],imgArray[i].nextSibling.nextSibling.value);
		
		
	}
	
});
	

</script>
<body>
					<!--   	${product }
							${productTexture }
							${oList }-->
<div class ="category_menu">카테고리 > ${product.category} > ${product.categorySub}</div>

<div class="details_main">
	<ul class="details_ul">
	
		<li class="img_li">
			<img  src="resources/editor/upload/${fn:split(product.thumbnail,',')[2]}" class="img">
			<input type="hidden" value=${product.thumbnail }>
		</li>
		
		<li class="product_li">
			<div class="product_li_div">
				<h3>${product.PName}</h3>
				$  ${product.price} <br>
				<hr class="product_hr"><br>
				적립금  2000  ( 1% )<br><br>
				
				옵션 <select class="optionSelecter" onchange="optionChange(this)">
				<option>${product.color } / ${product.size} / ${product.stock }ea / $${product.price}</option>
				
				<c:forEach items="${oList}" var="option" begin="0" end="${fn:length(oList)}" step="1">
						<option>${option.OColor } / ${option.OSize } / ${option.OStock }ea / $${option.OPrice } </option>
				</c:forEach>
				
				</select><br>
				<hr class="product_hr"><br>
				
				수량 : <input type=hidden name="sellPrice" value="${product.price}" id="sellPrice">
				<input type="text" name="amount" value="1" size="3" onchange="change();" id="amount" class="amount">
				<input type="button" value=" + " onclick="productAdd(this);" class="plusProduct">
				<input type="button" value=" - " onclick="del();" class="minusProduct">
				<br>
				금액 : <input type="text" name="sum" size="11"id="sum" class="sum" value="${product.price }"readonly>원
				<br>
				<button type="button" class="product_btn">ADD To Cart</button>
				<button type="button" class="product_btn">BUY NOW</button>
				
				
				<div class="product_text">
					${product.character1 }
				</div>
			</div>
		</li>
		
	</ul>
</div>
	
	<table class="review_table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>회원등급</th>
				<th>평점</th>
			</tr>
		</thead>
		<!-- JSTL 반복문 -->
		<tr>
			<td>1</td>		
			<td>테스트 제목입니다. 테스트</td>		
			<td>일반</td>		
			<td>%%%%%%</td>	
		</tr>
		<tr>
			<td>1</td>		
			<td>테스트 제목입니다. 테스트</td>		
			<td>일반</td>		
			<td>%%%%%%</td>	
		</tr>
		<tr>
			<td>1</td>		
			<td>테스트 제목입니다. 테스트</td>		
			<td>일반</td>		
			<td>%%%%%%</td>	
		</tr>
		<tr>
			<td>1</td>		
			<td>테스트 제목입니다. 테스트</td>		
			<td>일반</td>		
			<td>%%%%%%</td>	
		</tr>
	</table>
		<div class="mainContent">
			${product.content}
		
		</div>
	<div class="size">
		<h2>size (cm)</h2>
		<table class="size_table">
			<tr class="size_table_first_tr">
				<td>사이즈</td>
				<td>어깨</td>
				<td>가슴</td>
				<td>팔길이</td>
				<td>암홀</td>
				<td>밑단</td>
				<td>총길이</td>
			</tr>
			<tr>
				<td>Free(100~105)</td>
				<td>55</td>
				<td>67</td>
				<td>60</td>
				<td>20</td>
				<td>43</td>
				<td>66</td>
			</tr>
		</table>
	</div>
	<table class="review_table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>회원등급</th>
				<th>평점</th>
			</tr>
		</thead>
		<!-- JSTL 반복문 -->
		<tr>
			<td>1</td>		
			<td>테스트 제목입니다. 테스트</td>		
			<td>일반</td>		
			<td>%%%%%%</td>	
		</tr>
		<tr>
			<td>1</td>		
			<td>테스트 제목입니다. 테스트</td>		
			<td>일반</td>		
			<td>%%%%%%</td>	
		</tr>
		<tr>
			<td>1</td>		
			<td>테스트 제목입니다. 테스트</td>		
			<td>일반</td>		
			<td>%%%%%%</td>	
		</tr>
		<tr>
			<td>1</td>		
			<td>테스트 제목입니다. 테스트</td>		
			<td>일반</td>		
			<td>%%%%%%</td>	
		</tr>
	</table>
	<div class="QA">
		Q&A
	</div>




<%@include file="../Include/footer.jsp" %>
</body>
</html>