package conference.handle.dao;

import java.util.List;

import conference.handle.bean.Qd_item;

public interface Qd_itemDao {
	//返回真假判断签到成功与否
     boolean insert(Qd_item qd_item);
     List<Qd_item> findAll(String meet_title);
     boolean  find(String meet_title,String a_userName);
     
}
