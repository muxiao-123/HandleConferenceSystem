package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.Message_item;
import conference.handle.dao.Message_itemDao;
import conference.handle.util.DButil;

public class Message_itemDaoimpl implements Message_itemDao {

	@Override
	public boolean insert(int message_id,int aid) {
		
		
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into message_item values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, message_id);
			ps.setInt(2, aid);
			int result = ps.executeUpdate();
			
			conn.commit();
			return result>0;
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps);
		}
		return false;

	}

	@Override
	public boolean delete(String sql,int aid) {
		// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement ps=null;
		 try {
			 
			 conn = DButil.getConnection();
			 conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println("消息删除成功");
				conn.commit();
				return true;
			}else {
				System.out.println("消息删除失败");
				return false;
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps);
		}
		return false;
	}

	@Override
	public List<Message_item> findAll(String sql, int aid) {
		
      	Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		 try {
			 
			 List<Message_item> list=new ArrayList<>();
			 conn = DButil.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, aid);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 Message_item mess_it=new Message_item();
				 mess_it.setMessage_id(rs.getInt("message_id"));
				 mess_it.setAid(rs.getInt("aid"));
				 list.add(mess_it);
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
