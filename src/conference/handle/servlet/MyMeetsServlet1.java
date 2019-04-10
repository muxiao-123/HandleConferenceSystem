package conference.handle.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import conference.handle.service.BaoMingService;
import conference.handle.service.MeetsService;
import conference.handle.service.impl.BaoMingServiceimpl;
import conference.handle.service.impl.MeetsServiceimpl;

/**
 * Servlet implementation class MyMeetsServlet1
 *与会者参加的会议信息
 */
@WebServlet("/MyMeetsServlet1")
public class MyMeetsServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  HttpSession session = request.getSession();
			 
		  // Attendees attend =(Attendees)session.getAttribute("att");
		    // BaoMing bm=(BaoMing) session.getAttribute("bm1");
		     Attendees attend = (Attendees) session.getAttribute("att");
		     System.out.println("来了一个请求"+attend);
		     int aid =attend.getAid();
		     BaoMingService service=new BaoMingServiceimpl();
		     String sql="select * from baoming where aid=?";
		     List<BaoMing> list = service.findAll(sql,aid);
		     List<Meets> list1=new ArrayList<>();
		     //单个来说
		     //循环输出meet会议信息list
		       for(int i=0;i<list.size();i++) {
		    	   BaoMing bm1=list.get(i);
		    	   int meet_id = bm1.getMeet_id();
		    	   MeetsService service1= new MeetsServiceimpl();
				   Meets meets = service1.find(meet_id);
				   list1.add(meets);
		       }
		       System.out.println(list1);
		     //BaoMingService service=new BaoMingServiceimpl();
		     //MeetsService service1= new MeetsServiceimpl();
		     //Meets meets = service1.find(meet_id);
		     //List<BaoMing> list1 = service.findAll(aid);
		     //每次只能查一次，并且累加问题有待解决
		     request.getSession().setAttribute("a_list", list1);
		     
		     //MeetsService service=new MeetsServiceimpl();
		    // MeetsService service1= new MeetsServiceimpl();
		    //List<Meets> list = service1.findAll(meet_id);
		    //System.out.println(list1);
		    //会话冲突？和前一个会话
		    //request.getSession().setAttribute("list3", list);
		    //System.out.println(list1);
		     
		   response.setContentType("text/html;charset=UTF-8");
		   //PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8*1024, true);
		   //pageContext.setAttribute("list2", list1);
		   //request.get
		  
		   response.sendRedirect("Myconference.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		   
	}

}
