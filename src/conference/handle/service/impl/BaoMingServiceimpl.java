package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.BaoMing;
import conference.handle.dao.BaoMingDao;
import conference.handle.dao.impl.BaoMingDaoimpl;
import conference.handle.service.BaoMingService;

public class BaoMingServiceimpl implements BaoMingService {

	@Override
	public boolean insert(BaoMing bm) {
		// TODO Auto-generated method stub
		BaoMingDao dao=new BaoMingDaoimpl();
		return dao.insert(bm);
	}

	@Override
	public boolean delete(int meet_id,int aid) {
		// TODO Auto-generated method stub
		BaoMingDao dao=new BaoMingDaoimpl();
		return dao.delete(meet_id,aid);
	}

	@Override
	public List<BaoMing> findAll() {
		// TODO Auto-generated method stub
		BaoMingDao dao=new BaoMingDaoimpl();
		return dao.findAll();
	}

	@Override
	public List<BaoMing> findAll(String sql, int aid) {
		// TODO Auto-generated method stub
		BaoMingDao dao=new BaoMingDaoimpl();
		return dao.findAll(sql,aid);
	}

	@Override
	public boolean update(String a_userName, String a_email, int oid) {
		// TODO Auto-generated method stub
		BaoMingDao dao=new BaoMingDaoimpl();
		return dao.update(a_userName, a_email, oid);
	}

	@Override
	public List<BaoMing> findAll(String sql, int aid, int meet_id) {
		BaoMingDao dao=new BaoMingDaoimpl();
		return dao.findAll(sql, aid, meet_id);
	}

	@Override
	public List<BaoMing> findAll(int meet_id) {
		//通过这个查询报名人数
		BaoMingDao dao=new BaoMingDaoimpl();
		return dao.findAll(meet_id);
	}

}
