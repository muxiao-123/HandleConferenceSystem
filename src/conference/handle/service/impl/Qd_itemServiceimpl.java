package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.Qd_item;
import conference.handle.dao.Qd_itemDao;
import conference.handle.dao.impl.Qd_itemDaoimpl;
import conference.handle.service.Qd_itemService;

public class Qd_itemServiceimpl implements Qd_itemService {

	@Override
	public boolean insert(Qd_item qd) {
		Qd_itemDao dao=new Qd_itemDaoimpl();
		return dao.insert(qd);
	}

	@Override
	public List<Qd_item> findAll(String meet_title) {
		Qd_itemDao dao=new Qd_itemDaoimpl();
		return dao.findAll(meet_title);
	}

	@Override
	public boolean find(String meet_title, String a_userName) {
		Qd_itemDao dao=new Qd_itemDaoimpl();
		return dao.find(meet_title, a_userName);
	}

}
