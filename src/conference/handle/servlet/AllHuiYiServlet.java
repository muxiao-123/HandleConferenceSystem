package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Attendees;
import conference.handle.bean.Meets;
import conference.handle.bean.Page;
import conference.handle.bean.Vote;
import conference.handle.bean.WenJuan;
import conference.handle.service.MeetsService;
import conference.handle.service.VoteService;
import conference.handle.service.WenJuanService;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.service.impl.VoteServiceimpl;
import conference.handle.service.impl.WenJuanServiceimpl;


/**
 * Servlet implementation class AllHuiYiServlet
 */
@WebServlet("/AllHuiYiServlet")
public class AllHuiYiServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html;charset=UTF-8");
		
		try {
			int currentPage=1;
			String cp = request.getParameter("currentPage");
			
			if(cp!=null) {
			 currentPage =Integer.parseInt(cp);
			}else {
				currentPage=1;
			}
			MeetsService service= new MeetsServiceimpl();
			Page<Meets> page = service.findMeetsByPage(currentPage);
			
			
			
			VoteService service1=new VoteServiceimpl();
			List<Vote> list = service1.findAll();
			WenJuanService service2=new WenJuanServiceimpl();
			List<WenJuan> list2 = service2.findAll();
			request.getServletContext().setAttribute("page", page);//储存会议集合
			request.getServletContext().setAttribute("v_list", list);//存储投票集合
			request.getServletContext().setAttribute("wj_list", list2);//存储问卷集合
			
			//得到会话，判断是否登陆
			HttpSession session = request.getSession();
			;
			
			if(session.getAttribute("att")==null) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("index1.jsp").forward(request, response);
			}
			//List<Meets> list=service.findAll();
			//request.setAttribute("list", list);
			//设置全局参数-->application
			//VoteService service1=new VoteServiceimpl();
			//List<Vote> list2 = service1.findAll();
			//WenJuanService service2=new WenJuanServiceimpl();
			//List<WenJuan> list3 = service2.findAll();
			//会议全局
			//request.getServletContext().setAttribute("list", list);
			//投票全局
			//request.getServletContext().setAttribute("list_votes", list2);
			//问卷全局
			//request.getServletContext().setAttribute("list_wen_juan", list3);
			//System.out.println(list);
			//System.out.println(list2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
//		request.setCharacterEncoding("UTF-8");
//		//response.setContentType("text/html;charset=UTF-8");
//		MeetsService service= new MeetsServiceimpl();
//		List<Meets> list=service.findAll();
//		request.setAttribute("list", list);
//		System.out.println(list);
//		request.getRequestDispatcher("index1.jsp").forward(request, response);
//		response.sendRedirect("index1.jsp");
	}

}
