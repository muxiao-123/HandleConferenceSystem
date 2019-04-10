package conference.handle.service.impl;

import java.util.ArrayList;
import java.util.List;

import conference.handle.bean.HuiDa;
import conference.handle.bean.HuiDaTongJi;
import conference.handle.dao.HuiDaDao;
import conference.handle.dao.impl.HuiDaDaoimpl;
import conference.handle.service.HuiDaService;


public class HuiDaServiceimpl implements HuiDaService {

	@Override
	public boolean insert(String sql, HuiDa hd) {
		HuiDaDao dao=new HuiDaDaoimpl();
		return dao.insert(sql, hd);
	}

	@Override
	public boolean delete(String sql, int aid, String meet_title) {
		HuiDaDao dao=new HuiDaDaoimpl();
		return dao.delete(sql, aid, meet_title);
	}

	@Override
	public List<HuiDa> find(String sql, int qid, String meet_title) {
		HuiDaDao dao=new HuiDaDaoimpl();
		return dao.find(sql, qid, meet_title);
	}

	@Override
	public List<HuiDa> findAll() {
		HuiDaDao dao=new HuiDaDaoimpl();
		return dao.findAll();
	}

	@Override
	public List<HuiDa> find(String sql, HuiDa hd) {
		HuiDaDao dao=new HuiDaDaoimpl();
		return dao.find(sql, hd);
	}

	@Override
	public HuiDaTongJi<HuiDa> find(HuiDa hd) {
		// TODO Auto-generated method stub
		//问卷调查统计
		HuiDaTongJi<HuiDa> hdtj= new HuiDaTongJi<HuiDa>();
		String sql="select * from huida where qid=?";
		HuiDaDao dao=new HuiDaDaoimpl();
		List<HuiDa> list = dao.find(sql, hd);
		//存储hui答内容
		List<String> hui_da_list1=new ArrayList<>();
		List<String> hui_da_list2=new ArrayList<>();
		List<String> hui_da_list3=new ArrayList<>();
		List<String> hui_da_list4=new ArrayList<>();
		List<String> hui_da_list5=new ArrayList<>();
		
		if(list.size()>0) {
			hdtj.setAllHuida(list.size());
			for(int i=0;i<list.size();i++) {
				//循环输出回答并添加到集合
				  HuiDa huiDa = list.get(i);
				  String hui_da1 = huiDa.getHui_da1();
				  String hui_da2 = huiDa.getHui_da2();
				  String hui_da3 = huiDa.getHui_da3();
				  String hui_da4 = huiDa.getHui_da4();
				  String hui_da5 = huiDa.getHui_da5();
				  hui_da_list1.add(hui_da1);
				  System.out.println("回答的值为="+hui_da1);
				  hui_da_list2.add(hui_da2);
				  hui_da_list3.add(hui_da3);
				  hui_da_list4.add(hui_da4);
				  hui_da_list5.add(hui_da5);
			}
			//储存循环后的值
			hdtj.setMeet_title(hd.getMeet_title());
			hdtj.setHui_da_list1(hui_da_list1);
			hdtj.setHui_da_list2(hui_da_list2);
			hdtj.setHui_da_list3(hui_da_list3);
			hdtj.setHui_da_list4(hui_da_list4);
			hdtj.setHui_da_list5(hui_da_list5);
			
			return hdtj;
		}else {
			
			System.out.println("还没有人参与问卷，或者您还没发布问卷");
			//此时hdtj为空
			return hdtj;
		}
	}

}
