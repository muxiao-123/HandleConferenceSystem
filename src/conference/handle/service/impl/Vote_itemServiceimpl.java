package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.Vote_item;
import conference.handle.dao.Vote_itemDao;
import conference.handle.dao.impl.Vote_itemDaoimpl;
import conference.handle.service.Vote_itemService;

public class Vote_itemServiceimpl implements Vote_itemService {

	@Override
	public boolean insert(Vote_item v_item) {
		Vote_itemDao dao=new Vote_itemDaoimpl();
		return dao.insert(v_item);
	}

	@Override
	public boolean delete(int meet_id) {
		// TODO Auto-generated method stub
		Vote_itemDao dao=new Vote_itemDaoimpl();
		return dao.delete(meet_id);
	}

	@Override
	public List<Vote_item> find(String sql, int n) {
		// TODO Auto-generated method stub
		Vote_itemDao dao=new Vote_itemDaoimpl();
		return dao.find(sql, n);
	}

}
