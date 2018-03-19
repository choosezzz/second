package com.oracle.emp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.empDao.EmpDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.tools.Conversion;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class empInfoEdit
 */
@WebServlet("/files/empInfoEdit.do")
public class empInfoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empInfoEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		Integer empId=Integer.valueOf(request.getParameter("empId"));
		//����ҵ���߼�
		Emp emp=ServiceFactory.getObject(EmpDaoImpl.class).getById(empId);
		if(emp!=null){
			//ת������
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("empInfoEdit.jsp").forward(request, response);
		}else{
			System.err.println("------δ��ѯ������-------");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//��ò���ת��
		Emp e=new Emp();
		Conversion.convert(e, request);
		//����ҵ���߼�
		ServiceFactory.getObject(EmpDaoImpl.class).update(e);
		
		//�ض�����ʾҳ��
		response.sendRedirect("empInfoList.do");
		
	
	}

}
