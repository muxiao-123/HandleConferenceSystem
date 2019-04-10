package conference.handle.dao;

import java.util.List;

import conference.handle.bean.Message_item;

public interface Message_itemDao {
      boolean insert(int message_id,int aid);
      boolean delete(String sql,int aid);
      List<Message_item> findAll(String sql,int aid);
}
