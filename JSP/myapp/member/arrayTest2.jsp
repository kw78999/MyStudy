
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//form 에 두개이상의 동일한 name 으로 요청되면 자동으로 배열처리 된다.
		String hobby[] = request.getParameterValues("hobby");
		for(int i =0;i<hobby.length;i++){
			out.println(hobby[i]);
		}
%><p>
<jsp:useBean id="bean" class="member.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<%
for(int i =0;i<bean.getHobby().length;i++){
			out.print(bean.getHobby()[i]+"<br>");
}

%>