<%@ page  contentType="text/html; charset=EUC-KR"
						buffer="1kb"%>
<%
		request.setCharacterEncoding("EUC-KR");
		int totalBuffer = out.getBufferSize();
		int remainBuffer = out.getRemaining();
		int useBuffer = totalBuffer - remainBuffer;
		out.println("출력 버퍼의 전체 크기 : "+ totalBuffer+"<br>");
		out.println("남은 버퍼의 전체 크기 : "+remainBuffer+"<br>");
		out.println("사용 버퍼의 전체 크기 : "+ useBuffer+"<br>");
		
		String arr[] = {"Java","JSP","Android","Kotlin"};
		for(int i = 0 ; i <arr.length;i++)
			out.println(arr[i]+"<br>");
%>