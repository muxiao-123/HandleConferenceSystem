package conference.handle.service;

import java.util.List;

import conference.handle.bean.Qd_item;

public interface Qd_itemService {
  boolean insert(Qd_item qd);
  List<Qd_item> findAll(String meet_title);
  boolean find(String meet_title,String a_userName);
}
