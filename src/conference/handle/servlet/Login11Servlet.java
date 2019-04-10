package conference.handle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.Admin;
import conference.handle.dao.AdminDao;
import conference.handle.dao.impl.AdminDaoimpl;

/**
 * Servlet implementation class Login11Servlet
 */
@WebServlet("/Login11Servlet")
public class Login11Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login11Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		Admin admin=new Admin();
		System.out.println("来了一个123请求");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
//		admin.setName(name);
//		admin.setPassword(password);
		System.out.println(name+password);
		AdminDao dao=new AdminDaoimpl();
		boolean isSuccess = dao.find(name, password);
		if(isSuccess) {
			Admin admin=new Admin();
			admin.setName(name);
			admin.setPassword(password);
			System.out.println(name+password);
			request.getSession().setAttribute("admin", admin);
			response.setContentType("text/html;charset=UTF-8");
			request.getRequestDispatcher("wsnd").forward(request, response);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			String data="用户名或密码错误！请重新输入";
			request.setAttribute("data", data);
			//response.getWriter().write("用户名或密码错误！请重新输入");
			System.out.println("发送了效应数据");
		    request.getRequestDispatcher("Longin.jsp").forward(request, response);
		}
	}

}
