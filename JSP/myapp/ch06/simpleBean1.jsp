<%@page import="ch06.SimpleBean"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		
		String msg = request.getParameter("msg");
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		//DB에 저장하기 위해 simpleBean 객체에 저장한다.
		SimpleBean bean = new SimpleBean();
		bean.setMsg(msg);
		bean.setCnt(cnt);
		
%>
msg : <%=bean.getMsg()%><br>
cnt : <%=bean.getCnt()%><br>