package conference.handle.service;

import java.util.List;

import conference.handle.bean.Vote_item;

public interface Vote_itemService {
	boolean insert(Vote_item v_item);
	boolean delete(int meet_id);
	//三个id都可以查查询,并且返回集合对象
	List<Vote_item> find(String sql,int n);
}
