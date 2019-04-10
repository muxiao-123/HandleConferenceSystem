package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import conference.handle.bean.Attendees;
import conference.handle.bean.BaoMing;
import conference.handle.bean.Meets;
import conference.handle.bean.Vote;
import conference.handle.service.BaoMingService;
import conference.handle.service.MeetsService;
import conference.handle.service.VoteService;
import conference.handle.service.impl.BaoMingServiceimpl;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.service.impl.VoteServiceimpl;

/**
 * Servlet implementation class CanYuTPServlet
 * 参与投票，从主页上，并且只有登陆过的与会用户才能看到
 * ajax实时更新？
 */
@WebServlet("/CanYuTPServlet")
public class CanYuTPServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//得到aid和匹配的meet_id
		        HttpSession session = request.getSession();
		        Attendees att = (Attendees) session.getAttribute("att");
		        int aid=att.getAid();
		        String meet_title = request.getParameter("meet_title");
		        System.out.println(meet_title);
//				String a_id = request.getParameter("aid");
//				String mee_id=request.getParameter("meet_id");
//				int aid=Integer.parseInt(a_id);
//				int meet_id=Integer.parseInt(mee_id);
		        //通过标题查找id
		        MeetsService service3=new MeetsServiceimpl();
		        Meets meets = service3.find(meet_title);
		        int meet_id = meets.getMeet_id();
		        
				BaoMingService service=new BaoMingServiceimpl();
				String sql="select * from baoming where aid=? and meet_id=?";
				List<BaoMing> list =service.findAll(sql, aid, meet_id);
				if(list.size()>0) {
					VoteService service1=new VoteServiceimpl();
					//通过会议id查询信息，返回到投票页面，
					String sql1="select * from vote where meet_title=?";
					//要新建一个方法
							List<Vote> list2 = service1.find(sql1, meet_title);
							request.setAttribute("list_vote_message", list2);
							//request.getSession().setAttribute("list_vote_message", list2);
							response.setContentType("text/html;charset=UTF-8");
							request.getRequestDispatcher("votexiang.jsp").include(request, response);
							//response.sendRedirect("votexiang.jsp");
		        }else {
		        	System.out.println("你没有参与该会以不能投票");
		        	response.sendRedirect("index1.jsp");
		        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
	}

}
