package com.oracle.emp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.empDao.EmpDao;
import com.oracle.empDao.EmpDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.tools.PageInfo;

/**
 * Servlet implementation class EmpInfoListServlet
 */
@WebServlet("/files/empInfoList.do")
public class EmpInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1���������󣬴�����ҳ��Ϣ
		PageInfo info=new PageInfo(request);
		//����ÿҳ��Ϣ
		info.setPageSize(8);
		//2������ҵ���߼�
		EmpDao dao=ServiceFactory.getObject(EmpDaoImpl.class);
		dao.getAll(info);
		//�����ָ���쳣
		if(info.getList()!=null){
			request.setAttribute("info", info);
			//3,ת������
			request.getRequestDispatcher("empInfoList.jsp").forward(request, response);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
