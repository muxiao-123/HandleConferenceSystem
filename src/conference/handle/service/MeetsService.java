package conference.handle.service;

import java.util.List;

import conference.handle.bean.Meets;
import conference.handle.bean.Page;

public interface MeetsService {

	boolean insert(Meets meet);//添加会议 并返回会议信息
	//String meet_title, String meet_points,int number,Date startDate,Date endDate,String toastMaster,String addresss, String meetInfo,  String sponsor, int oid
	List<Meets> findAll(int oid);//查找会议 并返回会议信息集合
	
	//void update();
	void modify();//修改会议信息
	void delete(String meet_title,int oid);//删除会议信息
	
	List<Meets> findAll();
	
	Meets find(int meet_id);
	Page<Meets> findMeetsByPage(int currentPage);
	int find(String meet_title,int oid);
	Meets find(String meet_title);
	
}
