package conference.handle.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Attendees;
import conference.handle.bean.Message;
import conference.handle.bean.Message_item;
import conference.handle.service.MessageService;
import conference.handle.service.Message_itemService;
import conference.handle.service.impl.MessageServiceimpl;
import conference.handle.service.impl.Message_itemServiceimpl;

/**
 * Servlet implementation class JieMessageServlet
 * 与会人员接受消息
 */
@WebServlet("/JieMessageServlet")
public class JieMessageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		Attendees att = (Attendees) session.getAttribute("att");
		System.out.println("来了一个请求"+att);
		 int aid = att.getAid();
		//String a_id = request.getParameter("aid");
		//int aid1=Integer.parseInt(a_id);
		Message_itemService service=new Message_itemServiceimpl();
		String sql="select * from message_item where aid=?";
		List<Message> list=new ArrayList<>();
		//循环得到message,在通过message便利梳理message
		for (Message_item message_item : service.findAll(sql, aid)) {
			int message_id = message_item.getMessage_id();
			MessageService service1=new MessageServiceimpl();
			String sql1="select * from message where message_id=?";
		   List<Message> list2 = service1.findAll(sql1, message_id);
		    //得到用户的总消息数
		   Message message = list2.get(0);
		   list.add(message);
		}
		//得到消息数存到session中,页面输出，重定向到收件箱
		request.getSession().setAttribute("list_a_message",list );
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("messageManage.jsp");
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
				
	}

}
