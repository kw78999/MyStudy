package board2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/board/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		HttpSession session = request.getSession();
		BoardBean bean = (BoardBean)session.getAttribute("bean");
		String dbPass = bean.getPass();
		MultipartRequest multi= new MultipartRequest(request, BoardMgr.SAVEFOLDER,
				 BoardMgr.MAXSIZE,BoardMgr.ENCTYPE,new DefaultFileRenamePolicy());
		String inPass = multi.getParameter("pass"); //update.jsp에서 입력한 비번
		 if(dbPass.equals(inPass)) {
			 //수정처리
			 BoardMgr mgr = new BoardMgr();
			 mgr.updateBoard(multi);
			 String nowPage = multi.getParameter("nowPage");
			 String numPerPage = multi.getParameter("numPerPage");
			 response.sendRedirect("read.jsp?nowPage="+nowPage+"&numPerPage="+numPerPage+"&num="+bean.getNum());
		 }else {
			 //script 메세지 처리
			 PrintWriter out = response.getWriter();
			 out.println("<script>");
				out.println("alert('입력하신 비밀번호가 아닙니다.');");
				out.println("history.back();");
				out.println("</script>");
		 }
		
		
		
	}

}
