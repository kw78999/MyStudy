package ch20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChatMgr3 {

		private DBConnectionMgr pool;
		
		public ChatMgr3() {
		
		pool = DBConnectionMgr.getInstance();
		
		
		}
		//로그인
		public boolean loginChk(String id,String pwd) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "select id from tblChat where id=? and pwd=?";
				pstmt = con.prepareStatement(sql);
				//? 세팅
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				flag = rs.next(); //조건에 맞는 결과값이 있으면 true 없으면 false
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return flag;
		}
		
}
