package conference.handle.dao;

import java.util.List;

import conference.handle.bean.Vote;

public interface VoteDao {
   //插入的同时返回投票信息
   boolean insert(String sql,Vote vote);
   //返回状态
   boolean delete(String sql,int vid);
   //id查询，返回集合，可多，可少
   List<Vote> find(String sql,int id);
   //查询所有投票
   List<Vote> findAll();
   List<Vote> find(String sql,Vote vote);
   List<Vote> find(String sql,String meet_title); 
}
