package conference.handle.dao;

import java.util.List;

import conference.handle.bean.Message;

public interface MessageDao {
   //插入消息返回消息对象，方便发送给用户
	boolean insert(Message m);
	//查询所有
	List<Message> findAll();
	//查询发布消息和接受消息
	List<Message> findAll(String sql,int n);
	
	boolean delete(String sql,int message_id);
	
	int find(int oid,int meet_id);
	
}
