package conference.handle.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.Mail;
import conference.handle.bean.Meets;
import conference.handle.service.MeetsService;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.util.SendMailutil;

/**
 * Servlet implementation class YaoQingJiaBingServlet
 */
@WebServlet("/YaoQingJiaBingServlet")
public class YaoQingJiaBingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String meet_i=request.getParameter("meet_id");
		int meet_id=Integer.parseInt(meet_i);
		String send = request.getParameter("sendEmail");
		String sPassword = request.getParameter("sendPassword");
		String reciv = request.getParameter("recivEmail");
		String title = request.getParameter("sendtitle");
		String content = request.getParameter("sendContent");
		String str="http://localhost/HandleConferenceSystem/Baoming.jsp";
		MeetsService service =new MeetsServiceimpl();
		Meets meets = service.find(meet_id);
		Mail mail=new Mail();
		mail.setSend(send);
		mail.setsPassword(sPassword);
		mail.setReciv(reciv);
		mail.setTitle(title);
//		mail.setContent(content);
		//新建发送实例
		SendMailutil sm=new SendMailutil();
		Properties prop = sm.get();
		String html = sm.get1(meets);
		mail.setContent(html);
		Session session = Session.getInstance(prop);
		MimeMessage message;
		try {
			message = sm.createSimpleMail(session, mail);
			boolean isSuccess = sm.Send(prop, mail, message,session);
			if(isSuccess) {
				System.out.println("发送成功");
				String msg="邮件发送成功";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("YQJB.jsp").forward(request, response);
			}else {
				System.out.println("发送失败");
				String msg1="邮件发送失败";
				request.setAttribute("msg1", msg1);
				request.getRequestDispatcher("YQJB.jsp").forward(request, response);
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
