package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.service.BaoMingService;
import conference.handle.service.impl.BaoMingServiceimpl;

/**
 * Servlet implementation class QuXiaoBMServlet
 * 取消报名就是删除我的参会会议信息
 */
@WebServlet("/QuXiaoBMServlet")
public class QuXiaoBMServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("来了一个请求==");
		String mid = request.getParameter("meet_id");
		String a_id = request.getParameter("aid");
		int meet_id=Integer.parseInt(mid);
		int aid=Integer.parseInt(a_id);
		System.out.println("meet_id="+meet_id);
		
		BaoMingService service=new BaoMingServiceimpl();
		boolean isSuccess = service.delete(meet_id,aid);
		if(isSuccess) {
			String msg="取消成功";
			request.setAttribute("msg", msg);
			response.setContentType("text/html;charset=UTF-8");
			request.getRequestDispatcher("Myconference.jsp").forward(request, response);
		}else {
			String msg1="取消失败";
			request.setAttribute("msg1", msg1);
			response.setContentType("text/html;charset=UTF-8");
			request.getRequestDispatcher("Myconference.jsp").forward(request, response);
		}
	}

}
