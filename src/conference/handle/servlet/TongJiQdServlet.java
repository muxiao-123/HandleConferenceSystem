package conference.handle.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.BaoMing;
import conference.handle.bean.Meets;
import conference.handle.bean.QDTongJi;
import conference.handle.bean.Qd_item;
import conference.handle.service.BaoMingService;
import conference.handle.service.MeetsService;
import conference.handle.service.Qd_itemService;
import conference.handle.service.impl.BaoMingServiceimpl;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.service.impl.Qd_itemServiceimpl;


/**
 * Servlet implementation class TongJiQdServlet
 */
@WebServlet("/TongJiQdServlet")
public class TongJiQdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
 
//        request.setCharacterEncoding("UTF-8");		 
		String meet_title = request.getParameter("meet_title");
		String meet_i = request.getParameter("meet_id");
	
		int meet_id=Integer.parseInt(meet_i);
		System.out.println(meet_title+"会议id="+meet_id);
		MeetsService service1=new MeetsServiceimpl();
		//会议规模数
		Meets meets2 = service1.find(meet_id);
		//规模数
		int number=meets2.getNumber();
		BaoMingService service3=new BaoMingServiceimpl();
		//报名人数
     	List<BaoMing> list2 = service3.findAll(meet_id);
     	int number1=list2.size();
     	
     	//存储报名总人员名单
     	List<String> allUser=new ArrayList<>();
     	//存储未签到人员名单
     	List<String> allUser1=new ArrayList<>();
     	
     	//存储签到了人员名单
     	List<String> allUser2=new ArrayList<>();
     	
     	for(int k=0;k<list2.size();k++) {
     		BaoMing baoMing = list2.get(k);
     		String userName = baoMing.getA_userName();
     		//得到总的报名用户
     		allUser.add(userName);
     	}
     	
        Qd_itemService service =new Qd_itemServiceimpl();
		//得到签到人员列表
		List<Qd_item> list = service.findAll(meet_title);
     	//查询为签到人数
     	//以及得到未签到人员名单
     	for(int l=0;l<allUser.size();l++) {
     		String userName = allUser.get(l);
     		//得到匹配值boolean
     		//是否得到时间
     		boolean find = service.find(meet_title, userName);
     		if(find) {
     			System.out.println("该用户签到了");
     			//存储签到了用户名单
     			allUser2.add(userName);
     		}else {
     			//该用户没签到，输出存储
     			allUser1.add(userName);
     		}
     	}
     	//签到成功，并且不是补签的
     	List<Qd_item> list_user= new ArrayList<>();
     	//签到成功，但是补签的
     	List<Qd_item> list_user1= new ArrayList<>();
     	//得到大多记录数，但是未签到人员名单没有
				if(list.size()>0) {
					//会议规模数
					//报名人数
					int count1=list2.size();
					//签到成功
					int count2=0;
					//签到总人数
					int allcount=list.size();
					//签到成功，但是补签的
					int count3=0;
					//未签到人数
					int count4=count1-allcount;
							for(int i=0;i<list.size();i++) {
								//取签到用户时间，然后对比会议时间，储存对比结果
								//MeetsService service2=new MeetsServiceimpl();
								Meets meets = service1.find(meet_id);
								//可能会出错
								Timestamp meet_time = meets.getStartDate();
								//储存用户名和时间
								Qd_item qd_i=new Qd_item(); 
								Qd_item qd_item = list.get(i);
								Timestamp qd_time = qd_item.getQd_time();
										if(meet_time.after(qd_time)) {
											System.out.println("签到成功，并且没迟到");
											//已签到人数，并且没迟到
											 count2++;
											 //哪个用户完全成功
											 //存到哪里
											 //输出成功人数集
											 qd_i.setA_userName(qd_item.getA_userName());
											 qd_i.setQd_time(qd_time);
											 //储存时间和用户名
											 //签到不补签
											 list_user.add(qd_i);
										}else {
											//储存数值
											//
											System.out.println("签到成功，但是补签");
											count3++;
											//哪个用户不是一定成功
											qd_i.setA_userName(qd_item.getA_userName());
											qd_i.setQd_time(qd_time);
											//储存时间和用户名
											//补签
											list_user1.add(qd_i);
										}
							}
							QDTongJi<String> qdtj=new QDTongJi<String>();
							//存储规模数
//							qdtj.setAllTotal(number);
							qdtj.setAllTotal(number);
							//报名数
							//总的报名人数名单
							//qdtj.setAllBM(number1);
							qdtj.setAllBM(number1);
							qdtj.setAllUser(allUser);
							//所有签到人数
							//qdtj.setAllQD(allcount);
							qdtj.setAllQD(allcount);
							//签到人员名单
							//qdtj.setAllUserK(allUser2);
							//qdtj.setAllUserK(allUserK);
							qdtj.setMeet_title(meet_title);
							//签到人数
							qdtj.setUserK(count2);
							qdtj.setAllUserK(list_user);
							//补录人数
							qdtj.setUserK1(count3);
							qdtj.setAllUserK1(list_user1);
							//没签到数
							qdtj.setAllNQD(count4);
							//未签到名单集合
							qdtj.setAllUserN(allUser1);
							request.setAttribute("Qd_list", qdtj);
							response.setContentType("text/html;charset=UTF-8");
							request.getRequestDispatcher("qiandao.jsp").forward(request, response);
				}else {
					response.setContentType("text/html;charset=UTF-8");
					System.out.println("没有用户签到");
					response.sendRedirect("Myconference.jsp");
				}
		//得到未签到用户
		//从这个sevlet可得到，会议规模，报名人数，签到人数，未签到人数，签到人数（但是迟到的），签到名单，
		//签到迟到名单，签到未迟到名单，未签到名单
		//把这些都封装为一个bean.然后再优化程序
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
