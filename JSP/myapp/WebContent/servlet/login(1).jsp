<%@ page contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//���ǿ� id���� �����´�.
		String id = (String)session.getAttribute("idKey");
%>
<h1>�α���</h1>
<%
		if(id!=null){
%>
<!-- �α��� �� ���� -->
<%=id%>�� �ݰ����ϴ�.
<a href="logout.jsp">�α׾ƿ�</a>
<%			
		}else{
%>
<!-- �α��� �ȵ� ���� -->
<form method="post" action="loginServlet">
id : <input name="id"><br/>
pwd : <input type="password" name="pwd"><br/>
<input type="submit" value="�α���">
</form>
<%}%>





