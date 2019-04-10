package conference.handle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.handle.bean.Meets;
import conference.handle.service.MeetsService;
import conference.handle.service.impl.MeetsServiceimpl;



	
/**
 * Servlet implementation class XiangQingServlet
 * 详情界面
 */
@WebServlet("/XiangQingServlet")
public class XiangQingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("来了一个请求");
		String mid = request.getParameter("meet_id");
		int meet_id=Integer.parseInt(mid);
		String youke = request.getParameter("youke");
		System.out.println("来的值为"+meet_id);
		 MeetsService service= new MeetsServiceimpl();
		    
		 Meets meets = service.find(meet_id);
        request.getSession().setAttribute("meet3", meets);;
		   //request.getSession("meet3",meets);
		   // request.setAttribute("meet3", meets);
			response.setContentType("text/html;charset=UTF-8");
			
			if (youke.equals("youke")) {
				response.sendRedirect("huiyixiangY.jsp");
			}else {
				response.sendRedirect("huiyixiang.jsp");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		System.out.println("来了一个请求");
//		String mid = request.getParameter("meet_id");
//		int meet_id=Integer.parseInt(mid);
//		String youke = request.getParameter("youke");
//		System.out.println("来的值为"+meet_id);
//		String meet_title = request.getParameter("meet_title");
//		String meet_points = request.getParameter("meet_points");
//		String meetInfo = request.getParameter("meetInfo");
//		String address = request.getParameter("address");
//		
//		String sDate = request.getParameter("startDate");
//		String eDate = request.getParameter("endDate");
//		Timestamp startDate  =DataFormatUtil.transform1(sDate);
//		Timestamp endDate  =DataFormatUtil.transform1(eDate);
		
//		String toastMaster = request.getParameter("toastMaster");
		//String sponsor = request.getParameter("sponsor");主办法
		
//		    Meets meet2=new Meets();
//		    meet2.setMeet_id(meet_id);
//		    meet2.setMeet_title(meet_title);
//			meet2.setMeet_points(meet_points);
//			//meet2.setNumber(number);
//			meet2.setStartDate(startDate);
//			meet2.setEndDate(endDate);
//			meet2.setToastMaster(toastMaster);
//			meet2.setAddress(address);
//			//meet.setAddress(address);
//			
//			meet2.setMeetInfo(meetInfo);
//			
//			//meet2.setSponsor(sponsor);
//			//meet2.setOid(oid);
		        
		    
//		    MeetsService service= new MeetsServiceimpl();
//		    
//		    Meets meets = service.find(meet_id);
//           request.getSession().setAttribute("meet3", meets);;
		   //request.getSession("meet3",meets);
		   // request.setAttribute("meet3", meets);
//			response.setContentType("text/html;charset=UTF-8");
			
//			if (youke.equals("youke")) {
//				response.sendRedirect("huiyixiangY.jsp");
//			}else {
//				response.sendRedirect("huiyixiang.jsp");
//			}
			
			
		
	}

}

	

