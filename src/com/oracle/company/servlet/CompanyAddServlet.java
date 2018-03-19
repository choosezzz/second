package com.oracle.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.companyDao.CompanyDao;
import com.oracle.companyDao.CompanyDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.tools.Conversion;
import com.oracle.vo.Company;

/**
 * Servlet implementation class CompanyAddServlet
 */
@WebServlet("/files/companyAdd.do")
public class CompanyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//1.接收请求，获得参数
		Company c=new Company();
//		c.setCompanyName(request.getParameter("companyName"));
//		c.setLinkMan(request.getParameter("linkMan"));
//		c.setAddress(request.getParameter("address"));
//		c.setTel(request.getParameter("tel"));
//		c.setDescript(request.getParameter("descript"));
		Conversion.convert(c, request);
		//2.调用业务逻辑
		CompanyDao dao=ServiceFactory.getObject(CompanyDaoImpl.class);
		dao.save(c);
		//重定向到显示页面的最后一页
		//System.out.println(request.getParameter("currentPage"));
		response.sendRedirect("companyList.do?currentPage="+request.getParameter("currentPage"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
