package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.BaoMing;
import conference.handle.dao.BaoMingDao;
import conference.handle.util.DButil;

public class BaoMingDaoimpl implements BaoMingDao {

	
	Connection conn = null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	
	@Override
	public boolean insert(BaoMing bm) {
		// 以对象值传进来，对象从servlet中创建添加
		
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into baoming values(null,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bm.getMeet_id());
			ps.setInt(2, bm.getAid());
			ps.setString(3,bm.getA_userName());
			ps.setString(4, bm.getA_email());
			
			int result = ps.executeUpdate();
			 if(result>0) {
				 System.out.println("ok");
			     conn.commit();
			     return true;
			 }else {
				 System.out.println("false");
				return false;
			 }
		} catch (SQLException e) {
			try {
				
				conn.rollback();//事务回滚
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
	public boolean delete(int meet_id,int aid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			String sql="delete from baoming where meet_id=? and aid=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, meet_id);
			ps.setInt(2, aid);
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println("删除成功");
				conn.commit();
				return true;
			}else {
				System.out.println("删除失败");
				return false;
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<BaoMing> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaoMing> findAll(String sql, int aid) {
		// 通过本身id查找会议id返回会议id结果list集
		try {
			//1. 得到连接对象
			List<BaoMing> list= new ArrayList<BaoMing>();
			conn = DButil.getConnection();
			//System.out.println(sql);
			//String sql = "selete * from baoming where aid=?";
			//2. 创建ps对象
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
		    rs=ps.executeQuery();
		    while(rs.next()) {
		    	//会议id对象只存数字
		    	BaoMing meets_ids=new BaoMing();
		    	meets_ids.setMeet_id(rs.getInt("meet_id"));
		    	list.add(meets_ids);
		    }
		    return list;
		     
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.release(conn,ps,rs);
			
		}
		return null;
		
	}
	
	

	@Override
	public boolean update(String a_userName, String a_email, int aid) {
		// 修改报名信息
		 try {
			 
				conn = DButil.getConnection();
				//开启事务，默认关闭，默认可重复读
				conn.setAutoCommit(false);
				//System.out.println("此时的aid为："+atta.getAid());
				String sql="update baoming set a_userName=?,a_email=? where aid=?";
				ps  =  conn.prepareStatement(sql);
				ps.setString(1, a_userName);
				ps.setString(2, a_email);
				ps.setInt(3, aid);
				
				
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
	public List<BaoMing> findAll(String sql, int aid, int meet_id) {
		try {
			//1. 得到连接对象
			List<BaoMing> list= new ArrayList<BaoMing>();
			conn = DButil.getConnection();
			//System.out.println(sql);
			//String sql = "selete * from baoming where meet_id? and aid=?";
			//2. 创建ps对象
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			ps.setInt(2, meet_id);
		    rs=ps.executeQuery();
		    while(rs.next()) {
		    	
		    	BaoMing bm=new BaoMing();
		    	bm.setBaoMing_id(rs.getInt("baoMing_id"));
		    	bm.setMeet_id(rs.getInt("meet_id"));
		    	bm.setAid(rs.getInt("aid"));
		    	bm.setA_userName(rs.getString("a_userName"));
		    	bm.setA_email(rs.getString("a_email"));
		    	list.add(bm);
		    }
		    return list;
		     
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.release(conn,ps,rs);
			
		}
		return null;
	}

	@Override
	public List<BaoMing> findAll(int meet_id) {
		try {
			//1. 得到连接对象
			List<BaoMing> list= new ArrayList<BaoMing>();
			conn = DButil.getConnection();
			//System.out.println(sql);
			String sql = "select * from baoming where meet_id=?";
			//2. 创建ps对象
			ps = conn.prepareStatement(sql);
			ps.setInt(1, meet_id);
		    rs=ps.executeQuery();
		    while(rs.next()) {
		    	//会议id对象只存数字
		    	BaoMing meets_ids=new BaoMing();
		    	meets_ids.setMeet_id(rs.getInt("meet_id"));
		    	meets_ids.setA_userName(rs.getString("a_userName"));
		    	meets_ids.setAid(rs.getInt("aid"));
		    	list.add(meets_ids);
		    }
		    return list;
		     
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.release(conn,ps,rs);
			
		}
		return null;
		
	}

}
