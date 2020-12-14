package guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class GuestBookMgr {
	
	private DBConnectionMgr pool;
	private final SimpleDateFormat SDF_DATE =
			new SimpleDateFormat("yyyy'년'  M'월' d'일' (E)");
	private final SimpleDateFormat SDF_TIME =
			new SimpleDateFormat("H:mm:ss");
	
	public GuestBookMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//Join Login
	public boolean loginJoin(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select * from tblJoin where id=? and pwd =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			if(pstmt.executeQuery().next())
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	
	//Join Information
	public JoinBean getJoin(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		JoinBean bean = new JoinBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblJoin where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setId(rs.getString(1));
				bean.setPwd(rs.getString(2));
				bean.setName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setHp(rs.getString(5));
				bean.setGrade(rs.getString(6));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	//GuestBook Insert
	public void insertGuestBook(GuestbookBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "insert tblguestbook(id,contents,ip,regdate,regtime,secret)"
					+ "values(?,?,?,now(),now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getContents());
			pstmt.setString(3, bean.getIp());
			pstmt.setString(4, bean.getSecret());
		    pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return;
	}
	//GuestBook List
	public Vector<GuestbookBean> listGuestBook(String id,String grade){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<GuestbookBean> vlist = new Vector<GuestbookBean>();
		try {
			con = pool.getConnection();
			if(grade.equals("1")) {
					sql = "select * from tblGuestBook order by num desc";
		        	pstmt = con.prepareStatement(sql);
			}else if (grade.equals("0")){   //일반 로그인 : 본인+다른사람 일반글
					sql = "select *from tblGuestBook where id =? or secret='0' order by num desc";  //본인글 모두 or 일반글 모두 둘다조회
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestbookBean bean = new GuestbookBean();
				bean.setNum(rs.getInt("num"));
				bean.setId(rs.getString("Id"));
				bean.setContents(rs.getString("contents"));
				bean.setIp(rs.getString("ip"));
				String tempDate = SDF_DATE.format(rs.getDate("regDate"));
				bean.setRegdate(tempDate);
				String tempTime = SDF_TIME.format(rs.getTime("regTime"));
				bean.setRegtime(tempTime);
				bean.setSecret(rs.getString("secret"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	//GuestBook Read  날짜와 시간은 list 동일하게
	public GuestbookBean getGuestBook(int num){
		
		
		return bean;
	}
	
	//GuestBook Update : Contents,ip,secrt
	public void updateGuestBook(GuestbookBean bean) {}
	//GuestBook Delete
	public void deleteGuestBook(int num) {}
}






