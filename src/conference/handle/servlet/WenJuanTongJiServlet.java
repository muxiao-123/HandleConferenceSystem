package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.HuiDa;
import conference.handle.bean.HuiDaTongJi;
import conference.handle.bean.Organizer;
import conference.handle.bean.WenJuan;
import conference.handle.service.HuiDaService;
import conference.handle.service.WenJuanService;
import conference.handle.service.impl.HuiDaServiceimpl;
import conference.handle.service.impl.WenJuanServiceimpl;

/**
 * Servlet implementation class WenJuanTongJiServlet
 */
@WebServlet("/WenJuanTongJiServlet")
public class WenJuanTongJiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//
		System.out.println("来了一个请i去");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Organizer org = (Organizer) session.getAttribute("org");
		int oid=org.getOid();
		System.out.println("oid="+oid);
//		String o_id = request.getParameter("oid");
		//String q_id = request.getParameter("qid");
		String meet_title = request.getParameter("meet_title");
		System.out.println(meet_title);
//		int oid=Integer.parseInt(o_id);
		//int qid=Integer.parseInt(q_id);
		WenJuanService service =new WenJuanServiceimpl();
		String sql="select * from wenjuan where oid=? and meet_title=?";
		List<WenJuan> wen_juan_list = service.find(sql, oid, meet_title);
		System.out.println("问卷个数"+wen_juan_list.size());
		if(wen_juan_list.size()>0) {
			HuiDaService service1=new HuiDaServiceimpl();
			HuiDa hd=new HuiDa();
			WenJuan wenJuan = wen_juan_list.get(0);
			int qid = wenJuan.getQid();
			hd.setQid(qid);
			hd.setMeet_title(meet_title);
			//统计bean,其中问题是string集合
			HuiDaTongJi<HuiDa> hdtj = service1.find(hd);
			if(hdtj.getMeet_title().equals("")) {
				System.out.println("还没有人参与问卷");
			}else {
				request.setAttribute("wj_list", wen_juan_list);
				request.setAttribute("hdtj", hdtj);
				System.out.println("回答1：="+hdtj.getHui_da_list1().get(0));
				response.setContentType("text/html;charset=UTF-8");
				request.getRequestDispatcher("wenjuanxiang.jsp").forward(request, response);
				
			}
			//数据统计页面
//			response.sendRedirect("wenjuantongjiyemian.jsp");
		}else {
			
			 System.out.println("你还没发布问卷");
			 response.sendRedirect("index1.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
