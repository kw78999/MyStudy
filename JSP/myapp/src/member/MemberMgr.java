package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import ch06.TeamBean;

public class MemberMgr {

	private DBConnectionMgr pool;
	
	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//�α��� : �����϶��� true
	//
	public boolean loginmember(String id,String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select id from tblmember where id =? and pwd =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs = pstmt.executeQuery();
			flag = rs.next();
			//if(rs.next())
				//flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//id�ߺ� üũ :�ߺ��̶�� true
	public boolean checkId(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "select id from tblMember where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			if(rs.next())
				flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
		
		
	}
	//�ּҰ˻�
	public Vector<ZipcodeBean> searchZipcode(String area3){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblZipcode where area3 like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"%"+area3+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				ZipcodeBean bean = new ZipcodeBean();
				bean.setZipcode(rs.getString("zipcode"));
				bean.setArea1(rs.getString("area1"));
				bean.setArea2(rs.getString("area2"));
				bean.setArea3(rs.getString("area3"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	
	}
	
	//ȸ������
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert tblMember(id,pwd,name,gender,"
					+ "birthday,email,zipcode,address,hobby,job)"
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,bean.getId());
			pstmt.setString(2,bean.getPwd());
			pstmt.setString(3,bean.getName());
			pstmt.setString(4,bean.getGender());
			pstmt.setString(5,bean.getBirthday());
			pstmt.setString(6,bean.getEmail());
			pstmt.setString(7,bean.getZipcode());
			pstmt.setString(8,bean.getAddress());
			//////////////////////////////////
			String lists[] = {"���ͳ�", "����", "����", "��ȭ", "�"};
			String hobby[] = bean.getHobby();//���ͳ� ���� � üũ����->10101
			char hb[] = {'0','0','0','0','0'};
			for (int i = 0; i < hobby.length; i++) {   //3
				for (int j = 0; j < lists.length; j++) {       //5
					if(hobby[i].equals(lists[j])) {
						hb[j]='1';
						break;
					}
				}
			}
			pstmt.setString(9,new String(hb));//�迭 1,0,1,0,1��
																			//���ڿ� 10101�� �����̵ȴ�
			///////////////////////////////////
			pstmt.setString(10,bean.getJob());
			
			if(pstmt.executeUpdate()==1)flag =true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
}
