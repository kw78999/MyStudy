<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		
%>
<form method="post" enctype="multipart/form-data" action="viewpage.jsp">
	user : <input name="user" value="ȫ�浿"><br>
	title : <input name="title" value="���Ͼ��ε�"><br>
	file : <input type="file" name="upload"><br>
	<input type="submit" value="��������">
</form>