package com.oracle.message.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.messageDao.MessageDaoImpl;
import com.oracle.tools.PageInfo;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class DetailedMassageServlet
 */
@WebServlet("/files/detailedReceiveMessage.do")
public class DetailedReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailedReceiveMessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String rId=request.getParameter("receiveId");
		Integer receiveId=null;
		if(rId!=null){
			receiveId = Integer.valueOf(rId);
		}
		PageInfo info = new PageInfo(request);
		Integer empId = ((Emp) request.getSession().getAttribute("emp")).getEmpId();
		// 调用业务逻辑
		MessageDaoImpl dao = ServiceFactory.getObject(MessageDaoImpl.class);
		dao.viewReceiveMessage(info, empId, receiveId);
		// 转发请求
		request.setAttribute("info", info);
		request.getRequestDispatcher("viewReceiveMessage.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
