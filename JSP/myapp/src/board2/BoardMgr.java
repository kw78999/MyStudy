package board2;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardMgr {
	
	private DBConnectionMgr pool;
	public static final String SAVEFOLDER = "C:/Jsp/myapp/WebContent/board/fileupload/";
	public static final String ENCTYPE = "EUC-KR";
	public static int MAXSIZE = 10*1024*1024;//10MB
	
	public BoardMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//Board Insert
	public void insertBoard(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			/////파일업로드//////////////////////////
			File dir = new File(SAVEFOLDER);
			if(!dir.exists())//폴더가 없다면 
				dir.mkdirs();
			//mkdir : 상위폴더가 없으면 생성불가
			//mkdirs : 상위폴더가 없어도 생성가능
			MultipartRequest multi = 
					new MultipartRequest(req, SAVEFOLDER,MAXSIZE,ENCTYPE
							,new DefaultFileRenamePolicy());
			String filename = null;
			int filesize = 0;
			if(multi.getFilesystemName("filename")!=null) {
				//게시물에 파일 업로드
				filename = multi.getFilesystemName("filename");
				filesize = (int)multi.getFile("filename").length();
			}
			String content = multi.getParameter("content");//게시물 내용
			String contentType = multi.getParameter("contentType");//내용타입
			if(contentType.equals("TEXT")) {
				content = UtilMgr.replace(content, "<", "&lt;");
			}
			//답변을 위한 ref 설정
			int ref = getMaxNum() + 1;
			/////////////////////////////////////
			con = pool.getConnection();
			sql = "insert tblBoard(name,content,subject,ref,pos,depth,";
			sql += "regdate,pass,count,ip,filename,filesize)";
			sql += "values(?, ?, ?, ?, 0, 0, now(), ?, 0, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, multi.getParameter("name"));
			pstmt.setString(2, content);
			pstmt.setString(3, multi.getParameter("subject"));
			pstmt.setInt(4, ref);
			pstmt.setString(5, multi.getParameter("pass"));
			pstmt.setString(6, multi.getParameter("ip"));
			pstmt.setString(7, filename);
			pstmt.setInt(8, filesize);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	//Board Max Num : num의 최대값
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int maxNum = 0;
		try {
			con = pool.getConnection();
			sql = "select max(num) from tblBoard";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) maxNum = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return maxNum;
	}
	
	//Board Total Count : 총 게시물수
	public int getTotalCount(String keyField, String keyWord) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int totalCount = 0;
		try {
			con = pool.getConnection();
			if(keyWord.trim().equals("")||keyWord==null) {
				//검색이 아닌경우
				sql = "select count(*) from tblBoard";
				pstmt = con.prepareStatement(sql);
			}else {
				//검색인 경우
				sql = "select count(*) from tblBoard where " 
				+ keyField +" like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyWord+"%");
			}
			rs = pstmt.executeQuery();
			if(rs.next()) totalCount = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return totalCount;
	}
	
	//Board List : 검색 기능(keyField, keyWord)
	public Vector<BoardBean> getBoardList(String keyFileld, 
			String keyWord, int start, int cnt){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<BoardBean> vlist= new Vector<BoardBean>();
		try {
			con = pool.getConnection();
			if(keyWord.trim().equals("")||keyWord==null) {
				//검색이 아닐때
				sql = "select * from tblBoard order by ref desc, pos limit ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, cnt);
			}else {
				//검색일때
				sql = "select * from tblBoard where " + keyFileld 
						+ " like ? order by ref desc, pos limit ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyWord+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, cnt);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setPos(rs.getInt("pos"));
				bean.setRef(rs.getInt("ref"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setCount(rs.getInt("count"));
				bean.setFilename(rs.getString("filename"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	
	//Board Get : 하나의 게시물 리턴
	//Board Get : 한개의 게시물, 13개 컬럼 모두 리턴
		public BoardBean getBoard(int num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			BoardBean bean = new BoardBean();
			try {
				con = pool.getConnection();
				sql = "select * from tblBoard where num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					bean.setNum(rs.getInt("num"));
					bean.setName(rs.getString("name"));
					bean.setSubject(rs.getString("subject"));
					bean.setContent(rs.getString("content"));
					bean.setPos(rs.getInt("pos"));
					bean.setRef(rs.getInt("ref"));
					bean.setDepth(rs.getInt("depth"));
					bean.setRegdate(rs.getString("regdate"));
					bean.setPass(rs.getString("pass"));
					bean.setIp(rs.getString("ip"));
					bean.setCount(rs.getInt("count"));
					bean.setFilename(rs.getString("filename"));
					bean.setFilesize(rs.getInt("filesize"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;
		}
	//Count Up : 조회수 증가
		public void upCount(int num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				sql = "update tblBoard set count = count +1 where num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}
	//Board Delete : 파일업로드 파일 삭제
		public void deleteBoard(int num,String filename) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				if(filename!=null&&!filename.equals("")) {
					File f = new File(SAVEFOLDER+filename);
					if(f.exists())
						UtilMgr.delete(SAVEFOLDER+filename);
				}
				con = pool.getConnection();
				sql = "delete from tblBoard where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}
	
	//Board Update:파일업로드 수정
		public void updateBoard(MultipartRequest multi) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				int num=Integer.parseInt(multi.getParameter("num"));
				String name=multi.getParameter("name");
				String subject=multi.getParameter("subject");
				String content=multi.getParameter("content");
				String filename=multi.getFilesystemName("filename");
				if(filename!=null&&!filename.equals("")) {
					//파일이 업로드 수정이되면 기존에 파일은 삭제한다
					BoardBean bean = getBoard(num);
					String tempfile=bean.getFilename();
					if(tempfile!=null&&!tempfile.equals("")) {
						 //기존에 파일이 있다면
						File f = new File(SAVEFOLDER+tempfile);
						if(f.exists()) {
							UtilMgr.delete(SAVEFOLDER+tempfile);
						}
					}
					int filesize = (int)multi.getFile("filename").length();
					sql = "update tblboard set name=?, subject=?, content=?, filename=?, filesize=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, subject);
					pstmt.setString(3, content);
					pstmt.setString(4, filename);
					pstmt.setInt(5, filesize);
					pstmt.setInt(6, num);
				}else {
					sql = "update tblboard set name=?, subject=?, content=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, subject);
					pstmt.setString(3, content);
					pstmt.setInt(4, num);
				}
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}
		
	//Board Reply : 답변글 입력
	public void replyBoard(BoardBean bean) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		sql = "insert tblBoard(name,content,subject,ref,pos,depth,regdate,"
				+ "pass,count,ip)values(?, ?, ?, ?, ?, ?, now(), ?, 0, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getContent());
		pstmt.setString(3, bean.getSubject());
		///////////////////////////////////
		//ref=답변 글들의 그룹컬럼
		pstmt.setInt(4, bean.getRef());//원글과 동일한 ref값으로 저장 
		//pos  = 답변글들의 정렬값
		pstmt.setInt(5, bean.getPos()+1); //원글의 pos +1 
		//depth = 답변글의 깊이
		pstmt.setInt(6,bean.getDepth()+1); //원글의 depth +1 
		///////////////////////////////////
		pstmt.setString(7, bean.getPass());
		pstmt.setString(8, bean.getIp());
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
}
	//Board Reply Up : 답변글 위치값 조정
	public void replyUpBoard(int ref,int pos) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "update tblBoard set pos=pos+1 where ref=? and pos>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,ref);
			pstmt.setInt(2,pos);
		    pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return;
	}
	public void post1000(){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "insert tblBoard(name,content,subject,ref,pos,depth,regdate,pass,count,ip,filename,filesize)";
			sql+="values('aaa', 'bbb', 'ccc', 0, 0, 0, now(), '1111',0, '127.0.0.1', null, 0);";
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < 1000; i++) {
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
}






