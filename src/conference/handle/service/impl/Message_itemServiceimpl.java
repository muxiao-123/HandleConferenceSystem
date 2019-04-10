package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.Message_item;
import conference.handle.dao.Message_itemDao;
import conference.handle.dao.impl.Message_itemDaoimpl;
import conference.handle.service.Message_itemService;

public class Message_itemServiceimpl implements Message_itemService {

	@Override
	public boolean insert(int message_id, int aid) {
		Message_itemDao dao=new Message_itemDaoimpl();
		return dao.insert(message_id, aid);
	}

	@Override
	public boolean delete(String sql,int aid) {
		//传进参数删除
		Message_itemDao dao=new Message_itemDaoimpl();
		return dao.delete(sql, aid);
	}

	@Override
	public List<Message_item> findAll(String sql, int aid) {
		Message_itemDao dao=new Message_itemDaoimpl();
		return dao.findAll(sql, aid);
	}

	

}
