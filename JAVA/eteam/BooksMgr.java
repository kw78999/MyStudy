package eteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB와 연동에 필요한 모든 기능
public class BooksMgr {
	
	//DB 연결 객체 10개 만들어 놓음.
	private DBConnectionMgr pool;
	private PreparedStatement pstmt;
	private String sql;
	
	public BooksMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//리스트 : 
	//제네릭 : Vector에 저장되는 타입을 MemberBean 지정(옵션)
	public Vector<BooksBean> getListMember(){
		//DB연결 실행 공식
		Connection con = null;//DB연결 객체
		PreparedStatement pstmt = null;//sql문 만드는 객체
		ResultSet rs = null;//select문 실행 결과값 리턴 객체
		String sql = null;
		Vector<BooksBean> vlist = new Vector<BooksBean>();
		try {
			//pool 객체에서 빌려옴
			con = pool.getConnection();
			//sql문 선언
			sql = "select * from BOOKS order by 1";
			//DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB 실행 후 결과값 리턴
			while(rs.next()/*현재 cursor에서 다음 cursor로 이동*/) {
				BooksBean bean = new BooksBean();
				bean.setBID(rs.getInt("BID"));
				bean.setISBN(rs.getString("ISBN"));
				bean.setTITLE(rs.getString("TITLE"));
				bean.setAUTHOR(rs.getString("AUTHOR"));
				bean.setPUBLISHER(rs.getString("PUBLISHER"));
				bean.setLOCATION(rs.getString("LOCATION"));
				bean.setBOOKSTATE(rs.getString("BOOKSTATE"));
				bean.setBCOPY(rs.getString("BCOPY"));
				bean.setBDATE(rs.getString("BDATE"));
				bean.setBCOUNT(rs.getString("BCOUNT"));
				bean.setBCOUNTP(rs.getString("BCOUNTP"));	
				
				//레코드를 저장시킨 빈즈를 Vector에 저장
				vlist.addElement(bean);
			}//---while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//con은 반납, pstmt이랑 rs는 close 해야함.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//레코드 한개 가져오기
	public BooksBean  getett(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BooksBean bean = new BooksBean();
		try {
			con = pool.getConnection();
			sql = "select * from Books where IDX=?";
			//매개변수 idx를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setBID(rs.getInt(1));//테이블 스키마 인텍스
				bean.setISBN(rs.getString(2));
				bean.setTITLE(rs.getString(3));
				bean.setAUTHOR(rs.getString(4));
				bean.setPUBLISHER(rs.getString(5));
				bean.setBOOKSTATE(rs.getString(6));
				bean.setBCOPY(rs.getString(7));
				bean.setBDATE(rs.getString(8));
				bean.setBCOUNT(rs.getString(9));
				bean.setBCOUNTP(rs.getString(10));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//입력
	public boolean insertBooks(BooksBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into Books(BID,ISBN,TITLE,AUTHOR,PUBLISHER,LOCATION,BOOKSTATE,BCOPY,BDATE,BCOUNT,BCOUNTP)"
					+ "values(seqmember.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getISBN());
			pstmt.setString(2, bean.getTITLE());
			pstmt.setString(3, bean.getAUTHOR());
			pstmt.setString(4, bean.getPUBLISHER());
			pstmt.setString(5, bean.getLOCATION());
			pstmt.setString(6, bean.getBOOKSTATE());
			pstmt.setString(7, bean.getBCOPY());
			pstmt.setString(8, bean.getBDATE());
			pstmt.setString(9, bean.getBCOUNT());
			pstmt.setString(10, bean.getBCOUNTP());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	//수정
	public boolean updateBooks(BooksBean bean) {
		Connection con = null;
		pstmt = null;
		setSql(null);
		boolean flag = false;
		try {
			con = pool.getConnection();
			setSql("update Books set ISBN=? ,TITLE=? ,AUTHOR=? ,PUBLISHER=? ,LOCATION=? ,BOOKSTATE=? ,BCOPY=? ,BDATE=? ,BCOUNT=? ,BCOUNTP=? "
					+ "where BID=?");
			pstmt.setString(1, bean.getISBN());
			pstmt.setString(2, bean.getTITLE());
			pstmt.setString(3, bean.getAUTHOR());
			pstmt.setString(4, bean.getPUBLISHER());
			pstmt.setString(5, bean.getLOCATION());
			pstmt.setString(6, bean.getBOOKSTATE());
			pstmt.setString(7, bean.getBCOPY());
			pstmt.setString(8, bean.getBDATE());
			pstmt.setString(9, bean.getBCOUNT());
			pstmt.setString(10, bean.getBCOUNTP());
			pstmt.setInt(11, bean.getIdx());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//삭제
	public boolean deleteBooks(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from Books where BID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			int cnt = pstmt.executeUpdate();
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
		
	}
	public Vector<BooksBean> getListBook() {
		return null;
	} 
}















