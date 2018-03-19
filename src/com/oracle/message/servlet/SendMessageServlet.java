package com.oracle.message.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.messageDao.MessageDaoImpl;
import com.oracle.tools.Conversion;
import com.oracle.vo.Emp;
import com.oracle.vo.SendMessage;

/**
 * Servlet implementation class SendMassageServlet
 */
@WebServlet("/files/sendMessage.do")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		//��ȡȫ������
		SendMessage message=new SendMessage();
		Conversion.convert(message, request);
		Emp emp=(Emp) request.getSession().getAttribute("emp");
		//��ȡ����Ϣ�ŵ�id
		Integer id=Integer.valueOf(emp.getEmpId());
		//���÷�����id 
		message.setEmpId(id);
		//����ҵ���߼�
		ServiceFactory.getObject(MessageDaoImpl.class).sendMassage(message);
		
		//��ת
		response.sendRedirect("listSendMessage.do");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
