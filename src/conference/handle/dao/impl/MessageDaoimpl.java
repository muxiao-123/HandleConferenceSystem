package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.Message;
import conference.handle.dao.MessageDao;
import conference.handle.util.DButil;

public class MessageDaoimpl implements MessageDao {

	@Override
	public boolean insert(Message m) {
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
			
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into message values(null,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m.getMeetTitle());
			ps.setString(2, m.getMessageContent());
			ps.setTimestamp(3, m.getSendTime());
			ps.setString(4, m.getSender());
			ps.setInt(5, m.getOid());
			ps.setInt(6, m.getMeet_id());
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
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findAll(String sql,int n) {
		
		//n为oid输出多，mid 单个
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		
		 try {
			
			
			 conn = DButil.getConnection();
//			 String sql="select from message where oid=?";
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, n);
			 rs = ps.executeQuery();
			 List<Message> list=new ArrayList<>();
			 while(rs.next()) {
				 Message m=new Message();
				 m.setMessage_id(rs.getInt("message_id"));
				 m.setMeetTitle(rs.getString("meetTitle"));
				 m.setMessageContent(rs.getString("messageContent"));
				 m.setSendTime(rs.getTimestamp("sendTime"));
				 m.setSender(rs.getString("sender"));
				 m.setOid(rs.getInt("oid"));
				 list.add(m);
			 }
			return list;
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return null;
	}

	@Override
	public boolean delete(String sql, int message_id) {
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, message_id);
			int result = ps.executeUpdate();
			if(result>0) {
				conn.commit();
				return true;
			}else {
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
	public int find(int oid, int meet_id) {
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			
			conn = DButil.getConnection();
			//conn.setAutoCommit(false);
			String sql="select * from message where oid=? and meet_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ps.setInt(2, meet_id);
			rs = ps.executeQuery();
			int message_id=0;
			while(rs.next()) {
				message_id=rs.getInt("message_id");
			}
			return message_id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps,rs);
		}
		
		return 0;
	}

}
