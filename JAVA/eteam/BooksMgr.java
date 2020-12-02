package eteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB�� ������ �ʿ��� ��� ���
public class BooksMgr {
	
	//DB ���� ��ü 10�� ����� ����.
	private DBConnectionMgr pool;
	private PreparedStatement pstmt;
	private String sql;
	
	public BooksMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//����Ʈ : 
	//���׸� : Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<BooksBean> getListMember(){
		//DB���� ���� ����
		Connection con = null;//DB���� ��ü
		PreparedStatement pstmt = null;//sql�� ����� ��ü
		ResultSet rs = null;//select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<BooksBean> vlist = new Vector<BooksBean>();
		try {
			//pool ��ü���� ������
			con = pool.getConnection();
			//sql�� ����
			sql = "select * from BOOKS order by 1";
			//DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//DB ���� �� ����� ����
			while(rs.next()/*���� cursor���� ���� cursor�� �̵�*/) {
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
	public BooksBean  getett(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BooksBean bean = new BooksBean();
		try {
			con = pool.getConnection();
			sql = "select * from Books where IDX=?";
			//�Ű����� idx�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setBID(rs.getInt(1));//���̺� ��Ű�� ���ؽ�
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
	
	//�Է�
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

	//����
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
	
	//����
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















