package conference.handle.service;

import java.util.List;

import conference.handle.bean.BaoMing;

public interface BaoMingService {

	//报名操作，返回报名信息，发送关键是获得meet_id已添加会议
	  boolean insert(BaoMing bm);
	//删除报名操作
	  boolean  delete(int meet_id,int aid);
	 //查询所有报名操作，返回list集合 无参
	  List<BaoMing>  findAll();
	 //查询某个会议，所报名的人数，以集合形式返回，参数为meet_id
	  List<BaoMing> findAll(String sql,int aid);
	 //修改报名信息操作。返回Boolean，参数为oid确定身份唯一确定
	  boolean update(String a_userName,String a_email, int oid);
	  List<BaoMing> findAll(String sql,int aid,int meet_id);
	  List<BaoMing> findAll(int meet_id);
	
}
