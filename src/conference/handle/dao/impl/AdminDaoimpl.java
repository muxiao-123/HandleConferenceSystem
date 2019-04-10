package conference.handle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conference.handle.bean.Admin;
import conference.handle.dao.AdminDao;
import conference.handle.util.DButil;

public class AdminDaoimpl implements AdminDao {

	@Override
	public boolean find(String name, String password) {
		//判断admin的值是否为空，返回数据
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = DButil.getConnection();
			String sql="select * from admin where name=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
//			Admin admin=new Admin();
			System.out.println("来到找出这一步了");
//			while(rs.next()) {
//				System.out.println("优质被添加了");
//				admin.setId(rs.getInt("id"));
//				admin.setName(rs.getString("name"));
//				admin.setPassword(rs.getString("password"));
//				
//			}
//			System.out.println("admin"+admin.getId());
			return rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.release(conn, ps, rs);
		}
		return false;
	}

}
