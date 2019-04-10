package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Attendees;
import conference.handle.bean.BaoMing;
import conference.handle.bean.Meets;
import conference.handle.bean.WenJuan;
import conference.handle.service.BaoMingService;
import conference.handle.service.MeetsService;
import conference.handle.service.WenJuanService;
import conference.handle.service.impl.BaoMingServiceimpl;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.service.impl.WenJuanServiceimpl;

/**
 * Servlet implementation class CanYuWJServlet
 */
@WebServlet("/CanYuWJServlet")
public class CanYuWJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		Attendees att = (Attendees) session.getAttribute("att");
		int aid=att.getAid();
		String meet_title = request.getParameter("meet_title");
		System.out.println(meet_title);
		//String a_id = request.getParameter("aid");
		//String mee_id=request.getParameter("meet_id");
		MeetsService service3=new MeetsServiceimpl();
        Meets meets = service3.find(meet_title);
        int meet_id = meets.getMeet_id();
        Meets find = service3.find(meet_id);
        int oid = find.getOid();
//		String o_id=request.getParameter("oid");
		
//		int aid=Integer.parseInt(a_id);
//		int meet_id=Integer.parseInt(mee_id);
//		int oid=Integer.parseInt(o_id);
		BaoMingService service=new BaoMingServiceimpl();
		String sql="select * from baoming where aid=? and meet_id=?";
		List<BaoMing> list =service.findAll(sql, aid, meet_id);
		if(list.size()>0) {
			WenJuanService service1=new WenJuanServiceimpl();
			//VoteService service1=new VoteServiceimpl();
			//通过会议标题查询信息，返回到问卷页面，
		   String sql1="select * from wenjuan where oid=? and meet_title=?";
		   List<WenJuan> list2 = service1.find(sql1, oid, meet_title);
//		   System.out.println(list2.get(0).getWen_ti1());
//		   值没存到请求中
		   request.setAttribute("list_wenJuan_message", list2);
//		   request.getSession().setAttribute("list_wenJuan_message", list2);
//					List<Vote> list2 = service1.find(sql, meet_id);
//					request.getSession().setAttribute("list_vote_message", list2);
		   response.setContentType("text/html;charset=UTF-8");
		   request.getRequestDispatcher("wenjuanxiang.jsp").include(request, response);
//					response.sendRedirect("wenjuanxiang.jsp");
        }else {
        	System.out.println("你没有参与该会B不能参与问卷");
        	response.sendRedirect("index1.jsp");
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		request.setCharacterEncoding("UTF-8");
		//都市先从表单或者ajax里获得请求数据
		
		
	}

}
