package conference.handle.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Meets;
import conference.handle.bean.Organizer;
import conference.handle.dao.MeetsDao;
import conference.handle.dao.impl.MeetsDaoimpl;
import conference.handle.util.DataFormatUtil;

/**
 * Servlet implementation class AddMeetServlet
 * 新建会议
 */
@WebServlet("/AddMeetServlet")
public class AddMeetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				//doGet(request, response);
				request.setCharacterEncoding("UTF-8");
				
				
				//String meet_title, String meet_points,int number,
				//Date startDate,Date endDate,String toastMaster,String addresss, 
				//Srting meetInfo,  String sponsor, int oid
				
				String meet_title = request.getParameter("meet_title");
				String meet_points = request.getParameter("meet_points");
				String numb=request.getParameter("number");
				//强壮数字类型
				int number=Integer.parseInt(numb);
				String sDate = request.getParameter("startDate");
				String eDate = request.getParameter("endDate");
				System.out.println("开始="+sDate+"结束="+eDate);
				//转换为日期格式
				//Date startDate = DataFormatUtil.transform1(sDate);
				//Date endDate = DataFormatUtil.transform1(eDate);
				Timestamp startDate  =DataFormatUtil.transform1(sDate);
				Timestamp endDate  =DataFormatUtil.transform1(eDate);
				
				System.out.println("开始="+startDate+"结束="+endDate);
				String toastMaster=request.getParameter("toastMaster");
				String address = request.getParameter("address");
				String meetInfo = request.getParameter("meetInfo");
				String sponsor=request.getParameter("sponsor");
				
				//获取发布人id编号.从会话中
				HttpSession session = request.getSession();
				Organizer org =(Organizer)session.getAttribute("org");
				int oid =org.getOid();
				System.out.println("oid");
				
				Meets meet=new Meets();
				meet.setMeet_title(meet_title);
				meet.setMeet_points(meet_points);
				meet.setNumber(number);
				meet.setStartDate(startDate);
				meet.setEndDate(endDate);
				meet.setToastMaster(toastMaster);
				meet.setAddress(address);
				//meet.setAddress(address);
				meet.setMeetInfo(meetInfo);
				meet.setSponsor(sponsor);
				meet.setOid(oid);
				
				MeetsDao dao=new MeetsDaoimpl();
				boolean isSuccess = dao.insert(meet);
				response.setContentType("text/html;charset=utf-8");
				if(isSuccess) {
					System.out.println("创建成功");
					//此时数据还没有刷新，需要重新登陆网址，才能看到发布的信息
					response.sendRedirect("../AllHuiYiServlet");
				}else {
					System.out.println("创建失败");
					response.sendRedirect("fabuhuiyi.jsp");
				}
	}

}
