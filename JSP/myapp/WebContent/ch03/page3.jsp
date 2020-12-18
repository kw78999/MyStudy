<%@page contentType="text/html; charset=EUC-KR"
		          pageEncoding="UTF-8" 
		          trimDirectiveWhitespaces="true"   
		          isELIgnored="true"       
%>
<%
		request.setCharacterEncoding("EUC-KR");
		String str = "jspstudy.co.kr";
		request.setAttribute("site", str);
%>
<body>
세션ID : <%=session.getId() %><br>
사이트명 : ${site}
</body>