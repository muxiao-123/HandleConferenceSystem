package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Attendees;
import conference.handle.dao.AttendeesDao;
import conference.handle.dao.impl.AttendeesDaoimpl;

/**
 * 登陆处理
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.setCharacterEncoding("UTF-8");处理中文编码异常
		response.setContentType("text/html;chatset=utf-8");
			
		 String userName=request.getParameter("userName");
		 String password=request.getParameter("password");
		 
		 //userName =new String(userName.getBytes("ISO-8859-1"),"UTF-8");
		 //System.out.println("userName"+userName+"password"+password);
		 
		 AttendeesDao dao=new AttendeesDaoimpl();
		 
		boolean isSuccess = dao.login(userName, password);
			System.out.println(isSuccess);
		 if(isSuccess) {
			 
			 AttendeesDao attend=new AttendeesDaoimpl();
//			 List<Attending> list=attend.findInfo(userName,password);
			 Attendees att=attend.findInfo(userName, password);
			 
			 //System.out.println("useeName"+att.getUserName());
			 
			 request.getSession().setAttribute("att", att);
			 HttpSession session = request.getSession();
			 session.setMaxInactiveInterval(60*30);
			 
			 response.sendRedirect("index1.jsp");
		 }else {
			 response.getWriter().write("fail....."+userName);
		 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
