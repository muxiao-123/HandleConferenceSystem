package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.Vote_item;
import conference.handle.dao.Vote_itemDao;
import conference.handle.util.DButil;

public class Vote_itemDaoimpl implements Vote_itemDao {

	@Override
	public boolean insert(Vote_item v_item) {
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into vote_item values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,v_item.getMeet_id() );
			ps.setInt(2, v_item.getVid());
			ps.setInt(3, v_item.getAid());
			ps.setInt(4, v_item.getSelectStatus());
			int bb = ps.executeUpdate();
			conn.commit();
			return bb>0;
			
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
	public boolean delete(int meet_id) {
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			String sql="delete from vote_item where meet_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,meet_id);
			int bb = ps.executeUpdate();
			conn.commit();
			return bb>0;
			
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
	public List<Vote_item> find(String sql, int n) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			List<Vote_item> list=new ArrayList<>();
			conn = DButil.getConnection();
			//conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1,n);
			rs = ps.executeQuery();
			//conn.commit();
			while(rs.next()) {
				Vote_item v_item=new Vote_item();
				v_item.setMeet_id(rs.getInt("meet_id"));
				v_item.setV_id(rs.getInt("vid"));
				v_item.setAid(rs.getInt("aid"));
				v_item.setSelectStatus(rs.getInt("selectStatus"));
				list.add(v_item);
			}
			System.out.println("此时的大小为"+list.size());
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
