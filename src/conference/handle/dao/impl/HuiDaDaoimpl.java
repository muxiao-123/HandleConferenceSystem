package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.HuiDa;
import conference.handle.dao.HuiDaDao;
import conference.handle.util.DButil;

public class HuiDaDaoimpl implements HuiDaDao {

	@Override
	public boolean insert(String sql, HuiDa hd) {
		
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			//String sql="insert into from wenjuan values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hd.getQid());
			ps.setString(2, hd.getMeet_title());
			ps.setString(3, hd.getHui_da1());
			ps.setString(4, hd.getHui_da2());
			ps.setString(5, hd.getHui_da3());
			ps.setString(6, hd.getHui_da4());
			ps.setString(7, hd.getHui_da5());
			ps.setInt(8, hd.getAid());
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
	public boolean delete(String sql, int aid,String meet_title) {
		
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
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
	public List<HuiDa> find(String sql, int aid,String meet_title) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			//String sql="insert into from huida values(null,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			ps.setString(2, meet_title);
			rs = ps.executeQuery();
			List<HuiDa> list = new ArrayList<>(); 
			
			while(rs.next()) {
				HuiDa hd= new HuiDa();
				hd.setQid(rs.getInt("qid"));
				hd.setMeet_title(rs.getString("meet_title"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setAid(rs.getInt("aid"));
				list.add(hd);
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
	public List<HuiDa> findAll() {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			String sql="select * from huida";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<HuiDa> list = new ArrayList<>(); 
			while(rs.next()) {
				HuiDa hd= new HuiDa();
				hd.setQid(rs.getInt("qid"));
				hd.setMeet_title(rs.getString("meet_title"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setHui_da1(rs.getString("hui_da1"));
				hd.setAid(rs.getInt("aid"));
				list.add(hd);
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
	public List<HuiDa> find(String sql, HuiDa hd) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			//String sql="select * from wenjuan";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hd.getQid());
			rs = ps.executeQuery();
			List<HuiDa> list = new ArrayList<>(); 
			while(rs.next()) {
				HuiDa hd1= new HuiDa();
				hd1.setQid(rs.getInt("qid"));
				hd1.setMeet_title(rs.getString("meet_title"));
				hd1.setHui_da1(rs.getString("hui_da1"));
				hd1.setHui_da2(rs.getString("hui_da2"));
				hd1.setHui_da3(rs.getString("hui_da3"));
				hd1.setHui_da4(rs.getString("hui_da4"));
				hd1.setHui_da5(rs.getString("hui_da5"));
				hd1.setAid(rs.getInt("aid"));
				list.add(hd1);
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
