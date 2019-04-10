package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Attendees;
import conference.handle.bean.HuiDa;
import conference.handle.service.HuiDaService;
import conference.handle.service.impl.HuiDaServiceimpl;

/**
 * Servlet implementation class WenJuanServlet
 */
@WebServlet("/WenJuanServlet")
public class WenJuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String q_id = request.getParameter("qid");
		String meet_title = request.getParameter("meet_title");
		String hui_da1 = request.getParameter("hui_da1");
		String hui_da2 = request.getParameter("hui_da2");
		String hui_da3 = request.getParameter("hui_da3");
		String hui_da4 = request.getParameter("hui_da4");
		String hui_da5 = request.getParameter("hui_da5");
		HttpSession session = request.getSession();
		Attendees att = (Attendees) session.getAttribute("att");
//		String a_id = request.getParameter("aid");
		int qid=Integer.parseInt(q_id);
		int aid=att.getAid();
		
		HuiDa hd=new HuiDa();
		hd.setQid(qid);
		hd.setMeet_title(meet_title);;
		hd.setHui_da1(hui_da1);
		hd.setHui_da2(hui_da2);
		hd.setHui_da3(hui_da3);
		hd.setHui_da4(hui_da4);
		hd.setHui_da5(hui_da5);
		hd.setAid(aid);
		
		HuiDaService service=new HuiDaServiceimpl();
		String sql="insert into huida values(?,?,?,?,?,?,?,?)";
		
		boolean isSuccess = service.insert(sql, hd);
		response.setContentType("text/html;charset=UTF-8");
		if(isSuccess) {
			System.out.println("参与成功");
			//跳转时情况而定
			response.sendRedirect("index1.jsp");
		}else{
			System.out.println("失败");
			//跳转时情况而定
			request.getRequestDispatcher("wenjuanxiang.jsp").include(request, response);
		}
	}

}
