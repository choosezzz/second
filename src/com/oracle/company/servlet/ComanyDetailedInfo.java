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
import com.oracle.tools.PageInfo;

/**
 * Servlet implementation class DetailedInfo
 */
@WebServlet("/files/companyDetailedInfo.do")
public class ComanyDetailedInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComanyDetailedInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Integer companyId=Integer.valueOf(request.getParameter("companyId"));
//		CompanyDao dao=ServiceFactory.getObject(CompanyDaoImpl.class);
//		Company c=dao.getById(companyId);
//		if(c!=null){
//			request.setAttribute("company", c);
//			request.getRequestDispatcher("companyDetailedInfo.jsp").forward(request, response);
//		}
		request.setCharacterEncoding("utf-8");
		
		//1.接收请求，获取参数
		PageInfo info=new PageInfo(request);
		Integer id=null;
		String str=request.getParameter("companyId");
		if(str!=null){
			id=Integer.valueOf(str);
		}
		//2.调用业务逻辑
		CompanyDao dao=ServiceFactory.getObject(CompanyDaoImpl.class);
		dao.getOnePageInfo(info, id);
		request.setAttribute("info", info);
		//3.转发请求
		request.getRequestDispatcher("companyDetailedInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
