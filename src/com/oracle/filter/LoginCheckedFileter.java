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

		//����ת��
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		//������������Ӧ�����ַ���
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		//��������ַ
		String uri=req.getRequestURI();
		//�������·��
		String path=req.getContextPath();
//		System.out.println(path);
//		System.out.println(uri);
//		System.out.println("-------"+uri.replaceAll(path, ""));
		//��õ�¼�ı��
		HttpSession session=req.getSession();
		//��¼��ǲ����ڣ���ת����¼����
		if(session.getAttribute("emp")!=null){
			
			//���У������¼����
			chain.doFilter(request, response);
			
			
		}else if(list.contains(uri.replaceAll(path, ""))){
			//������е�uri
			chain.doFilter(request, response);
		}else{
			
			//�˷������ض�����Ե�������·���µ�login.jsp��������������������������ѭ��
			//res.sendRedirect("login.jsp");
			
			
			//�ض��򵽱����̸�Ŀ¼�µ�login.jsp,�÷����ڵ�¼��ʱ��session����֮��
			//���ڽ���ĳЩ����ʱ������ָ����ҳ��Ĵ�λ�ã��ᵼ�µ�¼ҳ�治�Ǹ������������
			//res.sendRedirect(path+"/login.jsp");
			
			res.getWriter().println("<script>window.top.location.href='"+path+"/login.jsp'</script>");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		//��ӷ��е�uri
		list.add("/login.jsp");
		list.add("/empLogin.do");
			
	
	}

}
