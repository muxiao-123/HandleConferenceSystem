package conference.handle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.dao.AttendeesDao;
import conference.handle.dao.OrganizerDao;
import conference.handle.dao.impl.AttendeesDaoimpl;
import conference.handle.dao.impl.OrganizerDaoimpl;

/**
 * Servlet implementation class DeleteOUserServlet
 */
@WebServlet("/DeleteOUserServlet")
public class DeleteOUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String o_id = request.getParameter("oid");
		String a_id = request.getParameter("aid");
		if(o_id!=null) {
			int oid=Integer.parseInt(o_id);
			OrganizerDao dao=new OrganizerDaoimpl();
			boolean isSuccess = dao.delete(oid);
			if(isSuccess) {
		          response.setContentType("text/html;charset=UTF-8");
		          response.sendRedirect("wsnd");
			}else {
				 String msg="出现错误，请重新尝试";
				 request.setAttribute("oid", oid);
				 request.setAttribute("msg", msg);
				 request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
		}else if(a_id!=null) {
			int aid=Integer.parseInt(a_id);
			AttendeesDao dao1=new AttendeesDaoimpl();
			boolean isSuccess1 = dao1.delete(aid);
			if(isSuccess1) {
				 response.setContentType("text/html;charset=UTF-8");
		         response.sendRedirect("wsnd");
			}else {
				 String msg1="出现错误，请重新尝试";
				 request.setAttribute("aid", aid);
				 request.setAttribute("msg1", msg1);
				 request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
