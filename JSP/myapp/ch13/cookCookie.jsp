<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String cookieName = "myCookie";
		//쿠키를 생성
		Cookie cookie = new Cookie(cookieName,"Apple");
		cookie.setMaxAge(60);  //1분 
		//쿠키의 값을 변경
		cookie.setValue("Melone");
		//쿠키의 생성은 서버에서 JSP로 생성을 했지만 ->Client로 보낸다.
		response.addCookie(cookie);
%>

쿠키를 만듭니다.<br>
쿠키 내용 : <a href="tasteCookie.jsp">여기로!!~</a>