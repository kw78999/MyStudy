<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//업로드 파일 저장 위치
		final String SAVEFOLDER = "C:/Jsp/myapp/WebContent/upload/storage/";
		//업로드 파일명 인코딩
		final String ENCODING = "EUC-KR";
		//업로드 파일 크기
		final int MAXSIZE = 1024*1024*10;//10MB 
		try{
			//객체 생성이 되면 파일업로드 완료 -> request 객체는 null
			MultipartRequest multi = new MultipartRequest(request,SAVEFOLDER,MAXSIZE,ENCODING,
					new DefaultFileRenamePolicy());
			String user=multi.getParameter("user");
			String title=multi.getParameter("title");
			//upload 는 form에 type이 file의 name값
			String fileName = multi.getFilesystemName("upload");
			String fileType = multi.getContentType("upload");
			//파일의 정보
			File f = multi.getFile("upload");
			long len = 0;
			if(f!=null){
				len=f.length();
			}
			out.println("파일명 : "+fileName+"<br>");
			out.println("파일타입 : "+fileType+"<br>");
			out.println("파일크기 : "+len+"byte <br>");
			out.println("user : "+user+"<br>");
			out.println("title : "+title+"<br>");
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
%>