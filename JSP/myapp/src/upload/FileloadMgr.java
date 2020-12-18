package upload;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileloadMgr {
	
	private DBConnectionMgr pool;
	//���ε� ���� ���� ��ġ
	public static final String SAVEFOLDER = "C:/Jsp/myapp/WebContent/upload/storage/";
	//���ε� ���ϸ� ���ڵ�
	public static final String ENCODING = "EUC-KR";
	//���ε� ���� ũ��
	public static final int MAXSIZE = 1024*1024*10;//10MB
	
	public FileloadMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//��������
	public void uploadFile(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			MultipartRequest multi = new MultipartRequest(req,SAVEFOLDER,MAXSIZE,ENCODING,
					new DefaultFileRenamePolicy());
			String upFile = multi.getFilesystemName("upFile");
			File f = multi.getFile("upFile");
			long size = f.length();
			
			con = pool.getConnection();
			sql = "insert tblFileload (upFile,size)values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upFile);
			pstmt.setLong(2, size);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	//���ϸ���Ʈ
	public Vector<FileloadBean> listFile(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<FileloadBean> vlist = new Vector<FileloadBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblFileload";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FileloadBean bean = new FileloadBean();
				bean.setNum(rs.getInt(1));
				bean.setUpFile(rs.getString(2));
				bean.setSize(rs.getInt(3));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	//���ϻ��� : �������� ���ÿ� ����
	public void deleteFile(int num[]) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			for (int i = 0; i < num.length; i++) {
				//num���´� ���ϸ��� �����´�.
			String upFile = getFile(num[i]);
			//table�� �ִ� ���� ������ �ƴ϶� ���� ���ϵ� ����
			File f = new File(SAVEFOLDER+upFile);
			if(f.exists())f.delete();   //���� ���� 
			sql = "delete from tblFileload where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num[i]);
			pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return;
	}
	//���� ��������
	public String getFile(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String upFile = null;
		try {
			con = pool.getConnection();
			sql = "select upFile from tblFileload where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) upFile=rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return upFile;
	}
	
	
}




















