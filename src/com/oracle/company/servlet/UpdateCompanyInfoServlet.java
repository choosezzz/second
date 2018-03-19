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
 * Servlet implementation class UpdateCompanyInfoServlet
 */
@WebServlet("/files/updateCompanyInfo.do")
public class UpdateCompanyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCompanyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//System.out.println(request.getParameter("currentPage"));
		//��ѯ����ǰҪ�޸ĵ���Ϣ
		Integer id=Integer.valueOf(request.getParameter("companyId"));
		CompanyDao dao=ServiceFactory.getObject(CompanyDaoImpl.class);
		Company c=dao.getById(id);
		if(c!=null){
			request.setAttribute("company", c);
			request.setAttribute("currentPage", request.getParameter("currentPage"));
			request.getRequestDispatcher("updateCompanyInfo.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�����ַ���
		request.setCharacterEncoding("utf-8");
		//�����ն���
		Company c=new Company();
		//����ȡ����
		Conversion.convert(c, request);
		//System.out.println(c);
		CompanyDao dao=ServiceFactory.getObject(CompanyDaoImpl.class);
		//����ҵ���߼�
		dao.update(c);
		//�ض�����ʾָ��
		//System.out.println("--------------"+request.getParameter("currentPage"));
		response.sendRedirect("companyList.do?currentPage="+request.getParameter("currentPage"));
	
	}

}
