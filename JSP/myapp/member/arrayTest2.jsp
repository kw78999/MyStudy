
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//form �� �ΰ��̻��� ������ name ���� ��û�Ǹ� �ڵ����� �迭ó�� �ȴ�.
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