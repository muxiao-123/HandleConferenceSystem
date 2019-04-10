package conference.handle.dao;

import conference.handle.bean.Admin;

public interface AdminDao {

	boolean find(String name, String password);
}
