<!-- includeTag1.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%
		//��û�Ǵ� form�� post ����� �ѱ� ó��
		request.setCharacterEncoding("EUC-KR");
		//��û�Ǵ� form�� get ����� �ѱ� ó�� : server.xml(63����) 
		//-> URIEncoding="EUC-KR" 
		//get ��İ� a�±� ��ũ ��� ������ ����̴�.
		String name = request.getParameter("name");
%>
<!-- ��û �Ҷ� name���� ���� ��û�� �ȴ�. -->
<jsp:include page="includeTagTop1.jsp" />

