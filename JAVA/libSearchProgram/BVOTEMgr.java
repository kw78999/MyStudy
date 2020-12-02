package libSearchProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB�� ������ �ʿ��� ��� ���
public class BVOTEMgr {
	
	//DB ���� ��ü 10�� ����� ����.
	private DBConnectionMgr pool;
	private PreparedStatement pstmt;
	private String sql;
	
	public BVOTEMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//����Ʈ : 
	//���׸� : Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<BVOTEBean> getListVOTE(){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<BVOTEBean> vlist = new Vector<BVOTEBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select * from BVOTE order by 1";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
				BVOTEBean bean = new BVOTEBean();
				bean.setVTITLE(rs.getString("VTITLE"));
				bean.setVAUTHOR(rs.getString("VAUTHOR"));
				bean.setVPUBLISHER(rs.getString("VPUBLISHER"));
				bean.setVLIKE(rs.getString("VLIKE"));
				bean.VISBN(rs.getString("VISBN"));

				
				//���ڵ带 �����Ų ��� Vector�� ����
				vlist.addElement(bean);
			}//---while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//con�� �ݳ�, pstmt�̶� rs�� close �ؾ���.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//���ڵ� �Ѱ� ��������
	public BVOTEBean  getett(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BVOTEBean bean = new BVOTEBean();
		try {
			con = pool.getConnection();
			sql = "select * from BVOTE where IDX=?";
			//�Ű����� idx�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//bean.setBID(rs.getInt(1));//���̺� ��Ű�� ���ؽ�
				bean.setVTITLE(rs.getString(1));
				bean.setVAUTHOR(rs.getString(2));
				bean.setVPUBLISHER(rs.getString(3));
				bean.setVLIKE(rs.getString(4));
				bean.setVISBN(rs.getString(5));


				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//�Է�
	public boolean insertBVOTE(BVOTEBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into BVOTE(VTITLE,VAUTHOR,VPUBLISHER,VLIKE,VISBN)"
					+ "values(seqmember.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getVTITLE());
			pstmt.setString(2, bean.getVAUTHOR());
			pstmt.setString(3, bean.getVPUBLISHER());
			pstmt.setString(4, bean.getVLIKE());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	//����
	public boolean updateBVOTE(BVOTEBean bean) {
		Connection con = null;
		pstmt = null;
		setSql(null);
		boolean flag = false;
		try {
			con = pool.getConnection();
			setSql("update BVOTE set VTITLE=? ,VAUTHOR=? ,VPUBLISHER=? ,VLIKE=? ,VISBN=? "
					+ "where BID=?");
			pstmt.setString(1, bean.getVTITLE());
			pstmt.setString(2, bean.getVAUTHOR());
			pstmt.setString(3, bean.getVPUBLISHER());
			pstmt.setString(4, bean.getVLIKE());
			pstmt.setString(5, bean.getVISBN());
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//����
	public boolean deleteBVOTE(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from BVOTE where VTITLE=?";
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















