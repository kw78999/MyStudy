<%@ page  contentType="text/html; charset=EUC-KR"
						buffer="1kb"%>
<%
		request.setCharacterEncoding("EUC-KR");
		int totalBuffer = out.getBufferSize();
		int remainBuffer = out.getRemaining();
		int useBuffer = totalBuffer - remainBuffer;
		out.println("��� ������ ��ü ũ�� : "+ totalBuffer+"<br>");
		out.println("���� ������ ��ü ũ�� : "+remainBuffer+"<br>");
		out.println("��� ������ ��ü ũ�� : "+ useBuffer+"<br>");
		
		String arr[] = {"Java","JSP","Android","Kotlin"};
		for(int i = 0 ; i <arr.length;i++)
			out.println(arr[i]+"<br>");
%>