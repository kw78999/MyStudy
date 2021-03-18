<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<link rel="stylesheet" media="screen and (max-width: 1024px)" href="resources/css/product_mobile.css" />
<link rel="stylesheet" media="screen and (min-width: 1025px)" href="resources/css/product_desk.css" /></head>
<body onload="init();">
<script language="JavaScript">

var sell_price;
var amount;
//수량 및 가격 측정 메소드
function init () {
	sell_price = document.form.sell_price.value;
	amount = document.form.amount.value;
	document.form.sum.value = sell_price;
	change();
}
//수량 및 가격 측정 메소드
function add () {
	hm = document.form.amount;
	sum = document.form.sum;
	hm.value ++ ;

	sum.value = parseInt(hm.value) * sell_price;
}
//수량 및 가격 측정 메소드
function del () {
	hm = document.form.amount;
	sum = document.form.sum;
		if (hm.value > 1) {
			hm.value -- ;
			sum.value = parseInt(hm.value) * sell_price;
		}
}
//수량 및 가격 측정 메소드
function change () {
	hm = document.form.amount;
	sum = document.form.sum;

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum.value = parseInt(hm.value) * sell_price;
}  

</script>
<body>
<div class ="category_menu">카테고리 > TOP > OUTER</div>

<div class="details_main">
	<ul class="details_ul">
	
		<li class="img_li">
			<img  src="resources/img/d1.jpg" class="img">
		</li>
		
		<li class="product_li">
			<div class="product_li_div">
				<h3>Product Name</h3>
				128.000 $<br>
				<hr class="product_hr"><br>
				적립금  2000  ( 1% )<br>
				옵션 <select><option>red</option><option>blue</option></select><br>
				<hr class="product_hr"><br>
<!-- form 제거 하세요--><form name="form" method="get">
				수량 : <input type=hidden name="sell_price" value="5500">
				<input type="text" name="amount" value="1" size="3" onchange="change();">
				<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"><br>
				금액 : <input type="text" name="sum" size="11" readonly>원
<!-- form 제거 하세요--></form>
				<button type="button" class="product_btn">ADD To Cart</button>
				<button type="button" class="product_btn">BUY NOW</button>
				
				
				<div class="product_text">
					상세정보
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
			mainContent
		
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


<!-- Naver Smart Editor 2 -->
<script>
  var form = document.w_form;
  var oEditors = [];
  nhn.husky.EZCreator.createInIFrame({
      oAppRef: oEditors,
      elPlaceHolder: "textAreaContent",
      sSkinURI: "resources/editor/SmartEditor2Skin.html",
      fCreator: "createSEditor2"
  });
   
  // submit
  function submitContents(elClickedObj) {
      // 에디터의 내용이 textarea에 적용된다.
      oEditors.getById["textAreaContent"].exec("UPDATE_CONTENTS_FIELD", [ ]);
      var con = document.w_form.lcContent;
      con.value = document.getElementById("textAreaContent").value;
      try {
          elClickedObj.form.submit();
      } catch(e) {
       
      }
  }
   
  // textArea에 이미지 첨부
  function pasteHTML(filepath){
      var sHTML = '<img src="<%=request.getContextPath()%>/resources/editor/upload/'+ filepath + '">';
	  oEditors.getById["textAreaContent"].exec("PASTE_HTML", [ sHTML ]);
  }
</script>
<!-- Naver Smart Editor 2 END-->

<%@include file="../Include/footer.jsp" %>
</body>
</html>