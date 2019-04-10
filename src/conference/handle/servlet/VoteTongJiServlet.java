package conference.handle.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Organizer;
import conference.handle.bean.Vote;
import conference.handle.bean.VoteTongJi;
import conference.handle.bean.Vote_item;
import conference.handle.service.VoteService;
import conference.handle.service.VoteTongJiService;
import conference.handle.service.Vote_itemService;
import conference.handle.service.impl.VoteServiceimpl;
import conference.handle.service.impl.VoteTongJiServiceimpl;
import conference.handle.service.impl.Vote_itemServiceimpl;

/**
 * Servlet implementation class VoteTongJiServlet
 * 投票统计详情,投票总数，各个得票数
 */
@WebServlet("/VoteTongJiServlet")
public class VoteTongJiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		//可从会话得，也可从表单得
		Organizer org = (Organizer) session.getAttribute("org");
		 //String o_id = request.getParameter("oid");
		 int oid=org.getOid();
		 String meet_title=request.getParameter("meet_title");
		 System.out.println(meet_title);
		 //
		 Vote vote=new Vote();
		 vote.setMeet_title(meet_title);
		 vote.setOid(oid);
		 
		 VoteService service=new VoteServiceimpl();
		 String sql="select * from vote where meet_title=?and oid=?";
		 List<Vote> list = service.find(sql, vote);
		 //得到投票id
		 if(list.size()>0) {
			Vote vote1 = list.get(0);
			int vid = vote1.getVid();
			
			VoteTongJi voteTongJi2 = service.find(vid);
			if(voteTongJi2.getMeet_title().equals("")) {
				System.out.println("还没用户投票");
				response.getWriter().write("fali");
			}else {
				request.setAttribute("vote_x", list);
				request.setAttribute("vt", voteTongJi2);
				
				System.out.println("voteTongJi2"+voteTongJi2.getSelect1()+voteTongJi2.getSelect2()+voteTongJi2.getSelect3());
				response.setContentType("text/html;chasrset=UTF-8");
//				ajax实时更新
//				缺少会议title从哪里获取好点
				request.getRequestDispatcher("toupiaoxiang.jsp").forward(request, response);
				//response.sendRedirect("统计详情页面");
			}
//			Vote_itemService service1=new Vote_itemServiceimpl();
//			List<Vote_item> list2 = service1.find(sql, n);
			//得到总的投票数了
//			VoteTongJiService service2=new VoteTongJiServiceimpl();
//			VoteTongJi voteTongJi = service2.tongji(list2);
//			存到会话中。然后输出显示
//			voteTongJi.setMeet_title(meet_title);

		 }else {
			 System.out.println("对不起，您还没发起该会议的投票");
			 response.sendRedirect("wjtongji.jsp");
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
