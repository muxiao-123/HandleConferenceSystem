package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.Vote;
import conference.handle.bean.VoteTongJi;
import conference.handle.bean.Vote_item;
import conference.handle.dao.VoteDao;
import conference.handle.dao.Vote_itemDao;
import conference.handle.dao.impl.VoteDaoimpl;
import conference.handle.dao.impl.Vote_itemDaoimpl;
import conference.handle.service.VoteService;
import conference.handle.service.Vote_itemService;

public class VoteServiceimpl implements VoteService {

	@Override
	public boolean insert(String sql, Vote vote) {
		VoteDao dao=new VoteDaoimpl();
		return dao.insert(sql, vote);
	}

	@Override
	public boolean delete(String sql,int vid) {
		VoteDao dao=new VoteDaoimpl();
		return dao.delete(sql,vid);
	}

	@Override
	public List<Vote> find(String sql, int id) {
		VoteDao dao=new VoteDaoimpl();
		return dao.find(sql, id);
	}

	@Override
	public List<Vote> findAll() {
		VoteDao dao=new VoteDaoimpl();
		return dao.findAll();
	}

	@Override
	public List<Vote> find(String sql, Vote vote) {
		VoteDao dao=new VoteDaoimpl();
		return dao.find(sql, vote);
	}

	@Override
	public List<Vote> find(String sql, String meet_title) {
		VoteDao dao=new VoteDaoimpl();
		return dao.find(sql, meet_title);
	}

	@Override
	public VoteTongJi find(int vid) {
		//得到会议标题和投票内容
		VoteDao dao1=new VoteDaoimpl();
		String sql="select * from vote where vid=?";
		List<Vote> list = dao1.find(sql, vid);
		Vote vote = list.get(0);
		String meet_title=vote.getMeet_title();
		String vote_content=vote.getVote_content();
		VoteTongJi vtj=new VoteTongJi();
		Vote_itemDao dao=new Vote_itemDaoimpl();
		//得到的选票数
		int select1=0;
		int select2=0;
		int select3=0;
		int select4=0;
		String sql1="select * from vote_item where vid=?";
		//得到所有投票项
		List<Vote_item> find = dao.find(sql1, vid);
		//设置总票数
		if(find.size()>0) {
			vtj.setAllVote(find.size());
			System.out.println("大小："+find.size());
				for(int i=0;i<find.size();i++) {
					Vote_item vote_item = find.get(i);
					
					
					int sStatus = vote_item.getSelectStatus();
							if(sStatus==1) {
								//1选择累加
							   select1++;	
							}else if(sStatus==2){
								//2选择累加
								select2++;
							}else if(sStatus==3) {
			                     //3选择累加
								select3++;
							}else if(sStatus==4) {
								//3选择累加
								select4++;
							}
				}
				vtj.setMeet_title(meet_title);
				vtj.setVote_content(vote_content);
				vtj.setSelect1(select1);
				System.out.println("sel1="+select1);
				vtj.setSelect2(select2);
				System.out.println("sel2="+select2);
				vtj.setSelect3(select3);
				System.out.println("sel3="+select3);
				vtj.setSelect4(select4);
				System.out.println("sel4="+select4);
				return vtj;
		}else {
			
			System.out.println("还没用户参与投票");
			vtj.setMeet_title("");
			    return vtj;
		}
		
	}

}
