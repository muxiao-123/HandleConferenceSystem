package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.Attendees;
import conference.handle.dao.AttendeesDao;
import conference.handle.util.DButil;

public class AttendeesDaoimpl implements AttendeesDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs   = null; 
	
	
	
	@Override
	public boolean login(String userName,String password) {
		
		try {
			//1. 得到连接对象
			conn = DButil.getConnection();
			
			String sql = "select * from attendees where userName=? and password=?";
			
			//System.out.println(sql);
			//2. 创建ps对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
		    rs=ps.executeQuery();
			 
		     return rs.next();
		     
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.release(conn,ps,rs);
			
		}
		return false;
	}

	@Override
	public Attendees findInfo(String userName, String password) {
		// 查找信息
		Attendees att=new Attendees();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		//List<Attending> list = new ArrayList<Attending>();
		  
		  try {
			   conn = DButil.getConnection();
			   String sql="select *from attendees where userName=? and password=?";
			   ps = conn.prepareStatement(sql);
			   ps.setString(1, userName);
			   ps.setString(2, password);
			   rs = ps.executeQuery();
			   while(rs.next()) {
				   
				   att.setAid(rs.getInt("aid"));
				   att.setUserName(rs.getString("userName"));
				   att.setPassword(rs.getString("password"));
				   att.setEmail(rs.getString("email"));
				   att.setMobilePhone(rs.getString("mobilePhone"));
				 //System.out.println("aid="+att.getAid());
			   }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return att;
	}

	@Override
	public boolean register(String userName,String password,String email,String mobilePhone) {
		//注册
		try {
			conn = DButil.getConnection();
			String sql="insert into attendees values(null,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, mobilePhone);
			int rs = ps.executeUpdate();
			if(rs>0) {
				return true;
				
			}else {
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		  return false;
	}

	@Override
	public boolean update(String userName, String password, String email, String mobilePhone, int aid) {
		//修改信息
		 
		 try {
			 
			conn = DButil.getConnection();
			//开启事务，默认关闭，默认可重复读
			conn.setAutoCommit(false);
			//System.out.println("此时的aid为："+atta.getAid());
			String sql="update Attendees set userName=?,password=?,email=?,mobilePhone=? where aid=?";
			ps  =  conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, mobilePhone);
			ps.setInt(5, aid);
			
			//System.out.println("mobilePhone"+mobilePhone+"password="+password);
			int result=ps.executeUpdate();
			if(result>0) {
				System.out.println("修改成功");
				conn.commit();
				return true;
			}else {
				System.out.println("修改失败");
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
			DButil.release(conn, ps, rs);
		}
		return false;
	}

	@Override
	public int find(String a_userName) {
		Attendees att=new Attendees();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		int aid=0;
		//List<Attending> list = new ArrayList<Attending>();
		  try {
			   conn = DButil.getConnection();
			   String sql="select *from attendees where userName=?";
			   ps = conn.prepareStatement(sql);
			   ps.setString(1, a_userName);
			   rs = ps.executeQuery();
			   while(rs.next()) {
				   att.setAid(rs.getInt("aid"));
				 //System.out.println("aid="+att.getAid());
			   }
			   return aid=att.getAid();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return 0;
	}

	@Override
	public List<Attendees> findAll() {
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		  try {
			   conn = DButil.getConnection();
			   String sql="select * from attendees";
			   ps = conn.prepareStatement(sql);
			   rs = ps.executeQuery();
			   List<Attendees> list = new ArrayList<Attendees>();
			   
			   while(rs.next()) {
				   Attendees att=new Attendees();
				   att.setAid(rs.getInt("aid"));
				   att.setUserName(rs.getString("userName"));
				   att.setPassword(rs.getString("password"));
				   att.setEmail(rs.getString("email"));
				   att.setMobilePhone(rs.getString("mobilePhone"));
				   list.add(att);
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
	public boolean delete(int aid) {
		Connection conn=null;
		PreparedStatement ps=null;
		  try {
			   conn = DButil.getConnection();
			   conn.setAutoCommit(false);
			   String sql="delete from attendees where aid=?";
			   ps = conn.prepareStatement(sql);
			   ps.setInt(1, aid);
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps);
		}
		return false;
	}
	
	
	
//	@Override
//	public boolean login(String userName, String password) {
//		return false;
//	}

	

}
