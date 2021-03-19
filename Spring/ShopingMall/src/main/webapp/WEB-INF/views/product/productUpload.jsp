<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>


function setThumbnail(event) {
	 
	var reader = new FileReader();
	reader.onload = function(event) {
		
		
		var view = document.getElementById("image_container");
		view.style.display="block";
		
		var img = document.getElementById("imgtest");
		img.setAttribute("src", event.target.result);

		};
		reader.readAsDataURL(event.target.files[0]);
		}
		
function setT() {
		var view = document.getElementById("image_container");
		view.style.display="none";
}

$(document).ready(function(){
	var fileTarget = $('.mfile .upload-hidden');
	fileTarget.on('change', function(){ // 값이 변경되면
		if(window.FileReader){ // modern browser
			var filename = $(this)[0].files[0].name;
		} else { // old IE
			var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출
		}

	var fileType=filename.substring(filename.length-3,filename.length); //파일확장자 추출
	var ktype2="";
	
if(fileType=='jpg'||fileType=='png'||fileType=='gif'){   //파일확장자 검사하여 미리보기 끄고 켜기
	setThumbnail(event);
}else{
	if(ktype2=='jpg'||ktype2=='png'){
		var view2 = document.getElementById("image_container");
		view2.style.display="none";
	}else{
	setT();
	}
}
// 추출한 파일명 삽입
		$(this).siblings('.upload-name').val(filename);
	});
});

//버튼의 부모의 부모인 li 삭제
function delthis(obj) {
	$(obj).parent().parent().remove();
}

//옵션 상품 펼치고 접는 버튼
function openThis(obj) {
	//접기
	if(obj.parentNode.style.height=='150px'){
		obj.parentNode.style.height = '60px';
		obj.parentNode.lastChild.style.display='none';
	//펼치기
	}else{
		obj.parentNode.style.height = '150px';
		obj.parentNode.lastChild.style.display='block';
	}
}

//메인 상품 펼치고 접는 버튼
function mainOpenThis(obj) {
	//접기
	if(obj.parentNode.style.height=='150px'){
		obj.parentNode.style.height = '60px';
		obj.nextSibling.nextSibling.style.display='none';
	//펼치기
	}else{
		obj.parentNode.style.height = '150px';
		obj.nextSibling.nextSibling.style.display='block';
	}
}

//옵션추가시 div생성
function createDiv() {
	var p = document.getElementById("product_parent_div");
	var s = document.getElementById("product_parent_ul");
   	
   	   //ul에 붙힐 li생성
       var s1 = document.createElement("li");
       s1.setAttribute("class","product_parent_li");
       //li에 붙힐 div 생성  
	   cdiv=document.createElement("div");
	   cdiv.setAttribute("class","product_Main");
	   
	   //div에 붙힐 삭제 버튼 생성
       dbtn=document.createElement("button");
       dbtn.setAttribute("type","button");
       dbtn.setAttribute("class","delBtn");
       dbtn.setAttribute("onclick","delthis(this);");
       dbtn.innerHTML="삭제";
       
     //div에 붙힐 열고 닫는 버튼 생성
       obtn=document.createElement("button");
       obtn.setAttribute("type","button");
       obtn.setAttribute("class","openBtn");
       obtn.setAttribute("onclick","openThis(this);");
       obtn.innerHTML="펼치기";
       
		
       
       otionTable=document.createElement('table');
       otionTable.setAttribute("class","product_table");
       
       
       var ftr=document.createElement('tr');
       var ftd=document.createElement('td');
       var ftd2=document.createElement('td');
       
       var str=document.createElement('tr');
       var std=document.createElement('td');
       var std2=document.createElement('td');
       
       ftd.innerHTML="Color <input type='text' class='inputText'>";
       ftd2.innerHTML="Size <input type='text' class='inputText'>";
       std.innerHTML="Stock <input type='text' class='inputText'>";
       std2.innerHTML="Price <input type='text' class='inputText'>";
       
       otionTable.appendChild(ftr);
       otionTable.appendChild(str);
       ftr.appendChild(ftd);
       ftr.appendChild(ftd2);
       str.appendChild(std);
       str.appendChild(std2);
       
       
       
       
       s.appendChild(s1);        //ul에 li부착
       s1.appendChild(cdiv);   	 //li에 div 부착
       cdiv.appendChild(dbtn);    //div에 버튼 부착
       cdiv.appendChild(obtn);    //div에 버튼 부착
       cdiv.appendChild(otionTable);
       
}
</script>
<style>
.inputText{
width: 190px;
height: 35px;
border-radius: 30px;
border: 5px solid gray;
padding-left: 40px;
}
.product_table{
text-align: center;
font-size: 2rem;
margin: auto;
display: none;
width: 100%;
}
.product_table td{padding-left: 130px; }

.product_Option{
background-color: silver;
margin: auto;
border:1px solid red;
width:90%;
height:60px;
}
.product_Main{
background-color: aliceblue;
margin: auto;
border:1px solid red;
width:90%;
height:60px;
text-align: right;
}
.product_parent_ul{
list-style-type: none;
}
.container{
width: 70%;
margin: auto;
}
.upload-hidden{
width: 0px;
height: 0px;
}
.main{
margin: auto;
width: 70%;
text-align: center;
font-size: 2rem;
margin-top: 150px;
}
.mfile{
float: left;
height: 100%;
border: 3px solid blue;
}
.thumbnail{
width: 70%;
margin: auto;
text-align: center;
border: 1px solid red;
font-size: 2rem;
height: 700px;
}
.image_container{
margin: auto;
max-width:500px;
max-height: 1000px;
}
.imgtest{
max-width:500px;
max-height: 1000px;
}
.upload-name{
width: 130px;
font-size: 2rem;
}
.hrClass{
margin-top: 50px;
margin-bottom: 50px;
width: 60%;
}
.product_details{
margin:auto;
width: 50%;
height:700px;
border: 3px solid green;
}
.product_name{
width: 600px;
margin: auto;
font-size: 2rem;
text-align: center;
margin-bottom: 50px;
}
.pName{
width: 300px;
height: 40px;
border: 0;
border-bottom: 2px solid silver;
}
.details_table{
width: 100%;
text-align: center;
}
.details_table td{
border: 1px solid green;
height: 50px;
}
.product_parent_div{
border: 1px solid blue;
width: 70%;
height: 100%;
margin: auto;
}
.createBtn_parent{
width: 100%;
text-align: center;
margin-top: 30px;
margin-bottom: 50px;

}
.createBtn{
width: 200px;
height: 60px;
text-align: center;
color:white;
font-weight:700;
font-size:1.3rem;
border: 20px solid #40c700;
background-color:#40c700;
border-radius: 50px;
}
</style>
</head>
<body>
<%@include file="../Include/header.jsp" %>

<div class="main">
	<h1>상품 등록</h1>
</div>

<hr class =" hrClass">

<div class="product_name">
		<a>상품 이름</a>
		<input type="text" name="pName" class="pName">
</div>

<!--상품등록 div  -->
<div class="product_parent_div" id="product_parent_div">
	<ul class="product_parent_ul" id="product_parent_ul">
		<li class="product_parent_li" id="product_parent_li">
		<!-- 대표상품 -->
			<div class="product_Main">
				<button onclick="mainOpenThis(this)">펼치기</button>
				<table class="product_table" id="product_table">
					<tr>
						<td class="tdMargin">Color <input type="text" class="inputText"></td>
						<td>Size  <input type="text" class="inputText"></td>
					</tr>
					<tr>
						<td class="tdMargin">Stock <input type="text" class="inputText"></td>
						<td>Price <input type="text" class="inputText"></td>
					</tr>
				</table>
			</div>
		</li>
	</ul>
</div>

<div class="createBtn_parent">
	<button class="createBtn" onclick="createDiv()">Option +</button>
</div>

<div class="product_details">
	<h3>상세 정보</h3>
	<table class="details_table">
	<tr>
		<td>카테고리  <select>
		 <option>Outer</option>
		 <option>Top</option>
		 <option>Bottom</option>
		 <option>Set</option>
		 <option>Acc</option>
		 <option>One Piace</option>
		 </select></td>
		<td>
		<select> 
		<option>JACKET</option>
		<option>JUMPER</option>
		<option>CARDIGAN</option>
		<option>COAT</option>
		<option>VEST</option>	
		</select>
		<select> 
		<option>TEE</option>
		<option>KNIT</option>
		<option>SLEEVELESS</option>
		<option>BLOUSE</option>
		<option>HOOD</option>	
		<option>BASIC</option>	
		</select>
		<select> 
		<option>MISS BUMBUM</option>
		<option>PANTS</option>
		<option>LEGGINGS</option>
		<option>JEANS</option>
		<option>SHORTS</option>	
		<option>SKIRT</option>	
		</select>
		<select> 
		<option>SET</option>
		</select>
		<select> 
		<option>DRESS</option>
		<option>JUMP-SUIT</option>
		</select>
		<select> 
		<option>JEWERLY</option>
		<option>LINGERIE</option>
		<option>HAT</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>재고 수량 </td>
		<td>  <input type="text"></td>
	</tr>
	<tr>
		<td>사이즈 </td>
		<td>  <input type="text"></td>
	</tr>
	<tr>
		<td>색상</td>
		<td>상세 정보 </td>
	</tr>
	</table>
	
	
</div>

	
	
	
<div class="thumbnail">
	<div class="mfile" id="mfile">
		<input type="text" class="upload-name" value="파일명" disabled="disabled" id="disnone">
		<label for="ex_filename">대표사진</label> 
		<input type="file" id="ex_filename" class="upload-hidden" name="filename1">
		<div id="image_container" class="image_container">
			<img   id="imgtest" class="imgtest">
		</div>
	</div>
	
</div>

<div class="container">
		<form name="w_form" method="post" action="lectureWrite">
		<input type="hidden" name="filepath" value="/editor/upload/" /> 
		<textarea name="lcContent" id="textAreaContent" style="width: 100%" rows="15" cols="80"></textarea>
		<button class="form-control foode-btn" type="button" onclick="submitContents(this)">글쓰기</button>
		</form>
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
<!-- 스마트 에디터 크기를 쉽게늘리기위한 빈공간 -->
<div style="height: 100px;"></div>
</body>
</html>