package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB와 연동에 필요한 모든 기능
public class MemberMgr {

	//DB연결 객체 10개 만들어 놓음 . 
	private DBConnectionMgr pool;
	
	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//리스트
	//Vector 의 디폴트 10개의 공간생성 
	//Object 타입의 모든 객체를 타입상관없이 넣을수있다 객체를 넣는 객체
	//제네릭 : Vector 에 저장되는 타입을 MemberBean 지정(옵션)
	public Vector<MemberBean> getListMember(){
	//DB연결에서 실행 할때는 공식이있다
	 Connection con = null;//DB연결 객체
	 PreparedStatement pstmt = null; //sql문 만드는 객체
	 ResultSet rs = null; // select 문 실행 결과값 리턴 객체
	 String sql = null;
	 Vector<MemberBean> vlist = new Vector<MemberBean>();
	 try {
		 //pool 객체에서 빌려옴
		 con = pool.getConnection();
		 //sql문 선언
		 sql = "select * from tblMember";
		 //DB에 실행하기 위해 pstmt문 생성
		 pstmt = con.prepareStatement(sql);
		 rs = pstmt.executeQuery(); //DB 실행후 결과값 리턴 
		 while(rs.next()/*현재 cursor 에서 다음 cursor로 이동*/) {
			 MemberBean bean = new MemberBean();
			 bean.setIdx(rs.getInt("idx"));
			 bean.setName(rs.getString("name"));
			 bean.setPhone(rs.getString("phone"));
			 bean.setTeam(rs.getString("team"));
			 //레코드를 저장시킨 빈즈를 Vector 에 저장 
			 vlist.addElement(bean);
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }finally {
		 //con 은 반납,pstmt이랑 rs는 close 해야함.
		 pool.freeConnection(con,pstmt,rs);
	 }
	return vlist;
	}
	//레코드 한개 가져오기
	public MemberBean  getMember(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblMember where idx=? ";
			//매개변수 idx를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setIdx(rs.getInt(1));//테이블 스키마 인덱스 
				bean.setName(rs.getString(2));
				bean.setPhone(rs.getString(3));
				bean.setTeam(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	//입력
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into tblMember(idx,name,phone,team)"+"values(seqmember.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getTeam());
			int cnt = pstmt.executeUpdate();
			if(cnt==1)flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	//수정
	public boolean updateMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update tblMember set name  =?,phone =?,team =?"+"where idx =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getTeam());
			pstmt.setInt(4, bean.getIdx());
			int cnt = pstmt.executeUpdate();
			if(cnt==1)flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	//삭제
		public boolean deleteMemvber(int idx) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from tblMember where idx = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				int cnt = pstmt.executeUpdate();//insert,update,delete 는 executeUpdate 를 사용한다
				if(cnt==1)flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
			
			
		}
}
