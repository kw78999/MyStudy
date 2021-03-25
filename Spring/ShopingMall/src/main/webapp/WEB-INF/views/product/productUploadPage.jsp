<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/productUpload.css" />
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>

//버튼 마우스 오버 아웃 이벤트
function openOver(obj) {
	obj.parentNode.style.border="5px solid green";
}
function delOver(obj) {
	obj.parentNode.style.border="5px solid brown";
}
function mouseOut(obj) {
	obj.parentNode.style.border="5px solid white";
}



//서브카테고리 모두 안보이게
function subCategoryView() {
	
	var subCategory = document.getElementsByClassName('subCategory');
	for (var i=0; i<subCategory.length; i++) {
		subCategory[i].style.display='none';
		subCategory[i].setAttribute("name","");
		}
	
}
//메인 카테고리 바뀔때마다 서브카테고리 변경
function category_change(obj) {
	document.getElementById('select').disabled = 'disabled';
	var subCategory = document.getElementsByClassName('subCategory');
	
	
	if(obj.value=="Outer"){
		subCategoryView();
		document.getElementById("outer").style.display = 'block';
		document.getElementById("outer").setAttribute("name","categorySub");
	}else if(obj.value=="Top"){
		subCategoryView();
		document.getElementById("top").style.display = 'block';
		document.getElementById("top").setAttribute("name","categorySub");
	}else if(obj.value=="Bottom"){
		subCategoryView();
		document.getElementById("bottom").style.display = 'block';
		document.getElementById("bottom").setAttribute("name","categorySub");
	}else if(obj.value=="Set"){
		subCategoryView();
		document.getElementById("set").style.display = 'block';
		document.getElementById("set").setAttribute("name","categorySub");
	}else if(obj.value=="Acc"){
		subCategoryView();
		document.getElementById("acc").style.display = 'block';
		document.getElementById("acc").setAttribute("name","categorySub");
	}else if(obj.value=="One Piace"){
		subCategoryView();
		document.getElementById("onepiace").style.display = 'block';
		document.getElementById("onepiace").setAttribute("name","categorySub");
	}
	
	
	
}
function setThumbnail(event) {
	 
	var reader = new FileReader();
	reader.onload = function(event) {
		
		var view = document.getElementById("image_container");
		view.style.display="block";
		
		var img = document.getElementById("thumbnail_imgtest");
		img.setAttribute("src", event.target.result);
		
		var thumbnail_img = document.getElementById("thumbnail_img");
		thumbnail_img.setAttribute("src", event.target.result);
		
		};
		reader.readAsDataURL(event.target.files[0]);
		}
		
/////////////////////////////////////////////////////////////////////////////	
function setNone() {
		var view = document.getElementById("image_container");
		view.style.display="none";
}
//////////////////////////////////////////////////////////////////////////
//파일 체인지를 기다리는 이벤트
$(document).ready(function(){
	var fileTarget = $('.mfile .upload-hidden');
	fileTarget.on('change', function(){ // 값이 변경되면
		if(window.FileReader){ // modern browser
			var filename = $(this)[0].files[0].name;
		} else { // old IE
			var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출
		}

	var fileType=filename.substring(filename.length-3,filename.length); //파일확장자 추출
	
if(fileType=='jpg'||fileType=='png'||fileType=='gif'){   //파일확장자 검사하여 미리보기 끄고 켜기
	setThumbnail(event);
}else{
	setNone();
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
	if(obj.parentNode.style.height=='350px'){
		obj.parentNode.style.height = '30px';
		obj.nextSibling.nextSibling.style.display='none';
		obj.parentNode.lastChild.style.display='none';
		obj.parentNode.firstChild.style.display='block';
		obj.innerHTML="펼치기";
		obj.style.color="#40c700";
		
		//input value를 optionDiv로 이동시키기 
		var inp = obj.parentNode.getElementsByTagName('input');//4개
		var optionDiv = obj.parentNode.getElementsByTagName('div');//5개
		
		optionDiv.item(1).innerHTML="Color : "+inp.item(0).value;
		optionDiv.item(2).innerHTML="Size : "+inp.item(1).value;
		optionDiv.item(3).innerHTML="Stock : "+inp.item(2).value;
		optionDiv.item(4).innerHTML="Price : "+inp.item(3).value;
		
	//펼치기
	}else{
		obj.parentNode.style.height = '350px';
		obj.parentNode.lastChild.style.display='table';
		obj.nextSibling.nextSibling.style.display='block';
		obj.parentNode.firstChild.style.display='none';
		obj.innerHTML="접기";
		obj.style.color="red";
	}
}


//메인 상품 펼치고 접는 버튼
function mainOpenThis(obj) {
	 detailDiv=obj.parentNode.firstChild.nextSibling;
	
	 color = document.getElementById('detail_color');
	 size = document.getElementById('detail_size');
	 stock = document.getElementById('detail_stock');
	 price = document.getElementById('detail_price');
	 
	 size_table = document.getElementById('size_table');
	 
	var pDiv= document.getElementById('product_detail_div');
	
	//접기
	if(obj.parentNode.style.height=='350px'){
		
		obj.parentNode.style.height = '30px';
		obj.nextSibling.nextSibling.style.display='none';
		size_table.style.display='none';
		pDiv.style.display='block';
		obj.innerHTML="펼치기";
		obj.style.color="#40c700";
		
		//div 속 div노드를 찾아 속성값 적용
		var divs =detailDiv.getElementsByTagName("div");
		divs.item(0).innerHTML = "Color : "+color.value;
		divs.item(1).innerHTML = "Size : "+size.value;
		divs.item(2).innerHTML = "Stock : "+stock.value;
		divs.item(3).innerHTML = "Price : "+price.value;
		
		
	//펼치기
	}else{
		
		obj.parentNode.style.height = '350px';
		obj.nextSibling.nextSibling.style.display='block';
		size_table.style.display='table';
		pDiv.style.display='none';
		obj.innerHTML="접기";
		obj.style.color="red";
	}
}

//옵션추가시 div생성
function createDiv() {
	var parent_div = document.getElementById("product_parent_div");
	var parent_ul = document.getElementById("product_parent_ul");
   	
   	   //ul에 붙힐 li생성
       var parent_li = document.createElement("li");
       parent_li.setAttribute("class","product_parent_li");
       
       //li에 붙힐 div 생성  
	   mainDiv=document.createElement("div");
	   mainDiv.setAttribute("class","product_Main");
	   
	   
		
	   //미리보기 div 4개 만들기
	   optionDiv=document.createElement("div");
	   optionDiv.setAttribute("class","product_detail_div_option");
	   optionDiv.innerHTML="Color : ";
	   optionDiv2=document.createElement("div");
	   optionDiv2.setAttribute("class","product_detail_div_option");
	   optionDiv2.innerHTML="Size : ";
	   optionDiv3=document.createElement("div");
	   optionDiv3.setAttribute("class","product_detail_div_option");
	   optionDiv3.innerHTML="Stock : ";
	   optionDiv4=document.createElement("div");
	   optionDiv4.setAttribute("class","product_detail_div_option");
	   optionDiv4.innerHTML="Price : ";
	   
	   //미리보기 div4개 붙이기
	   detailDiv=document.createElement("div");
	   detailDiv.setAttribute("class","product_detail_div");
	   detailDiv.setAttribute("id","product_detail_div");
	   detailDiv.appendChild(optionDiv);
	   detailDiv.appendChild(optionDiv2);
	   detailDiv.appendChild(optionDiv3);
	   detailDiv.appendChild(optionDiv4);
	   
	   
	   //div에 붙힐 삭제 버튼 생성
       dbtn=document.createElement("button");
       dbtn.setAttribute("type","button");
       dbtn.setAttribute("class","deleteBtn");
       dbtn.setAttribute("onclick","delthis(this);");
       dbtn.setAttribute("onmouseover","delOver(this);");
       dbtn.setAttribute("onmouseout","mouseOut(this);");
       dbtn.innerHTML="삭제";
       
     //div에 붙힐 열고 닫는 버튼 생성
       obtn=document.createElement("button");
       obtn.setAttribute("type","button");
       obtn.setAttribute("class","openBtn");
       obtn.setAttribute("onclick","openThis(this)");
       obtn.setAttribute("onmouseover","openOver(this)");
       obtn.setAttribute("onmouseout","mouseOut(this)");
       obtn.innerHTML="펼치기";
       
       //세부정보 입력받는 테이블 생성
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
       
       //세부 사이즈 입력받는 테이블 생성
       sizeTable=document.createElement('table');
       sizeTable.setAttribute("class","size_table");
       sizeTable.setAttribute("id","size_table");
       
       //첫번째 tr과 td연결 
       ftr=document.createElement('tr');
       ftd1=document.createElement('td');
       ftd2=document.createElement('td');
       ftd3=document.createElement('td');
       ftd4=document.createElement('td');
       ftd5=document.createElement('td');
       ftd6=document.createElement('td');
       
       ftd1.innerHTML="어깨";
       ftd2.innerHTML="가슴";
       ftd3.innerHTML="팔길이";
       ftd4.innerHTML="암홀";
       ftd5.innerHTML="밑단";
       ftd6.innerHTML="총길이";
       
       ftr.appendChild(ftd1);
       ftr.appendChild(ftd2);
       ftr.appendChild(ftd3);
       ftr.appendChild(ftd4);
       ftr.appendChild(ftd5);
       ftr.appendChild(ftd6);
       sizeTable.appendChild(ftr);
       
       //두번째 tr과 td연결
       str=document.createElement('tr');
       std1=document.createElement('td');
       std2=document.createElement('td');
       std3=document.createElement('td');
       std4=document.createElement('td');
       std5=document.createElement('td');
       std6=document.createElement('td');
       
       std1.innerHTML='<input type="text" class="size_text" maxlength="5">';
       std2.innerHTML='<input type="text" class="size_text" maxlength="5">';
       std3.innerHTML='<input type="text" class="size_text" maxlength="5">';
       std4.innerHTML='<input type="text" class="size_text" maxlength="5">';
       std5.innerHTML='<input type="text" class="size_text" maxlength="5">';
       std6.innerHTML='<input type="text" class="size_text" maxlength="5">';
       
       str.appendChild(std1);
       str.appendChild(std2);
       str.appendChild(std3);
       str.appendChild(std4);
       str.appendChild(std5);
       str.appendChild(std6);
       sizeTable.appendChild(str);
       
       
       
       
       
       
       
       parent_ul.appendChild(parent_li);        //ul에 li부착
       parent_li.appendChild(mainDiv);   	 //li에 div 부착
       mainDiv.appendChild(detailDiv);    //div에 미리보기 div부착
       mainDiv.appendChild(obtn);    //div에 버튼 부착
       mainDiv.appendChild(dbtn);    //div에 버튼 부착
       mainDiv.appendChild(otionTable);
       mainDiv.appendChild(sizeTable);
       
}
</script>

</head>
<body>
<%@include file="../Include/header.jsp" %>

<div class="main">
	<h1>상품 등록</h1>
</div>

<hr class =" hrClass">
<form name="w_form" method="post" action="productUpload">
<div class="product_name">
		<a>상품 이름</a>
		<input type="text" name="pName" class="pName">
</div>


<div class="product_details">
	<h3>상세 정보</h3>
	<table class="details_table">
	<tr>
	<td colspan="2">카테고리</td>
	</tr>
	<tr>
		<td width="400px">
		<select id="product_category" class="product_category" onchange="category_change(this)" name="category">
		 <option id="select">선택</option>
		 <option value="Outer">Outer</option>
		 <option value="Top">Top</option>
		 <option value="Bottom">Bottom</option>
		 <option value="Set">Set</option>
		 <option value="Acc">Acc</option>
		 <option value="One Piace">One Piace</option>
		 </select></td>
		<td width="400px" align="center">
		<select id="outer" class="subCategory" name="categorySub"> 
		<option value="JACKET">JACKET</option>
		<option value="JUMPER">JUMPER</option>
		<option value="CARDIGAN">CARDIGAN</option>
		<option value="COAT">COAT</option>
		<option value="VEST">VEST</option>	
		</select>
		<select id="top" class="subCategory" name="categorySub"> 
		<option value="TEE">TEE</option>
		<option value="KNIT">KNIT</option>
		<option value="SLEEVELESS">SLEEVELESS</option>
		<option value="BLOUSE">BLOUSE</option>
		<option value="HOOD">HOOD</option>	
		<option value="BASIC">BASIC</option>	
		</select>
		<select id="bottom" class="subCategory" name="categorySub"> 
		<option value="MISS BUMBUM">MISS BUMBUM</option>
		<option value="PANTS">PANTS</option>
		<option value="LEGGINGS">LEGGINGS</option>
		<option value="JEANS">JEANS</option>
		<option value="SHORTS">SHORTS</option>	
		<option value="SKIRT">SKIRT</option>	
		</select>
		<select id="set" class="subCategory" name="categorySub"> 
		<option value="SET">SET</option>
		</select>
		<select id="onepiace" class="subCategory" name="categorySub"> 
		<option value="DRESS">DRESS</option>
		<option value="JUMP-SUIT">JUMP-SUIT</option>
		</select>
		<select id="acc" class="subCategory" name="categorySub"> 
		<option value="JEWERLY">JEWERLY</option>
		<option value="LINGERIE">LINGERIE</option>
		<option value="HAT">HAT</option>
		</select>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">상품 정보</td>
	</tr>
	<tr>
	<td colspan="2"><textarea class="detail_area" placeholder="간단한 상품 정보" name="character1" ></textarea></td>
	</tr>
	</table>
	
	
</div>


<!--상품등록 div  -->
<div class="product_parent_div" id="product_parent_div">
<h1>세부 옵션</h1>
	<ul class="product_parent_ul" id="product_parent_ul">
		<li class="product_parent_li" id="product_parent_li">
		<!-- 대표상품 -->
			<div class="product_Main">
			
				<div id="product_detail_div"class="product_detail_div">
					<div class="product_detail_div_option">Color : </div>
					<div class="product_detail_div_option">Size : </div>
					<div class="product_detail_div_option">Stock : </div>
					<div class="product_detail_div_option">Price : </div>
				</div>
				<button type="button"onclick="mainOpenThis(this)" class="openBtn" id="openBtn" 
				onmouseover="openOver(this)" onmouseout="mouseOut(this)">펼치기</button>
				<table class="product_table" id="product_table">
					<tr>
						<td class="tdMargin">Color <input type="text" class="inputText" id="detail_color" name="color"></td>
						<td>Size  <input type="text" class="inputText" id="detail_size" name="size"></td>
					</tr> 
					<tr>
						<td class="tdMargin">Stock <input type="text" class="inputText" id="detail_stock" name="stock"></td>
						<td>Price <input type="text" class="inputText" id="detail_price" name="price"></td>
					</tr>
				</table>
				
				<table class="size_table" id="size_table">
					<tr class="size_table_first_tr">
						<td>어깨</td>
						<td>가슴</td>
						<td>팔길이</td>
						<td>암홀</td>
						<td>밑단</td>
						<td>총길이</td>
					</tr>
					<tr>
						<td><input type="text" class="size_text" maxlength="5" name="detailSize"></td>
						<td><input type="text" class="size_text" maxlength="5" name="detailSize"></td>
						<td><input type="text" class="size_text" maxlength="5" name="detailSize"></td>
						<td><input type="text" class="size_text" maxlength="5" name="detailSize"></td>
						<td><input type="text" class="size_text" maxlength="5" name="detailSize"></td>
						<td><input type="text" class="size_text" maxlength="5" name="detailSize"></td>
					</tr>
				</table>
				
			</div>
		</li>
	</ul>
</div>

<div class="createBtn_parent">
	<button class="createBtn" onclick="createDiv()">Option +</button>
</div>



	
	
	
<div class="thumbnail_upload">
<h5>대표사진 업로드</h5>
	<div class="mfile" id="mfile">
		<input type="text" class="upload-name" value="파일명" disabled="disabled" id="disnone">
		<label for="ex_filename">업로드</label> 
		<input type="file" id="ex_filename" class="upload-hidden" name="filename1">
		<div id="image_container" class="image_container">
			<img   id="thumbnail_imgtest" class="thumbnail_imgtest">
		</div>
	</div>
	<div class="mfile" id="mfile">
		<input type="text" class="upload-name" value="파일명" disabled="disabled" id="disnone">
		<label for="ex_filename">업로드</label> 
		<input type="file" id="ex_filename" class="upload-hidden" name="filename1">
		<div id="image_container" class="image_container">
			<img   id="thumbnail_imgtest" class="thumbnail_imgtest">
		</div>
	</div>
	<div class="mfile" id="mfile">
		<input type="text" class="upload-name" value="파일명" disabled="disabled" id="disnone">
		<label for="ex_filename">업로드</label> 
		<input type="file" id="ex_filename" class="upload-hidden" name="filename1">
		<div id="image_container" class="image_container">
			<img   id="thumbnail_imgtest" class="thumbnail_imgtest">
		</div>
	</div>
</div>

<div class="thumbnail">
	<h2>대표사진 미리보기</h2>
			<img   id="thumbnail_img" class="thumbnail_img">
</div>





<div class="container">
		
		<input type="hidden" name="filepath" value="/editor/upload/" /> 
		<textarea name="content" id="textAreaContent" style="width: 100%" rows="15" cols="80"></textarea>
		<button class="form-control foode-btn" type="button" onclick="submitContents(this)">글쓰기</button>
</div>
</form>
		
		
		
		
		
		
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
      var con = document.w_form.content;
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