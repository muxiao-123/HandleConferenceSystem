package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.Qd_item;
import conference.handle.dao.Qd_itemDao;
import conference.handle.util.DButil;

public class Qd_itemDaoimpl implements Qd_itemDao {

	@Override
	public boolean insert(Qd_item qd_item) {
		//签到信息插入
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into qd_item values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, qd_item.getMeet_title());
			ps.setString(2, qd_item.getA_userName());
			ps.setTimestamp(3,qd_item.getQd_time());
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println("签到成功");
				conn.commit();
				return true;
			}else {
				System.out.println("签到失败");
			}return false;
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
	public List<Qd_item> findAll(String meet_title) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		 try {
			 conn = DButil.getConnection();
			 String sql="select * from qd_item where meet_title = ?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, meet_title);
			 rs = ps.executeQuery();
			 List<Qd_item> list_q=new ArrayList<>();
			 while(rs.next()) {
				 Qd_item qd=new Qd_item();
				 qd.setMeet_title(rs.getString("meet_title"));
				 qd.setA_userName(rs.getString("a_userName"));
				 qd.setQd_time(rs.getTimestamp("qd_time"));
				 list_q.add(qd);
			 }
			 return list_q;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return null;
	}

	@Override
	public boolean find(String meet_title, String a_userName) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		 try {
			 conn = DButil.getConnection();
			 String sql="select * from qd_item where  meet_title= ? and a_userName=?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, meet_title);
			 ps.setString(2, a_userName);
			 rs = ps.executeQuery();
			 
			 if(rs.next()) {
				 return true;
			 }else {
				 return false;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return false;
	}
}
