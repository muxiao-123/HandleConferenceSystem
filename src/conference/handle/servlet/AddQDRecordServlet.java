package conference.handle.servlet;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.BaoMing;
import conference.handle.bean.Meets;
import conference.handle.bean.Qd_item;
import conference.handle.dao.AttendeesDao;
import conference.handle.dao.impl.AttendeesDaoimpl;
import conference.handle.service.BaoMingService;
import conference.handle.service.MeetsService;
import conference.handle.service.Qd_itemService;
import conference.handle.service.impl.BaoMingServiceimpl;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.service.impl.Qd_itemServiceimpl;
/**
 * Servlet implementation class AddQDRecordServlet
 */
@WebServlet("/AddQDRecordServlet")
public class AddQDRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		String meet_title = request.getParameter("meet_title");
		String a_userName = request.getParameter("a_userName");
		System.out.println("来了一条请求");
		//生成当前时间戳
		Timestamp qd_time=new Timestamp(System.currentTimeMillis());
		MeetsService service2=new MeetsServiceimpl();
		//找到会议结束时间
		Meets meets = service2.find(meet_title);
		int meet_id = meets.getMeet_id();
		Timestamp endDate = meets.getEndDate();
		//比较时间，看是否满足田间
		if(qd_time.before(endDate)) {
			System.out.println("可以签到");
			//找到aid
			AttendeesDao dao=new AttendeesDaoimpl();
			//拍段是否注册用户
			int aid = dao.find(a_userName);
			if(aid!=0) {
				//拍段是否报名
				BaoMingService service1=new BaoMingServiceimpl();
				String sql="select * from baoming where aid=? and meet_id=?";
				List<BaoMing> list = service1.findAll(sql, aid, meet_id);
				if(list.size()>0) {
					//满足条件添加到签到项
					Qd_item qd=new Qd_item(); 
					qd.setMeet_title(meet_title);
					qd.setA_userName(a_userName);
					qd.setQd_time(qd_time);
					Qd_itemService service =new Qd_itemServiceimpl();
					boolean isSuccess = service.insert(qd);
					response.setContentType("text/html;charset=UTF-8");
						if(isSuccess) {
							System.out.println("签到成功");
							response.sendRedirect("index.jsp");
						}else {
							System.out.println("fail");
							//返回错误信息
							response.getWriter().write("qiandaoshibai");
							response.sendRedirect("index.jsp");
						}
				}else {
	                response.setContentType("text/html;charset=UTF-8");
	                response.getWriter().write("duibuqi,nihabushiishizhuceyonghu");
	                response.sendRedirect("index.jsp");
			    }
			}else {
				System.out.println("您不能签到了，会议已经开始了");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write("duibuqi,nihabushiishizhuceyonghu");
//				 response.sendRedirect("index.jsp");
		     }
		}
	}
}
