package conference.handle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.dao.AttendeesDao;
import conference.handle.dao.OrganizerDao;
import conference.handle.dao.impl.AttendeesDaoimpl;
import conference.handle.dao.impl.OrganizerDaoimpl;

/**
 * Servlet implementation class RegisterServlet
 * 注册Servlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		Object admin = request.getSession().getAttribute("admin");
		if(admin==null) {
			response.setContentType("text/html;charset=utf-8");
			String userName =  request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phone = request.getParameter("mobilePhone");
			AttendeesDao dao=new AttendeesDaoimpl();
			boolean isSuccess= dao.register(userName, password, email,phone);
				if(isSuccess) {
					//System.out.println("success");
					response.sendRedirect("Login.html");
				}else {
					//System.out.println("fail");
					String msg="注册失败";
					request.setAttribute("msg3", msg);
					request.getRequestDispatcher("Register.jsp").forward(request, response);
	//				response.sendRedirect("Register.jsp");
				}
		}else {
			String userName =  request.getParameter("o_userName");
			String password = request.getParameter("o_password");
			String email = request.getParameter("o_email");
			String phone = request.getParameter("o_mobilePhone");
			OrganizerDao dao=new OrganizerDaoimpl();
			System.out.println("来到管理员添加页面");
			boolean isSuccess = dao.register(userName, password, email, phone);
			if(isSuccess) {
			
				response.setContentType("html/text;charset=UTF-8");
				response.sendRedirect("guanLi/wsnd");
			}else {
				System.out.println("添加失败");
				String msg="添加失败";
				request.setAttribute("msg4", msg);
				response.setContentType("html/text;charset=UTF-8");
				request.getRequestDispatcher("guanLi/admin.jsp").forward(request, response);
			}
		}
		
		
	}
}
