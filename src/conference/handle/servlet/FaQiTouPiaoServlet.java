package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Organizer;
import conference.handle.bean.Vote;
import conference.handle.service.VoteService;
import conference.handle.service.impl.VoteServiceimpl;

/**
 * Servlet implementation class FaQiTouPiaoServlet
 * 发起投票并返回投票信息
 */
@WebServlet("/FaQiTouPiaoServlet")
public class FaQiTouPiaoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String meet_title=request.getParameter("meet_title");
		String vote_content=request.getParameter("vote_content");
		String select1=request.getParameter("select1");
		String select2=request.getParameter("select2");
		//下面这两个可谓空
		String select3=request.getParameter("select3");
		String select4=request.getParameter("select4");
		//从绘画获取oid
		HttpSession session = request.getSession();
		Organizer org = (Organizer) session.getAttribute("org");
		int oid=org.getOid();
		//String o_id=request.getParameter("oid");
		//int oid=Integer.parseInt(o_id);
		//装到对象里去
		Vote vote=new Vote();
		vote.setMeet_title(meet_title);
		vote.setVote_content(vote_content);
		vote.setSelect1(select1);
		vote.setSelect2(select2);
		vote.setSelect3(select3);
		vote.setSelect4(select4);
		vote.setOid(oid);
		String sql="insert into vote values(null,?,?,?,?,?,?,?)";
		 VoteService service=new VoteServiceimpl();
		 boolean isSuccess = service.insert(sql, vote);
		 if(isSuccess) {
			 String sql1="select * from vote where oid=?";
			 List<Vote> list = service.find(sql1, oid);
			 //投票信息不包括投票结果
			 //把投票信息发布在首页蓝上
			 //可变结果，不一定能启动
			 request.getSession().setAttribute("list_tou_piao", list);
			 System.out.println("发布成功");
			 response.setContentType("text/html;chasrset");
			 response.sendRedirect("Myconference.jsp");
		 }else {
			 System.out.println("发布失败");
		 }
		
		
	
	}

}
