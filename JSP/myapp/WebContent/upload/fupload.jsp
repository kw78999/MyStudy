<!-- fupload.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<!doctype html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check() {
		if(document.forms[0].upFile.value==0){
			alert("파일을 선택하세요.");
			return;
		}
		document.forms[0].submit();
	}
</script>
</head>
<body>
<div align="center">
<h2>File Upload</h2>
<form method="post" action="fuploadProc.jsp?flag=update" 
enctype="multipart/form-data" >
<table border="1">
 <tr>
 	<td>파일선택</td>
 	<td><input type="file" name="upFile"></td>
 </tr>
 <tr>
 	<td colspan="2">
 		<input type="button" value="파일업로드" onclick="check()">
 	</td>
 </tr>
</table>
</form>
<a href="flist.jsp">파일리스트</a>
</div>
</body>
</html>








