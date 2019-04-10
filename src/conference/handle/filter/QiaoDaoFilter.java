package conference.handle.filter;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.Meets;
import conference.handle.bean.Organizer;
import conference.handle.dao.OrganizerDao;
import conference.handle.dao.impl.OrganizerDaoimpl;
import conference.handle.service.MeetsService;
import conference.handle.service.impl.MeetsServiceimpl;
import conference.handle.util.DataFormatUtil;
import conference.handle.util.JSutil;

/**
 * Servlet Filter implementation class QiaoDaoFilter
 */
@WebFilter("/QiaoDaoFilter")
public class QiaoDaoFilter implements Filter {


	

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		 HttpServletRequest request=(HttpServletRequest) req;
		 HttpServletResponse response=(HttpServletResponse) res;
		 //从全局参数获取二维码刷新时间
         //request.getServletContext().setAttribute("time", "ewew");
//		    传入meet_tilte,确保能找到该会议组织者发布的签到时间
          //String meet_title = request.getParameter("meet_title");
          //MeetsService service=new MeetsServiceimpl();
          //Meets meets = service.find(meet_title);
          //int oid = meets.getOid();
          //OrganizerDao dao=new OrganizerDaoimpl();
          //Organizer organizer = dao.find(oid);
          //int o_id = organizer.getOid();
         // String start1=String.valueOf(o_id);
	      String start = (String) request.getServletContext().getAttribute("start");
		//获取二维码生成时间
//		 String start="2019-3-21 13:18:00";
		//Date timestamp = DataFormatUtil.transform1(start);
		//测试时间对比
		//扫码的时间
		Date date=new Date();
		String end="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		end=sdf.format(date);
		int mCha = JSutil.JiSuan(start, end);
		
		if(mCha<3) {
			//证明没超过三分钟
			//可放行到签到页面
			chain.doFilter(request, response);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("对不起，您的二维码已过期，请重新扫码签到");
		}
		
		//获取各个项比较
		//签到时间
		//int date2 = timestamp.getDate();
		//int hours = timestamp.getHours();
		//int minutes = timestamp.getMinutes();
		//二维码时间
		//int date3 = date.getDate();
		//int hours2 = date.getHours();
		//int minutes2 = date.getMinutes();
		//在这天签到了
		//if(date2==date3) {
			//if(hours==hours2) {
				//表示签到时间和二维码刷新时间在三分钟内
				//if((Math.abs(minutes-minutes2)+3)%3==0) {}
			//}
		//}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
