<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//if.html���� name�̶� color�� ������ -> �޾ƾ��Ѵ�.
		//request ���Ը� ���ؼ� �Ѿ� �´�.
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String msg = "";
		if(color.equals("blue")){
			msg = "�Ķ���";
		}else if (color.equals("red")){
			msg="������";
		}else if (color.equals("orange")){
			msg="������";
		}else{
			msg="��Ÿ";
			color = "white";
		}
%>
<body bgcolor="<%=color %>">
	<%=name %>�� �����ϴ� ������ <%=color %>�Դϴ�.
</body>
