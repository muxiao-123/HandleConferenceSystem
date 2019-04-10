package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.Meets;
import conference.handle.bean.Page;
import conference.handle.dao.MeetsDao;
import conference.handle.dao.impl.MeetsDaoimpl;
import conference.handle.service.MeetsService;

public class MeetsServiceimpl implements MeetsService {

	public boolean insert(Meets meet) {
		// 
		MeetsDao dao=new MeetsDaoimpl();
		return dao.insert(meet);
	}
	public List<Meets> findAll(int oid) {
		// TODO Auto-generated method stub
		MeetsDao dao=new MeetsDaoimpl();
		System.out.println("有人来这里了");
		return dao.findAll(oid);
	}
	public void modify() {
		// TODO Auto-generated method stub
		MeetsDao dao=new MeetsDaoimpl();
		dao.modify();
	}
	public void delete(String meet_title, int oid) {
		// TODO Auto-generated method stub
		MeetsDao dao=new MeetsDaoimpl();
		dao.delete(meet_title, oid);
	}
	public List<Meets> findAll() {
		// TODO Auto-generated method stub
		MeetsDao dao=new MeetsDaoimpl();
		return dao.findAll();
	}


	@Override
	public Meets find(int meet_id) {
		MeetsDao dao=new MeetsDaoimpl();
		return dao.find(meet_id);
	}


	@Override
	public Page<Meets> findMeetsByPage(int currentPage) {
		Page<Meets> page=new Page<Meets>();
		int pageSize=MeetsDao.PAGE_SIZE;
		page.setCurrentPage(currentPage);//当前页
		page.setPageSize(pageSize);//页数大小
		MeetsDao dao=new MeetsDaoimpl();
		List<Meets> list = dao.findMeetsByPage(currentPage);
		page.setList(list);//显示当前会议集
		
		int count =dao.findCount();//得到总的会议个数
		page.setTotalSize(count);//储存
		
		page.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
		return page;
	}
	@Override
	public int find(String meet_title, int oid) {
		MeetsDao dao=new MeetsDaoimpl();
		return dao.find(meet_title, oid);
	}
	@Override
	public Meets find(String meet_title) {
		MeetsDao dao=new MeetsDaoimpl();
		return dao.find(meet_title);
	}

}
