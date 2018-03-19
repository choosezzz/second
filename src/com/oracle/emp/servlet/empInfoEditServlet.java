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
			
		//设置字符集
		request.setCharacterEncoding("utf-8");
		Integer empId=Integer.valueOf(request.getParameter("empId"));
		//调用业务逻辑
		Emp emp=ServiceFactory.getObject(EmpDaoImpl.class).getById(empId);
		if(emp!=null){
			//转发请求
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("empInfoEdit.jsp").forward(request, response);
		}else{
			System.err.println("------未查询到数据-------");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//获得参数转换
		Emp e=new Emp();
		Conversion.convert(e, request);
		//调用业务逻辑
		ServiceFactory.getObject(EmpDaoImpl.class).update(e);
		
		//重定向到显示页面
		response.sendRedirect("empInfoList.do");
		
	
	}

}
