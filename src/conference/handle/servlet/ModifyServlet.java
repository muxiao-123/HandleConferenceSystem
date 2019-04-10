package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import conference.handle.bean.Attendees;
import conference.handle.dao.AttendeesDao;
import conference.handle.dao.impl.AttendeesDaoimpl;

/**
 * Servlet implementation class ModifyServlet
 * 修改用户信息
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {

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
		String phone=request.getParameter("mobilePhone");
//		得到会话id取值
	    HttpSession session = request.getSession();
	    Attendees atten =(Attendees)session.getAttribute("att");
	    
	    int aid=atten.getAid();
	    		
		AttendeesDao dao=new AttendeesDaoimpl();
		//Attendees atta=dao.findInfo(userName, password);
		boolean isSuccess = dao.update(userName, password, email, phone,aid);
		if(isSuccess) {
			
			//System.out.println("成功");
			response.sendRedirect("Login.html");
		}else {
			//System.out.println("失败");
			
			response.sendRedirect("yonghuxinxi.jsp");
		}
	}

}
