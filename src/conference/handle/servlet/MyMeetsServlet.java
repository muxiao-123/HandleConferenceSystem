package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import conference.handle.bean.Meets;
import conference.handle.bean.Organizer;
import conference.handle.service.MeetsService;
import conference.handle.service.impl.MeetsServiceimpl;

/**
 * Servlet implementation class MyMeetsServlet
 * 发布的会议
 */
@WebServlet("/MyMeetsServlet")
public class MyMeetsServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		   //System.out.println("来了一个请求");
		   HttpSession session = request.getSession();
		 
		   Organizer organ =(Organizer)session.getAttribute("org");
		 
		   int oid = organ.getOid();
		    
		    MeetsService service= new MeetsServiceimpl();
		    List<Meets> list1 = service.findAll(oid);
		    //System.out.println(list1);
		    //会话冲突？和前一个会话
		   request.getSession().setAttribute("list2", list1);
		    //System.out.println(list1);
		   response.setContentType("text/html;charset=UTF-8");
		   //PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8*1024, true);
		   //pageContext.setAttribute("list2", list1);
		   //request.get
		   response.sendRedirect("Myconference.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
	}

}
