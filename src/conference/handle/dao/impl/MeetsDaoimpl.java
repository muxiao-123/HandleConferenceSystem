package conference.handle.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.Meets;
import conference.handle.dao.MeetsDao;
import conference.handle.util.DButil;

public class MeetsDaoimpl implements MeetsDao {
	List<Meets> list = new ArrayList<Meets>();

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean insert(Meets meet) {
		// 新建会议
		// String meet_title, String meet_points,int number,
		// Date startDate,Date endDate,String toastMaster,String addresss,
		// Srting meetInfo, String sponsor, int oid
		try {
			conn = DButil.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into meets values(null,?,?,?,?,?,null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, meet.getMeet_title());
			ps.setString(2, meet.getMeet_points());
			ps.setInt(3, meet.getNumber());
			ps.setTimestamp(4, meet.getStartDate());
			ps.setTimestamp(5, meet.getEndDate());
			ps.setString(6, meet.getToastMaster());
			ps.setString(7, meet.getAddress());
			ps.setString(8, meet.getSponsor());
			ps.setString(9, meet.getMeetInfo());
			ps.setInt(10, meet.getOid());
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("ok");
				conn.commit();
				return true;
			} else {
				System.out.println("false");
				return false;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();// 事务回滚
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DButil.release(conn, ps);
		}
		return false;
	}

	@Override
	public List<Meets> findAll(int oid) {
		// 查询会议,返回会议对象的集合
		// 查询自己发布的会议
		try {
			// 传入发布者的id
			conn = DButil.getConnection();
			String sql = "select * from meets where oid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Meets meet = new Meets();
				meet.setMeet_id(rs.getInt("meet_id"));
				meet.setMeet_title(rs.getString("meet_title"));
				meet.setMeet_points(rs.getString("meet_points"));
				meet.setNumber(rs.getInt("number"));
				meet.setStartDate(rs.getTimestamp("startDate"));
				meet.setEndDate(rs.getTimestamp("endDate"));
				meet.setToastMaster(rs.getString("toastMaster"));
				meet.setAddress(rs.getString("address"));
				meet.setMeetInfo(rs.getString("meetInfo"));
				meet.setSponsor(rs.getString("sponsor"));

				// 去不去发布者id？
				list.add(meet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.release(conn, ps, rs);
		}

		return list;
	}

	@Override
	public void modify() {
		// 修改会议
		// 功能待定

	}

	@Override
	public void delete(String meet_title, int oid) {
		// 删除会议
		conn = DButil.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "delete from meets where meet_title=?and oid=?";
			ps = conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("删除ok");
				conn.commit();
			} else {
				System.out.println("失败fail");
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DButil.release(conn, ps, rs);
		}
	}

	@Override
	public List<Meets> findAll() {
		// 查询所有会议

		try {
			conn = DButil.getConnection();
			String sql = "select * from meets order by meet_id asc ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Meets> list1 = new ArrayList<Meets>();
			while (rs.next()) {
				Meets meet1 = new Meets();
				meet1.setMeet_id(rs.getInt("meet_id"));
				meet1.setMeet_title(rs.getString("meet_title"));
				meet1.setNumber(rs.getInt("number"));
				meet1.setMeet_points(rs.getString("meet_points"));
				// Timestamp bb =rs.getTimestamp("startDate");
				meet1.setStartDate(rs.getTimestamp("startDate"));
				meet1.setAddress(rs.getString("address"));
				// Timestamp cc =rs.getTimestamp("startendDate");
				meet1.setEndDate(rs.getTimestamp("endDate"));
				meet1.setSponsor(rs.getString("sponsor"));
				meet1.setToastMaster(rs.getString("toastMaster"));
				meet1.setMeetInfo(rs.getString("meetInfo"));
				meet1.setOid(rs.getInt("oid"));
				meet1.setUrl_img(rs.getString("url_img"));
				System.out.println(meet1.getUrl_img());
				list1.add(meet1);

			}
			return list1;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DButil.release(conn, ps, rs);
		}
		return null;
	}

	@Override
	public Meets find(int meet_id) {
		try {
			conn = DButil.getConnection();
			String sql = "select * from meets where meet_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, meet_id);
			rs = ps.executeQuery();
			Meets meet1 = new Meets();
			while (rs.next()) {
				meet1.setMeet_id(rs.getInt("meet_id"));
				meet1.setMeet_title(rs.getString("meet_title"));
				meet1.setNumber(rs.getInt("number"));
				meet1.setMeet_points(rs.getString("meet_points"));
				// Timestamp bb =rs.getTimestamp("startDate");
				meet1.setStartDate(rs.getTimestamp("startDate"));
				// meet1.setStartDate(rs.getTimestamp("startDate"));
				meet1.setAddress(rs.getString("address"));
				// Timestamp cc =rs.getTimestamp("startendDate");
				meet1.setEndDate(rs.getTimestamp("endDate"));
				// meet1.setEndDate(rs.getTimestamp("endDate"));
				meet1.setSponsor(rs.getString("sponsor"));
				meet1.setToastMaster(rs.getString("toastMaster"));
				meet1.setMeetInfo(rs.getString("meetInfo"));
				meet1.setOid(rs.getInt("oid"));
			}
			return meet1;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DButil.release(conn, ps, rs);
		}
		return null;
	}

	@Override
	public int findCount() {
		try {
			conn = DButil.getConnection();
			String sql = "select * from meets";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Meets> list1 = new ArrayList<Meets>();
			while (rs.next()) {
				Meets meet1 = new Meets();
				meet1.setMeet_id(rs.getInt("meet_id"));
				meet1.setMeet_title(rs.getString("meet_title"));
				meet1.setNumber(rs.getInt("number"));
				meet1.setMeet_points(rs.getString("meet_points"));
				// Timestamp bb =rs.getTimestamp("startDate");
				meet1.setStartDate(rs.getTimestamp("startDate"));
				meet1.setAddress(rs.getString("address"));
				// Timestamp cc =rs.getTimestamp("startendDate");
				meet1.setEndDate(rs.getTimestamp("endDate"));
				meet1.setSponsor(rs.getString("sponsor"));
				meet1.setToastMaster(rs.getString("toastMaster"));
				meet1.setMeetInfo(rs.getString("meetInfo"));
				meet1.setOid(rs.getInt("oid"));
				list1.add(meet1);

			}
			return list1.size();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DButil.release(conn, ps, rs);
		}
		return 0;
	}

	@Override
	public List<Meets> findMeetsByPage(int currentPage) {
		// 查询当前页会议集合
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DButil.getConnection();
			String sql = "select * from meets limit ? offset ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, PAGE_SIZE);
			ps.setInt(2, (currentPage - 1) * PAGE_SIZE);
			ResultSet rs = ps.executeQuery();
			List<Meets> list = new ArrayList<>();
			while (rs.next()) {
				Meets meets = new Meets();
				meets.setMeet_id(rs.getInt("meet_id"));
				meets.setMeet_title(rs.getString("meet_title"));
				meets.setNumber(rs.getInt("number"));
				meets.setMeet_points(rs.getString("meet_points"));
				meets.setStartDate(rs.getTimestamp("startDate"));
				meets.setEndDate(rs.getTimestamp("endDate"));
				meets.setToastMaster(rs.getString("toastMaster"));
				meets.setAddress(rs.getString("address"));
				meets.setSponsor(rs.getString("sponsor"));
				meets.setMeetInfo(rs.getString("meetInfo"));
				meets.setOid(rs.getInt("oid"));
				meets.setUrl_img(rs.getString("url_img"));
				list.add(meets);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.release(conn, ps, rs);
		}
		return null;
	}

	@Override
	public int find(String meet_title, int oid) {
		try {
			conn = DButil.getConnection();
			String sql = "select * from meets where meet_title=?and oid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, meet_title);
			ps.setInt(2, oid);
			rs = ps.executeQuery();
			// List<Meets> list1=new ArrayList<Meets>();
			int meet_id = 0;
			while (rs.next()) {
				meet_id = rs.getInt("meet_id");
			}
			return meet_id;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DButil.release(conn, ps, rs);
		}
		return 0;
	}

	@Override
	public Meets find(String meet_title) {
		try {
			// 传入发布者的id
			conn = DButil.getConnection();
			String sql = "select * from meets where meet_title=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, meet_title);
			ResultSet rs = ps.executeQuery();
			Meets meet = new Meets();
			while (rs.next()) {
				meet.setMeet_id(rs.getInt("meet_id"));
				meet.setStartDate(rs.getTimestamp("startDate"));
				meet.setEndDate(rs.getTimestamp("endDate"));
				// 去不去发布者id？
			}
			return meet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.release(conn, ps, rs);
		}

		return null;
	}

}
