package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB�� ������ �ʿ��� ��� ���
public class MemberMgr {

	//DB���� ��ü 10�� ����� ���� . 
	private DBConnectionMgr pool;
	
	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//����Ʈ
	//Vector �� ����Ʈ 10���� �������� 
	//Object Ÿ���� ��� ��ü�� Ÿ�Ի������ �������ִ� ��ü�� �ִ� ��ü
	//���׸� : Vector �� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<MemberBean> getListMember(){
	//DB���ῡ�� ���� �Ҷ��� �������ִ�
	 Connection con = null;//DB���� ��ü
	 PreparedStatement pstmt = null; //sql�� ����� ��ü
	 ResultSet rs = null; // select �� ���� ����� ���� ��ü
	 String sql = null;
	 Vector<MemberBean> vlist = new Vector<MemberBean>();
	 try {
		 //pool ��ü���� ������
		 con = pool.getConnection();
		 //sql�� ����
		 sql = "select * from tblMember";
		 //DB�� �����ϱ� ���� pstmt�� ����
		 pstmt = con.prepareStatement(sql);
		 rs = pstmt.executeQuery(); //DB ������ ����� ���� 
		 while(rs.next()/*���� cursor ���� ���� cursor�� �̵�*/) {
			 MemberBean bean = new MemberBean();
			 bean.setIdx(rs.getInt("idx"));
			 bean.setName(rs.getString("name"));
			 bean.setPhone(rs.getString("phone"));
			 bean.setTeam(rs.getString("team"));
			 //���ڵ带 �����Ų ��� Vector �� ���� 
			 vlist.addElement(bean);
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }finally {
		 //con �� �ݳ�,pstmt�̶� rs�� close �ؾ���.
		 pool.freeConnection(con,pstmt,rs);
	 }
	return vlist;
	}
	//���ڵ� �Ѱ� ��������
	public MemberBean  getMember(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblMember where idx=? ";
			//�Ű����� idx�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setIdx(rs.getInt(1));//���̺� ��Ű�� �ε��� 
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
	//�Է�
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

	//����
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
	//����
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
				int cnt = pstmt.executeUpdate();//insert,update,delete �� executeUpdate �� ����Ѵ�
				if(cnt==1)flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
			
			
		}
}
