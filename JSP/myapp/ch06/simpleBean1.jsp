<%@page import="ch06.SimpleBean"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		
		String msg = request.getParameter("msg");
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		//DB�� �����ϱ� ���� simpleBean ��ü�� �����Ѵ�.
		SimpleBean bean = new SimpleBean();
		bean.setMsg(msg);
		bean.setCnt(cnt);
		
%>
msg : <%=bean.getMsg()%><br>
cnt : <%=bean.getCnt()%><br>