package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.Attendees;
import conference.handle.bean.Organizer;

/**
 * Servlet implementation class TuiChuServlet
 */
@WebServlet("/TuiChuServlet")
public class TuiChuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//清理会话信息
//		String requestedSessionId = request.getRequestedSessionId();
//		System.out.println(requestedSessionId);
		Attendees att=(Attendees) request.getSession().getAttribute("att");
		if(att!=null) {
			request.getSession().invalidate();
			response.setContentType("text/html;charset=UTF-8");
			request.getRequestDispatcher("eeee").include(request, response);
		}else {
			Organizer org = (Organizer) request.getSession().getAttribute("org");
			if(org!=null) {
				String start = org.getO_userName();
				request.getServletContext().removeAttribute(start);
				request.getSession().invalidate();
				response.setContentType("text/html;charset=UTF-8");
				request.getRequestDispatcher("eeee").include(request, response);
			}else {
				request.getSession().invalidate();
				response.setContentType("text/html;charset=UTF-8");
				request.getRequestDispatcher("eeee").include(request, response);
			}
			
			
		}
//		String requestedSessionId1 = request.getRequestedSessionId();
//		System.out.println(requestedSessionId1);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
