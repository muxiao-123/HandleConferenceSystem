package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.service.Message_itemService;
import conference.handle.service.impl.Message_itemServiceimpl;

/**
 * Servlet implementation class DeleteAMessageSevlet
 * 删除与会者收到的消息
 */
@WebServlet("/DeleteAMessageSevlet")
public class DeleteAMessageSevlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        request.setCharacterEncoding("UTF-8");
		String a_id = request.getParameter("aid");
		int aid=Integer.parseInt(a_id);
		Message_itemService service=new Message_itemServiceimpl();
		String sql="delete from message_item where aid=?";
		boolean isSuccess = service.delete(sql,aid);
		if(isSuccess) {
			System.out.println("deleteok");
			response.setContentType("text/html;charset=UTF-8");
			//可用ajax实时刷新
			response.sendRedirect("index1.jsp");
		}else {
			System.out.println("delete ... fail");
			response.sendRedirect("");
		}
	}

}
