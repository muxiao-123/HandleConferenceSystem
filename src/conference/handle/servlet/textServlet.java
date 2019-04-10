package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.Meets;
import conference.handle.service.MeetsService;
import conference.handle.service.impl.MeetsServiceimpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class text
 */
@WebServlet("/text")
public class textServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("来了一个请求");
		String m_id = request.getParameter("mid");
		int meet_id=Integer.parseInt(m_id);
		MeetsService service= new MeetsServiceimpl();
		List<Meets> list = service.findAll(meet_id);
		JSONArray jsonArray = JSONArray.fromObject(list);
		String json = jsonArray.toString();
		System.out.println(json);
		response.sendRedirect("Login.html");
	}

}
