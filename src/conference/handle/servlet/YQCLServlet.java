package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.Meets;
import conference.handle.service.MeetsService;
import conference.handle.service.impl.MeetsServiceimpl;

/**
 * Servlet implementation class YQCLServlet
 */
@WebServlet("/YQCLServlet")
public class YQCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String meet_i = request.getParameter("meet_id");
		int meet_id=Integer.parseInt(meet_i);
		MeetsService service=new MeetsServiceimpl();
		Meets meets = service.find(meet_id);
		request.setAttribute("meets", meets);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("YQJB.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
