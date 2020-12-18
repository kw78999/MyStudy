package ch02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ch06.DBConnectionMgr;

public class CalcMgr {

	//固府 mysql 立加 按眉甫 10俺 父惦 
	private DBConnectionMgr pool;
	
	public CalcMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	public void insertTeam(CalcBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "insert calc(operation,result)values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getOperation());
			pstmt.setString(2, bean.getResult());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return;
	}
}
