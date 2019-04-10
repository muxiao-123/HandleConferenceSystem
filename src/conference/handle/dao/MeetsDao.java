package conference.handle.dao;

import java.util.List;

import conference.handle.bean.Meets;
import conference.handle.bean.QDTongJi;


public interface MeetsDao {
	 int PAGE_SIZE=3;
	
	boolean insert(Meets meet);//添加会议 并返回会议信息
	//String meet_title, String meet_points,int number,Date startDate,Date endDate,String toastMaster,String addresss, String meetInfo,  String sponsor, int oid
	List<Meets> findAll(int oid);//查找会议 并返回会议信息集合
	List<Meets> findMeetsByPage(int currentPage);//通过当前页查询该页的学生数据
	//void update();
	void modify();//修改会议信息
	void delete(String meet_title,int oid);//删除会议信息
	
	List<Meets> findAll();
	Meets find(int meet_id);
	Meets find(String meet_title);
	//找到会议数
	int findCount();
	//
	int find(String meet_title,int oid);
}
