package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Message;
import conference.handle.bean.Organizer;
import conference.handle.service.MessageService;
import conference.handle.service.impl.MessageServiceimpl;

/**
 * Servlet implementation class ChaKanMessageServlet
 */
@WebServlet("/ChaKanMessageServlet")
public class ChaKanMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		Organizer org = (Organizer) session.getAttribute("org");
		int oid=org.getOid();
		MessageService service=new MessageServiceimpl();
		String sql="select * from message where oid=?";
		List<Message> list = service.findAll(sql, oid);
		request.getSession().setAttribute("message_list", list);
		//ajax求请到得到
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("xiaoxi.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
