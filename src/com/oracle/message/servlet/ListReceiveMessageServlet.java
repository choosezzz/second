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
 * Servlet implementation class ViewAllMassageServlet
 */
@WebServlet("/files/listReceiveMessage.do")
public class ListReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReceiveMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��ȡ����
		request.setCharacterEncoding("utf-8");
		PageInfo info=new PageInfo(request);
		//����ÿҳ��ʾ�ļ�¼����
		info.setPageSize(10);
		//����ҵ���߼�
		Integer id=Integer.valueOf(((Emp)request.getSession().getAttribute("emp")).getEmpId());
		ServiceFactory.getObject(MessageDaoImpl.class).viewMassage(id,info);
		//ת������
		request.setAttribute("info", info);
		request.getRequestDispatcher("listReceiveMessage.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
