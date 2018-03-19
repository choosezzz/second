package com.oracle.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheckedFileter
 */
@WebFilter({ "*.html", "*.jsp", "*.do" })
public class LoginCheckedFileter implements Filter {
	
	List<String>  list=new ArrayList<>();
 
    /**
     * Default constructor. 
     */
    public LoginCheckedFileter() {
        // TODO Auto-generated constructor stub0
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//类型转换
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		//对所有请求响应设置字符集
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		//获得请求地址
		String uri=req.getRequestURI();
		//获得请求路径
		String path=req.getContextPath();
//		System.out.println(path);
//		System.out.println(uri);
//		System.out.println("-------"+uri.replaceAll(path, ""));
		//获得登录的标记
		HttpSession session=req.getSession();
		//登录标记不存在，跳转到登录界面
		if(session.getAttribute("emp")!=null){
			
			//放行，满足登录条件
			chain.doFilter(request, response);
			
			
		}else if(list.contains(uri.replaceAll(path, ""))){
			//满足放行的uri
			chain.doFilter(request, response);
		}else{
			
			//此方法会重定向到相对当此请求路径下的login.jsp，不满足放行条件，会进入无限循环
			//res.sendRedirect("login.jsp");
			
			
			//重定向到本工程根目录下的login.jsp,该方法在登录超时（session过期之后）
			//，在进行某些操作时，由于指定了页面的打开位置，会导致登录页面不是覆盖整个浏览器
			//res.sendRedirect(path+"/login.jsp");
			
			res.getWriter().println("<script>window.top.location.href='"+path+"/login.jsp'</script>");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		//添加放行的uri
		list.add("/login.jsp");
		list.add("/empLogin.do");
			
	
	}

}
