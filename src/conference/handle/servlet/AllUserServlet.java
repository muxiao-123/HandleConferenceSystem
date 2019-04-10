package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.Attendees;
import conference.handle.bean.Meets;
import conference.handle.bean.Organizer;
import conference.handle.dao.AttendeesDao;
import conference.handle.dao.MeetsDao;
import conference.handle.dao.OrganizerDao;
import conference.handle.dao.impl.AttendeesDaoimpl;
import conference.handle.dao.impl.MeetsDaoimpl;
import conference.handle.dao.impl.OrganizerDaoimpl;
import conference.handle.service.MeetsService;

/**
 * Servlet implementation class AllUserServlet
 */
@WebServlet("/AllUserServlet")
public class AllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AttendeesDao dao=new AttendeesDaoimpl();
		OrganizerDao dao1=new OrganizerDaoimpl();
		MeetsDao dao2=new MeetsDaoimpl();
		
		List<Attendees> list_a = dao.findAll();
		List<Organizer> list_o = dao1.findAll();
		List<Meets> list_m = dao2.findAll();
		
		request.getSession().setAttribute("list_a", list_a);
		request.getSession().setAttribute("list_o", list_o);
		request.getSession().setAttribute("list_m", list_m);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
