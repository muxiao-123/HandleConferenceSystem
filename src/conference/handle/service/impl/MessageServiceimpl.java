package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.Message;
import conference.handle.dao.MessageDao;
import conference.handle.dao.impl.MessageDaoimpl;
import conference.handle.service.MessageService;

public class MessageServiceimpl implements MessageService {

	@Override
	public boolean insert(Message m) {
		MessageDao dao=new MessageDaoimpl();
		return dao.insert(m);
	}

	@Override
	public List<Message> findAll() {
		MessageDao dao=new MessageDaoimpl();
		return dao.findAll();
	}

	@Override
	public List<Message> findAll(String sql,int n) {
		MessageDao dao=new MessageDaoimpl();
		return dao.findAll(sql,n);
	}

	@Override
	public boolean delete(String sql, int message_id) {
		MessageDao dao=new MessageDaoimpl();
		return dao.delete(sql, message_id);
	}

	@Override
	public int find(int oid, int meet_id) {
		MessageDao dao=new MessageDaoimpl();
		return dao.find(oid, meet_id);
	}

}
