
<%@ page  contentType="text/html; charset=EUC-KR"%>
<!-- 선언문(Declaration) -->
<%! 
			String dec = "선언문 변수"	;  //필드
			//메소드 선언
			public String decMethod(){  
					return dec;
			}
%>
<!--  스크립트릿 (scriptlet) -->
<%
			String scriptlet = "스크립트릿";

			out.println("내장객체를 이용한 출력 : "+dec+"<p>");

%>
<!-- 표현문 -->
선언문의 출력1 : <%= dec %><p>
선언문의 출력2 : <%= decMethod() %><p>
스크립트릿의 출력 1: <%=scriptlet%>