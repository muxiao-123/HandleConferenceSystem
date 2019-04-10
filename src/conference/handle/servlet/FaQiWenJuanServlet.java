package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Organizer;
import conference.handle.bean.WenJuan;
import conference.handle.service.WenJuanService;
import conference.handle.service.impl.WenJuanServiceimpl;

/**
 * Servlet implementation class FaQiWenJuanServlet
 * 发起问卷调查
 */
@WebServlet("/FaQiWenJuanServlet")
public class FaQiWenJuanServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				request.setCharacterEncoding("UTf-8");
				String meet_title = request.getParameter("meet_title");
				String wen_juan_theme = request.getParameter("wen_juan_theme");
				String wen_ti1 = request.getParameter("wen_ti1");
				String wen_ti2 = request.getParameter("wen_ti2");
				String wen_ti3 = request.getParameter("wen_ti3");
				String wen_ti4 = request.getParameter("wen_ti4");
				String wen_ti5 = request.getParameter("wen_ti5");
				//会话得到oid
				HttpSession session = request.getSession();
				Organizer org = (Organizer) session.getAttribute("org");
				int oid=org.getOid();
				//String o_id=request.getParameter("oid");
				//int oid=Integer.parseInt(o_id);
				//储存到对象里
				 WenJuan wj=new WenJuan();
				 wj.setMeet_title(meet_title);
				 wj.setWen_juan_theme(wen_juan_theme);
				 wj.setWen_ti1(wen_ti1);
				 wj.setWen_ti2(wen_ti2);
				 wj.setWen_ti3(wen_ti3);
				 wj.setWen_ti4(wen_ti4);
				 wj.setWen_ti5(wen_ti5);
				 wj.setOid(oid);
				
				//都市先直接从表单获取，不成功在考虑session
				WenJuanService service=new WenJuanServiceimpl();
				String sql="insert into wenjuan values(null,?,?,?,?,?,?,?,?)";
				boolean isSuccess = service.insert(sql, wj);
				response.setContentType("text/html;charset=UTF-8");
				if(isSuccess) {
					System.out.println("发起成功");
					response.sendRedirect("Myconference.jsp");
				}else{
					System.out.println("发起失败");
					response.sendRedirect("wenjuandiaocha.jsp");
				}
	}

}
