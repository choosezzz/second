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

/**
 * Servlet implementation class DeleteCompanyServlet
 */
@WebServlet("/files/companyDelete.do")
public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//获得数组参数
		String[] str=request.getParameterValues("delid");
		Integer[] ids=new Integer[str.length];
		//将字符串数组转换为Integer数组
		for(int i=0;i<str.length;i++){
			ids[i]=Integer.valueOf(str[i]);
		}
		//调用业务逻辑
		CompanyDao dao=ServiceFactory.getObject(CompanyDaoImpl.class);
		dao.delete(ids);
		//转发
		response.sendRedirect("companyList.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
