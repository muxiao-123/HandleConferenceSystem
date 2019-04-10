package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Attendees;
import conference.handle.bean.Meets;
import conference.handle.bean.Vote_item;
import conference.handle.service.MeetsService;
import conference.handle.service.Vote_itemService;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.service.impl.Vote_itemServiceimpl;

/**
 * Servlet implementation class TouPiaoServlet
 */
@WebServlet("/TouPiaoServlet")
public class TouPiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("来了一个请i去");
	    

		request.setCharacterEncoding("UTF-8");
		String vid= request.getParameter("vid");
	    System.out.println(vid);
		HttpSession session = request.getSession();
		Attendees att = (Attendees) session.getAttribute("att");
		//获取id
		int aid=att.getAid();
	    String meet_title =request.getParameter("meet_title");
	    System.out.println(meet_title);
	    MeetsService service=new MeetsServiceimpl();
	    //获取会议id
	    Meets meets = service.find(meet_title);
	    int meet_id = meets.getMeet_id();
	    //String a_id= request.getParameter("aid");
	    String select_s=request.getParameter("selectStatus");
	    System.out.println(select_s);
	    //获取选着状态
	    int selectStatus=Integer.parseInt(select_s);
	    //进入页面携带vid,
	    int v_id=Integer.parseInt(vid);
	    
	    Vote_item v_item= new Vote_item();
	    v_item.setV_id(v_id);
	    v_item.setMeet_id(meet_id);
	    v_item.setAid(aid);
	    v_item.setSelectStatus(selectStatus);
	    Vote_itemService service1=new Vote_itemServiceimpl();
	    boolean isSuccess = service1.insert(v_item);
	    if(isSuccess) {
	    	System.out.println("ok");
	    	response.setContentType("text/html;charset=UTF-8");
	    	//此处应该定位到投票结果统计页面，视情况而定
	    	response.sendRedirect("index1.jsp");
	    }else {
	    	System.out.println("fail");
	    	String text="投票失败";
	    	request.setAttribute("text", text);
	    	request.getRequestDispatcher("index1.jsp").include(request, response);
//	    	response.sendRedirect("投票界面");//ajax实时更新
	    }
	}

}
