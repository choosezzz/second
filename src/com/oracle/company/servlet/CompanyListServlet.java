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
 * Servlet implementation class CompanyListServlet
 */
@WebServlet("/files/companyList.do")
public class CompanyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		//1.�������󣬻�ȡ����
		PageInfo info=new PageInfo(request);
		//����ÿҳ��ʾ������
		info.setPageSize(7);
		//2.����ҵ���߼�
		CompanyDao dao=ServiceFactory.getObject(CompanyDaoImpl.class);
		dao.getByPage(info);
		request.setAttribute("info", info);
		//3.ת������
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
