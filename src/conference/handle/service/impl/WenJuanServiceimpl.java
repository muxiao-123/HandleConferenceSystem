package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.WenJuan;
import conference.handle.dao.WenJuanDao;
import conference.handle.dao.impl.WenJuanDaoimpl;
import conference.handle.service.WenJuanService;

public class WenJuanServiceimpl implements WenJuanService {

	@Override
	public boolean insert(String sql, WenJuan wj) {
		WenJuanDao dao=new WenJuanDaoimpl();
		
		return dao.insert(sql, wj);
	}

	@Override
	public boolean delete(String sql, int oid, String meet_title) {
		WenJuanDao dao=new WenJuanDaoimpl();
		return dao.delete(sql, oid, meet_title);
	}

	@Override
	public List<WenJuan> find(String sql, int oid, String meet_title) {
		WenJuanDao dao=new WenJuanDaoimpl();
		return dao.find(sql, oid, meet_title);
	}

	@Override
	public List<WenJuan> findAll() {
		WenJuanDao dao=new WenJuanDaoimpl();
		return dao.findAll();
	}

	@Override
	public List<WenJuan> find(String sql, WenJuan wj) {
		WenJuanDao dao=new WenJuanDaoimpl();
		return dao.find(sql, wj);
	}


}
