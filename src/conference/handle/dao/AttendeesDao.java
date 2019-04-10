package conference.handle.dao;


import java.util.List;

import conference.handle.bean.Attendees;

public interface AttendeesDao {

	/*
	 * @return 登陆成功false,失败true;
	*/
	boolean login(String userName,String password);
	
	Attendees findInfo(String userName,String password); 
	
	int find(String a_userName);
	
	boolean register(String userName,String password,String email,String mobilePhone );
	
	boolean update(String userName,String password,String email,String mobilePhone,int aid);
	
	List<Attendees> findAll();
	
	boolean delete(int aid);
	
}
