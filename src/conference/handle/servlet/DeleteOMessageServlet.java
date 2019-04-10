package conference.handle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.service.MessageService;
import conference.handle.service.Message_itemService;
import conference.handle.service.impl.MessageServiceimpl;
import conference.handle.service.impl.Message_itemServiceimpl;

/**
 * Servlet implementation class DeleteOMessageServlet
 * 删除发送的消息
 */
@WebServlet("/DeleteOMessageServlet")
public class DeleteOMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//得到消息id
		String message = request.getParameter("message_id");
		int message_id=Integer.parseInt("message");
		//先删mesage_item,再删message
		Message_itemService service= new Message_itemServiceimpl();
		String sql="delete from meaasge_item where meaasge_id=?";
		 service.delete(sql, message_id);
		 //再删message
		 MessageService service1= new MessageServiceimpl();
		 String sql1="delete from message where message_id=?";
		 boolean isSuccess = service1.delete(sql1, message_id);
		
		if(isSuccess) {
			System.out.println("删除陈工");
			//可用ajax实时删除
			response.sendRedirect("index1.jsp");
		}else {
			System.out.println("删除失败");
			response.sendRedirect("xiaoxi.jsp");
		          }	
		}

}
