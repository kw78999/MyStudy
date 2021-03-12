<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>
<div class="container">
	<div class="section-heading">
		<h2>글 등록</h2>
	</div>
	<form name="w_form" method="post" action="lectureWrite">
		<input type="hidden" name="filepath" value="/editor/upload/" /> 
		<input type="hidden" name="userID" value="admin" />
		<input type="hidden" name="ctNum" value="${ctNum}" />
		<label class="form-control-label">제목</label> 
		<input type="text" class="form-control" name="lcTitle" required> 
		<label class="form-control-label">내용</label> 
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

<%@include file="../include/footer.jsp"%>
</body>
</html>