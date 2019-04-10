package conference.handle.dao;

import java.util.List;

import conference.handle.bean.Organizer;

public interface OrganizerDao {

	/*
	 * @return 登陆成功false,失败true;
	*/
	boolean login(String userName,String password);
	
	Organizer findInfo(String userName,String password); 
	
	Organizer find(int oid);
	
	boolean register(String userName,String password,String email,String mobilePhone );
	
	boolean update(String userName,String password,String email,String mobilePhone,int aid);
	List<Organizer> findAll();
	
	boolean delete(int oid);
}
