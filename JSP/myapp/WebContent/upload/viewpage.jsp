<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//���ε� ���� ���� ��ġ
		final String SAVEFOLDER = "C:/Jsp/myapp/WebContent/upload/storage/";
		//���ε� ���ϸ� ���ڵ�
		final String ENCODING = "EUC-KR";
		//���ε� ���� ũ��
		final int MAXSIZE = 1024*1024*10;//10MB 
		try{
			//��ü ������ �Ǹ� ���Ͼ��ε� �Ϸ� -> request ��ü�� null
			MultipartRequest multi = new MultipartRequest(request,SAVEFOLDER,MAXSIZE,ENCODING,
					new DefaultFileRenamePolicy());
			String user=multi.getParameter("user");
			String title=multi.getParameter("title");
			//upload �� form�� type�� file�� name��
			String fileName = multi.getFilesystemName("upload");
			String fileType = multi.getContentType("upload");
			//������ ����
			File f = multi.getFile("upload");
			long len = 0;
			if(f!=null){
				len=f.length();
			}
			out.println("���ϸ� : "+fileName+"<br>");
			out.println("����Ÿ�� : "+fileType+"<br>");
			out.println("����ũ�� : "+len+"byte <br>");
			out.println("user : "+user+"<br>");
			out.println("title : "+title+"<br>");
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
%>