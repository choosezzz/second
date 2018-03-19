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
 * Servlet implementation class ViewAllSendMessageServlet
 */
@WebServlet("/files/listSendMessage.do")
public class ListSendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��ȡ����
		PageInfo info=new PageInfo(request);
		Integer id=(((Emp)request.getSession().getAttribute("emp")).getEmpId());
		//����ÿҳ��ʾ��¼����
		info.setPageSize(10);
		//����ҵ���߼�
		ServiceFactory.getObject(MessageDaoImpl.class).listSendMessage(info,id );
		request.setAttribute("info", info);
		//ת��
		request.getRequestDispatcher("listSendMessage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
