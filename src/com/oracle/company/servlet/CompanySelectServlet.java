package com.oracle.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.companyDao.CompanyDao;
import com.oracle.companyDao.CompanyDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.tools.PageInfo;

/**
 * Servlet implementation class CompanySelectServlet
 */
@WebServlet("/files/companySelect.do")
public class CompanySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanySelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//设置字符集
		request.setCharacterEncoding("utf-8");
		//获得请求参数
		String name=request.getParameter("companyName");
		HttpSession session=request.getSession();
		if(name!=null){
			//第一次查询时，记录查询条件
			session.setAttribute("sel_company_name", name);
		}
		
		name=(String) session.getAttribute("sel_company_name");
		//获得页数信息
		PageInfo info=new PageInfo(request);
		info.setPageSize(7);
		//调用业务逻辑
		CompanyDao dao=ServiceFactory.getObject(CompanyDaoImpl.class);
		dao.selectBycompanyName(info, name);
		//设置属性
		request.setAttribute("info", info);
		//转发请求
		request.getRequestDispatcher("companyList.jsp").forward(request, response);
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
