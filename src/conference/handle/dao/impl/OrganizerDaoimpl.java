package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.Organizer;
import conference.handle.dao.OrganizerDao;
import conference.handle.util.DButil;

public class OrganizerDaoimpl implements OrganizerDao {
      Connection conn=null;
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	 
	@Override
	public boolean login(String userName, String password) {
		// 登陆
		try {
			//1. 得到连接对象
			conn = DButil.getConnection();
			
			String sql = "select * from organizer where o_userName=? and o_password=?";
			
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
	public Organizer findInfo(String userName, String password) {
		// 查找信息
		Organizer org=new Organizer();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		//List<Attending> list = new ArrayList<Attending>();
		  
		  try {
			   conn = DButil.getConnection();
			   String sql="select *from organizer where o_userName=? and o_password=?";
			   ps = conn.prepareStatement(sql);
			   ps.setString(1, userName);
			   ps.setString(2, password);
			   rs = ps.executeQuery();
			   while(rs.next()) {
				   
				   org.setOid(rs.getInt("oid"));
				   org.setO_userName(rs.getString("o_userName"));
				   org.setO_password(rs.getString("o_password"));
				   org.setO_email(rs.getString("o_email"));
				   org.setO_mobilePhone(rs.getString("o_mobilePhone"));
				 //System.out.println("aid="+att.getAid());
			   }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return org;
	}

	@Override
	public boolean register(String userName, String password, String email, String mobilePhone) {
		// 注册
		try {
			conn = DButil.getConnection();
			String sql="insert into organizer values(null,?,?,?,?)";
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
	public boolean update(String userName, String password, String email, String mobilePhone, int oid) {
		// 修改
		 try {
			 
				conn = DButil.getConnection();
				//开启事务，默认关闭，默认可重复读
				conn.setAutoCommit(false);
				//System.out.println("此时的aid为："+atta.getAid());
				String sql="update organizer set o_userName=?,o_password=?,o_email=?,o_mobilePhone=? where oid=?";
				ps  =  conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.setString(4, mobilePhone);
				ps.setInt(5, oid);
				
				System.out.println("mobilePhone"+mobilePhone+"password="+password);
				
				int result=ps.executeUpdate();
				if(result>0) {
					conn.commit();
					System.out.println("修改成功:mobile="+mobilePhone+"username="+userName);
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
	public Organizer find(int oid) {
		Organizer org=new Organizer();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		//List<Attending> list = new ArrayList<Attending>();
		  
		  try {
			   conn = DButil.getConnection();
			   String sql="select from organizer where oid=? ";
			   ps = conn.prepareStatement(sql);
			   ps.setInt(1, oid);
			   rs = ps.executeQuery();
			   while(rs.next()) {
				   org.setOid(rs.getInt("oid"));
				   org.setO_userName(rs.getString("o_userName"));
				   org.setO_password(rs.getString("o_password"));
				   org.setO_email(rs.getString("o_email"));
				   org.setO_mobilePhone(rs.getString("o_mobilePhone"));
				 //System.out.println("aid="+att.getAid());
			   }
			   return org;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Organizer> findAll() {
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		  
		  try {
			   conn = DButil.getConnection();
			   String sql="select * from organizer";
			   ps = conn.prepareStatement(sql);
			   rs = ps.executeQuery();
			   List<Organizer> list = new ArrayList<Organizer>();
			  
			   while(rs.next()) {
				   Organizer org=new Organizer();
				   org.setOid(rs.getInt("oid"));
				   org.setO_userName(rs.getString("o_userName"));
				   org.setO_password(rs.getString("o_password"));
				   org.setO_email(rs.getString("o_email"));
				   org.setO_mobilePhone(rs.getString("o_mobilePhone"));
				   list.add(org);
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
	public boolean delete(int oid) {
		Connection conn=null;
		PreparedStatement ps=null;
		  try {
			   conn = DButil.getConnection();
			   conn.setAutoCommit(false);
			   String sql="delete  from organizer where oid=?";
			   ps = conn.prepareStatement(sql);
			   ps.setInt(1, oid);
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

}
