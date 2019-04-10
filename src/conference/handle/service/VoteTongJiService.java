package conference.handle.service;

import java.util.List;

import conference.handle.bean.VoteTongJi;
import conference.handle.bean.Vote_item;

public interface VoteTongJiService {
  VoteTongJi tongji(List<Vote_item> list);
}
