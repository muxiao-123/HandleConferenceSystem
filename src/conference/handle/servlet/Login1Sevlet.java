package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Organizer;
import conference.handle.dao.OrganizerDao;
import conference.handle.dao.impl.OrganizerDaoimpl;

/**
 * Servlet implementation class Login1Sevlet
 * 组织者登陆
 */
@WebServlet("/Login1Sevlet")
public class Login1Sevlet extends HttpServlet {

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html;chatset=utf-8");
		 String userName=request.getParameter("userName");
		 String password=request.getParameter("password");
		 
		 //userName =new String(userName.getBytes("ISO-8859-1"),"UTF-8");
		 //System.out.println("userName"+userName+"password"+password);
		 
		 OrganizerDao dao=new OrganizerDaoimpl();
		 
		boolean isSuccess = dao.login(userName, password);
			System.out.println(isSuccess);
		 if(isSuccess) {
			 
			 //AttendeesDao attend=new AttendeesDaoimpl();
			 OrganizerDao organ=new OrganizerDaoimpl();
//			 List<Attending> list=attend.findInfo(userName,password);
			 Organizer org=organ.findInfo(userName, password);
			 //Attendees att=attend.findInfo(userName, password);
			 //System.out.println("att");
			 //System.out.println("useeName"+att.getUserName());
			 
			  request.getSession().setAttribute("org", org);
			  HttpSession session = request.getSession();
			  //session.setMaxInactiveInterval(60*1);设置会话时间
			 
			 response.sendRedirect("admin/Myconference.jsp");
		 }else {
			 response.getWriter().write("fail....."+userName);
		 }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
