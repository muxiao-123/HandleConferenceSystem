package conference.handle.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.BaoMing;
import conference.handle.bean.Meets;
import conference.handle.service.BaoMingService;
import conference.handle.service.MeetsService;
import conference.handle.service.impl.BaoMingServiceimpl;
import conference.handle.service.impl.MeetsServiceimpl;

/**
 * Servlet implementation class ChakanHuiYiServlet
 */
@WebServlet("/ChakanHuiYiServlet")
public class ChakanHuiYiServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String ad = request.getParameter("aid");
		int aid=Integer.parseInt(ad);
		BaoMingService service=new BaoMingServiceimpl();
		String sql="select * from baoming where aid=?";
		List<BaoMing> list = service.findAll(sql,aid);
		int meet_id=0;
		List<Meets> list1 =new ArrayList<>();//外面定义可能出错，但可以取值
		for(Iterator iter=list.iterator();iter.hasNext();) {
			//在里面定义不会出错，但去不了值
			meet_id =(int)iter.next();
			MeetsService service1=new MeetsServiceimpl();//输出所有会议list2集合
			Meets meet1 = service1.find(meet_id);
			list1.add(meet1);
		}
		request.getSession().setAttribute("list4", list1);
		//session存太多值会不会造成内存溢出?
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("Myconference.jsp");//重定项到我的会议
//		MeetsService service1=new MeetsServiceimpl();
//		service1.findAll(meet_id);
	}

}
