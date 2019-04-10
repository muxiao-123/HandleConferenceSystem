package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.Vote;
import conference.handle.dao.VoteDao;
import conference.handle.util.DButil;

public class VoteDaoimpl implements VoteDao {

	@Override
	public boolean insert(String sql, Vote vote) {
		// TODO Auto-generated method stub
		//v_id为空
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, vote.getMeet_title());
			ps.setString(2, vote.getVote_content());
			ps.setString(3, vote.getSelect1());
			ps.setString(4, vote.getSelect2());
			ps.setString(5, vote.getSelect3());
			ps.setString(6, vote.getSelect4());
			ps.setInt(7, vote.getOid());
			int result = ps.executeUpdate();
			conn.commit();
			return result>0;
			
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
	public boolean delete(String sql,int vid) {
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vid);
			int result = ps.executeUpdate();
			conn.commit();
			return result>0;
			
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
	public List<Vote> find(String sql, int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			List<Vote> list=new ArrayList<>();
			//conn = DButil.getConnection();
			//conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vote vote=new Vote();
				vote.setVid(rs.getInt("vid"));
				vote.setMeet_title(rs.getString("meet_title"));
				vote.setVote_content(rs.getString("vote_content"));
				vote.setSelect1(rs.getString("select1"));
				vote.setSelect2(rs.getString("select2"));
				vote.setSelect3(rs.getString("select3"));
				vote.setSelect4(rs.getString("select4"));
				vote.setOid(rs.getInt("oid"));
				list.add(vote);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		
		return null;
	}

	@Override
	public List<Vote> findAll() {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			List<Vote> list=new ArrayList<>();
			conn = DButil.getConnection();
			//conn.setAutoCommit(false);
			String sql="select * from vote ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vote vote=new Vote();
				vote.setVid(rs.getInt("vid"));
				vote.setMeet_title(rs.getString("meet_title"));
				vote.setVote_content(rs.getString("vote_content"));
				vote.setSelect1(rs.getString("select1"));
				vote.setSelect2(rs.getString("select2"));
				vote.setSelect3(rs.getString("select3"));
				vote.setSelect4(rs.getString("select4"));
				vote.setOid(rs.getInt("oid"));
				list.add(vote);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Vote> find(String sql, Vote vote) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			List<Vote> list=new ArrayList<>();
			//conn = DButil.getConnection();
			//conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, vote.getMeet_title());
			ps.setInt(2, vote.getOid());
			rs = ps.executeQuery();
			while(rs.next()) {
				Vote vote1=new Vote();
				vote1.setVid(rs.getInt("vid"));
				vote1.setMeet_title(rs.getString("meet_title"));
				vote1.setVote_content(rs.getString("vote_content"));
				vote1.setSelect1(rs.getString("select1"));
				vote1.setSelect2(rs.getString("select2"));
				vote1.setSelect3(rs.getString("select3"));
				vote1.setSelect4(rs.getString("select4"));
				vote1.setOid(rs.getInt("oid"));
				list.add(vote1);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		
		return null;
	}

	@Override
	public List<Vote> find(String sql, String meet_title) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButil.getConnection();
			List<Vote> list=new ArrayList<>();
			//conn = DButil.getConnection();
			//conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, meet_title);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vote vote=new Vote();
				vote.setVid(rs.getInt("vid"));
				vote.setMeet_title(rs.getString("meet_title"));
				vote.setVote_content(rs.getString("vote_content"));
				vote.setSelect1(rs.getString("select1"));
				vote.setSelect2(rs.getString("select2"));
				vote.setSelect3(rs.getString("select3"));
				vote.setSelect4(rs.getString("select4"));
				vote.setOid(rs.getInt("oid"));
				list.add(vote);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return null;
	}

}
