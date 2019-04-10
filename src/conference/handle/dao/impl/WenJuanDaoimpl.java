package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.WenJuan;
import conference.handle.dao.WenJuanDao;
import conference.handle.util.DButil;

public class WenJuanDaoimpl implements WenJuanDao {

	@Override
	public boolean insert(String sql, WenJuan wj) {
		
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			//String sql="insert into from wenjuan values(null,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, wj.getMeet_title());
			ps.setString(2, wj.getWen_juan_theme());
			ps.setString(3, wj.getWen_ti1());
			ps.setString(4, wj.getWen_ti2());
			ps.setString(5, wj.getWen_ti3());
			ps.setString(6, wj.getWen_ti4());
			ps.setString(7, wj.getWen_ti5());
			ps.setInt(8, wj.getOid());
			int result = ps.executeUpdate();
			if(result>0) {
				conn.commit();
			//	String sql1="select from wnjuan where oid=?";
			//	conn.prepareStatement(sql1);
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps);
		}
		return false;
	}

	@Override
	public boolean delete(String sql, int oid,String meet_title) {
		
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ps.setString(2, meet_title);
			int result = ps.executeUpdate();
			if(result>0) {
				conn.commit();
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps);
		}
		return false;
	}

	@Override
	public List<WenJuan> find(String sql, int oid,String meet_title) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			//String sql="insert into from wenjuan values(null,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ps.setString(2, meet_title);
			rs = ps.executeQuery();
			List<WenJuan> list = new ArrayList<>(); 
			
			while(rs.next()) {
				WenJuan wj= new WenJuan();
				wj.setQid(rs.getInt("qid"));
				wj.setMeet_title(rs.getString("meet_title"));
				wj.setWen_juan_theme(rs.getString("wen_juan_theme"));
				wj.setWen_ti1(rs.getString("wen_ti1"));
				wj.setWen_ti2(rs.getString("wen_ti2"));
				wj.setWen_ti3(rs.getString("wen_ti3"));
				wj.setWen_ti4(rs.getString("wen_ti4"));
				wj.setWen_ti5(rs.getString("wen_ti5"));
				wj.setOid(rs.getInt("oid"));
				list.add(wj);
			}
			
			System.out.println(list.get(0).getQid());
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps,rs);
		}
		return null;
	}

	@Override
	public List<WenJuan> findAll() {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			String sql="select * from wenjuan";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<WenJuan> list = new ArrayList<>(); 
			while(rs.next()) {
				WenJuan wj= new WenJuan();
				wj.setQid(rs.getInt("qid"));
				wj.setMeet_title(rs.getString("meet_title"));
				wj.setWen_juan_theme(rs.getString("wen_juan_theme"));
				wj.setWen_ti1(rs.getString("wen_ti1"));
				wj.setWen_ti2(rs.getString("wen_ti2"));
				wj.setWen_ti3(rs.getString("wen_ti3"));
				wj.setWen_ti4(rs.getString("wen_ti4"));
				wj.setWen_ti5(rs.getString("wen_ti5"));
				wj.setOid(rs.getInt("oid"));
				list.add(wj);
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps,rs);
		}
		return null;
	}

	@Override
	public List<WenJuan> find(String sql, WenJuan wj) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			//String sql="select * from wenjuan";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, wj.getQid());
			rs = ps.executeQuery();
			List<WenJuan> list = new ArrayList<>(); 
			while(rs.next()) {
				wj.setQid(rs.getInt("qid"));
				wj.setMeet_title(rs.getString("meet_title"));
				wj.setWen_juan_theme(rs.getString("wen_juan_theme"));
				wj.setWen_ti1(rs.getString("wen_ti1"));
				wj.setWen_ti2(rs.getString("wen_ti2"));
				wj.setWen_ti3(rs.getString("wen_ti3"));
				wj.setWen_ti4(rs.getString("wen_ti4"));
				wj.setWen_ti5(rs.getString("wen_ti5"));
				wj.setOid(rs.getInt("oid"));
				list.add(wj);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps,rs);
		}
		return null;
	}

}
