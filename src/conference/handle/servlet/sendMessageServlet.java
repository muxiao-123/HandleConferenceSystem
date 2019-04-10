package conference.handle.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.BaoMing;
import conference.handle.bean.Message;
import conference.handle.bean.Organizer;
import conference.handle.service.BaoMingService;
import conference.handle.service.MeetsService;
import conference.handle.service.MessageService;
import conference.handle.service.Message_itemService;
import conference.handle.service.impl.BaoMingServiceimpl;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.service.impl.MessageServiceimpl;
import conference.handle.service.impl.Message_itemServiceimpl;
/**
 * Servlet implementation class sendMessageServlet
 * 发送消息就是新建消息之后ajax实时返回结果
 */
@WebServlet("/sendMessageServlet")
public class sendMessageServlet extends HttpServlet {
	

	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String meetTitle = request.getParameter("meetTitle");
		String messageContent = request.getParameter("messageContent");
		
		//获得当前时间戳
		Timestamp sendTime = new Timestamp(System.currentTimeMillis());
		//从会话中得到发送者,及id
		HttpSession session = request.getSession();
		Organizer org = (Organizer) session.getAttribute("org");
		String sender=org.getO_userName();
		int oid=org.getOid();
		//String sender = request.getParameter("sender");
		//String o_id = request.getParameter("oid");
		//int oid=Integer.parseInt(o_id);
		//得到会议id通过oid和meet_title
		MeetsService service1=new MeetsServiceimpl();
		int meet_id = service1.find(meetTitle, oid);
		
		//String mid = request.getParameter("meet_id");
		//int me_id=Integer.parseInt(mid);
		//住哪工程对相
		
		Message mess=new Message();
		mess.setMeetTitle(meetTitle);
		mess.setMessageContent(messageContent);
		mess.setSendTime(sendTime);
		mess.setSender(sender);
		mess.setOid(oid);
		mess.setMeet_id(meet_id);
		
		MessageService service=new MessageServiceimpl();
		boolean isSuccess = service.insert(mess);
		if(isSuccess) {
			//获取添加的信息,先获取id
			MessageService service2=new MessageServiceimpl();
			int message_id = service2.find(oid, meet_id);
			if(message_id !=0) {
				//再获取aid
				BaoMingService service3= new BaoMingServiceimpl();
//				String sql1="select * from baoming where meet_id=?";
				List<BaoMing> list3 = service3.findAll(meet_id);
				//储存与会id
				//最多参会人数30
				List<String> list1=new ArrayList<>();
				for(int i=0;i<list3.size();i++) {
					BaoMing baoMing = list3.get(i);
					Message_itemService service4=new Message_itemServiceimpl();
					service4.insert(message_id, baoMing.getAid());
				}
				String data="发送成功";
				request.setAttribute("data", data);
				response.setContentType("text/html;charset=utf-8");
				response.sendRedirect("index1.jsp");;
				
			}else {
				String data="发送失败";
			}
			
//			for(int i=0;i<list.size();i++) {
//				//从list中找到message_id
//				Message message = list.get(i);
//				int message_id = message.getMessage_id();
//				//MeetsService service2=new MeetsServiceimpl();
//				//List<Meets> list2 = service2.findAll(oid);
//				BaoMingService service3= new BaoMingServiceimpl();
//				String sql1="select * from baoming where meet_id=?";
//				List<BaoMing> list3 = service3.findAll(sql1,me_id);
//				for(int j=0;j<list3.size();j++) {
//					//新建的同时插入消息和用户id到消息项中，方便查找。
//					BaoMing bm = list3.get(j);
//					int aid = bm.getAid();
//					Message_itemService service4=new Message_itemServiceimpl();
//					//
//					service4.insert(message_id, aid);
//				}
//			}
			//存会话中，每个变量区分开，已发送消息列表存值
//			request.getSession().setAttribute("Message_list", list);
			//不需要重定向
			
			//response.sendRedirect("xiaoxi.jsp");
		}else {
			String data="发送失败";
			request.setAttribute("data", data);
			response.setContentType("text/html;charset=utf-8");
//			System.out.println("发送失败：请稍后发送");
		}
	}

}
