<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//응답된 쿠키의 정보는 다시 서버로 요청정보에 저장이 되어 서버에 온다.
		Cookie cookies[] = request.getCookies();
		if(cookies!=null){
			for(int i =0;i<cookies.length;i++){
				%>
					Cookie Name = <%=cookies[i].getName() %><br>
					Cookie Value = <%=cookies[i].getValue() %><br>
				<%
			}
		}
%>
<a href = "cookCookie.jsp">쿠키로</a>