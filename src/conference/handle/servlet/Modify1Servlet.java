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
 * Servlet implementation class Modify1Servlet
 */
@WebServlet("/Modify1Servlet")
public class Modify1Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userName = request.getParameter("userName");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobilePhone=request.getParameter("mobilePhone");
		System.out.println("mobilePhone"+mobilePhone);
//		得到会话id取值
	    HttpSession session = request.getSession();
	    Organizer organ =(Organizer)session.getAttribute("org");
	    
	    int oid=organ.getOid();
	    
	    
//	    调用这个实例，同样能成功只不过在另外一张表变化
		//AttendeesDao dao=new AttendeesDaoimpl();
	    OrganizerDao dao=new OrganizerDaoimpl();
		//Attendees atta=dao.findInfo(userName, password);
		boolean isSuccess = dao.update(userName, password, email, mobilePhone,oid);
		if(isSuccess) {
			
			//System.out.println("成功");
			response.sendRedirect("../Login.html");
		}else {
			//System.out.println("失败");
			
			response.sendRedirect("yonghuxinxi.jsp");
		}
	}

}
