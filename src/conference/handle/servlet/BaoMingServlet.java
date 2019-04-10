package conference.handle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.BaoMing;
import conference.handle.service.BaoMingService;
import conference.handle.service.impl.BaoMingServiceimpl;

/**
 * Servlet implementation class BaoMingServlet
 */
@WebServlet("/BaoMingServlet")
public class BaoMingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		System.out.println("来了一个请求");
		String mid = request.getParameter("meet_id");
		String a_id = request.getParameter("aid");
		String a_userName = request.getParameter("a_userName");
		String a_email = request.getParameter("a_email");
		int meet_id=Integer.parseInt(mid);
		if(a_id!=null) {
			int aid=Integer.parseInt(a_id);
			BaoMing bm=new BaoMing();
			bm.setMeet_id(meet_id);
			bm.setAid(aid);
			bm.setA_userName(a_userName);
			bm.setA_email(a_email);
			BaoMingService service= new BaoMingServiceimpl();
			boolean isSuccess = service.insert(bm);
			//通过这个查询我的会议
			request.getSession().setAttribute("bm1", bm);
			response.setContentType("text/html;charset=UTF-8");
			if(isSuccess) {
				System.out.println("报名成功");
				response.sendRedirect("index1.jsp");//转到首页
			}else {
				String msg="报名失败";
				System.out.println("报名失败");//转到错误页面
				response.getWriter().write("fail....");
			}
			
		}else {
			//0代表为登陆报名的。通过邮箱邀请参会的
		    int aid=0;
		    BaoMing bm1=new BaoMing();
			bm1.setMeet_id(meet_id);
			bm1.setAid(aid);
			bm1.setA_userName(a_userName);
			bm1.setA_email(a_email);
			BaoMingService service= new BaoMingServiceimpl();
			boolean isSuccess1 = service.insert(bm1);
			if(isSuccess1) {
				String msg="报名成功";
				System.out.println("报名成功");
				request.setAttribute("msg", msg);
				response.setContentType("text/html;charset=UTF-8");
				request.getRequestDispatcher("YQCJ.jsp").forward(request, response);
//				response.sendRedirect("index1.jsp");//转到首页
			}else {
				String msg1="报名失败";
				request.setAttribute("msg1", msg1);
				response.setContentType("text/html;charset=UTF-8");
				request.getRequestDispatcher("YQCJ.jsp").forward(request, response);
			}
		}
		
	}

}
