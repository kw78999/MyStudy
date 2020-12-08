<%@ page  contentType="text/html; charset=EUC-KR" %>
<%
		//포스트 방식으로 요청된 값들에 대한 인코딩 설정 
		request.setCharacterEncoding("EUC-KR");
		String name = request.getParameter("name");
		String studentNum = request.getParameter("studentNum");
		String gender = request.getParameter("gender");
		String major = request.getParameter("major");
		String hobby[] = request.getParameterValues("hobby");  //배열을 가져온다 
%>
성명 : <%=name%><br>
학번 : <%=studentNum%><br>
성별 : <%=gender%><br>
전공 : <%=major%><br>
취미 : <%
			for(int i = 0; i<hobby.length;i++){
				out.println(hobby[i]);
			}
%>