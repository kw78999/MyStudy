package ch12.com.filter;

import javax.servlet.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class LogFileFilter implements Filter  {
	
	PrintWriter writer;

	public void init(FilterConfig filterConfig) throws ServletException {		
		String filename = filterConfig.getInitParameter("filename");
        if(filename==null) throw new ServletException("�α� ������ �̸��� ã�� �� �����ϴ�.");
        try {
            writer = new PrintWriter(new FileWriter(filename, true), true);
        } catch (IOException e) {
            throw new ServletException("�α� ������ �� �� �����ϴ�.");
        }
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)	throws IOException, ServletException {			
		writer.printf("�����Ͻ� : %s %n",  getCurrentTime());
		String clientAddr = request.getRemoteAddr();
		writer.printf("Ŭ���̾�Ʈ �ּ� : %s %n", clientAddr);
       
        filterChain.doFilter(request, response);    

        String contentType = response.getContentType();
        writer.printf("������ ������ ���� : %s %n", contentType);
        writer.println("----------------------------------------------");
	}

	public void destroy( ){
		writer.close();
	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
