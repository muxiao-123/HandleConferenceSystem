package conference.handle.service.impl;

import java.util.List;

import conference.handle.bean.VoteTongJi;
import conference.handle.bean.Vote_item;
import conference.handle.service.VoteTongJiService;

public class VoteTongJiServiceimpl implements VoteTongJiService {

	

	@Override
	public VoteTongJi tongji(List<Vote_item> list2) {
		VoteTongJi vtj=new VoteTongJi();
		 int j=0;
		 int k=0;
		 int l=0;
		 int m=0;
		//得到投票总数
		 vtj.setAllVote(list2.size());
		  //以状态判定结果是否被选中1234.
		  for(int i=0;i<list2.size();i++) {
			  Vote_item vit=new Vote_item();
			   vit=list2.get(i);
			   int selectStatus = vit.getSelectStatus();
			   if(selectStatus==1) {
				   //得到一数量
				   vtj.setSelect1(j++);
			   }else if(selectStatus==2){
				 //得到一数量
				   vtj.setSelect2(k++);
			   }else if(selectStatus==3) {
				 //得到一数量
				   vtj.setSelect3(l++);
			   }else if(selectStatus==4) {
				 //得到一数量
				   vtj.setSelect4(m++);
			   }
		  }
		  
		return vtj;
	}

}
