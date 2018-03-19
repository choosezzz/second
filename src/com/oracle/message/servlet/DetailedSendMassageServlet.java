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
@WebServlet("/files/detailedSendMessage.do")
public class DetailedSendMassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailedSendMassageServlet() {
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
		String sId=request.getParameter("sendId");
		Integer sendId=null;
		if(sId!=null){
			sendId = Integer.valueOf(sId);
		}
		PageInfo info = new PageInfo(request);
		Integer empId = ((Emp) request.getSession().getAttribute("emp")).getEmpId();
		// 调用业务逻辑
		MessageDaoImpl dao = ServiceFactory.getObject(MessageDaoImpl.class);
		dao.viewSendMessage(info, empId, sendId);
		// 转发请求
		request.setAttribute("info", info);
		request.getRequestDispatcher("viewSendMessage.jsp").forward(request, response);
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
