package in;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class AnswerMgr {
	private DBConnectionMgr pool;
	
	public AnswerMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//답변입력
	public boolean insertAnswer(AnswerBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert in_answer(qnum,id,content,date) values(?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bean.getQnum());
			pstmt.setString(2,"session등록하세요");
			pstmt.setString(3,bean.getContent());
			if(pstmt.executeUpdate()==1)flag=true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	// 답변 가져오기
		public Vector<AnswerBean> getAnswerList(int qnum){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<AnswerBean> vlist = new Vector<AnswerBean>();
			try {
				con = pool.getConnection();
				sql = "select * from in_answer where qnum = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,qnum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AnswerBean bean = new AnswerBean();
				bean.setId(rs.getString("id"));
				bean.setGrade(rs.getString("grade"));
				bean.setContent(rs.getString("content"));
				bean.setDate(rs.getString("date"));
				vlist.addElement(bean);
			  }
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;
		}
		
	
}
