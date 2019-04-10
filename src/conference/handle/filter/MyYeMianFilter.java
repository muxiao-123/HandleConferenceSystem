package conference.handle.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conference.handle.bean.Admin;

/**
 * Servlet Filter implementation class MyYeMianFilter
 */
@WebFilter("/MyYeMianFilter")
public class MyYeMianFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyYeMianFilter() {
        // TODO Auto-generated constructor stub
    }

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
		
		 HttpServletRequest request =(HttpServletRequest) req;
		 HttpServletResponse response=(HttpServletResponse) res;
//		 Object att = request.getSession().getAttribute("att");
		 Object org = request.getSession().getAttribute("org");
		
		 if(org!=null) {
			 System.out.println("来了一个过滤：放行了");
			 chain.doFilter(request, response);
		 }else {
		 System.out.println("来了一个过滤：但是还没放行");
		 System.out.println("您还没登陆管理不能访问该页面");
//		 response.sendRedirect("../Login.html");
		 response.setContentType("text/html;charset=UTF-8");
		 response.getWriter().write("您还没登陆，请重新打开主页网址刷新<a href='http://localhost:8080/HandleConferenceSystem/'>dasds</a>");
			 
		 }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
