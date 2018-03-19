package com.oracle.message.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.messageDao.MessageDaoImpl;

/**
 * Servlet implementation class DeleteReceiveMessageServlet
 */
@WebServlet("/files/deleteReceiveMessage.do")
public class DeleteReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReceiveMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//通过get方法，根据id逻辑删除单个消息
		Integer id=Integer.valueOf(request.getParameter("receiveId"));
		//调用业务逻辑
		ServiceFactory.getObject(MessageDaoImpl.class).deleteReceiveMessageById(id);;
		//转发请求
		response.sendRedirect("listReceiveMessage.do");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//通过post请求批量删除
		String[] str=request.getParameterValues("receiveId");
		if(str!=null){
			Integer[] ids=new Integer[str.length];
			for(int i=0;i<str.length;i++){
				ids[i]=Integer.valueOf(str[i]);
			}
			//调用业务逻辑
			ServiceFactory.getObject(MessageDaoImpl.class).batchDeleteReceiveMessage(ids);;
		}
		response.sendRedirect("listReceiveMessage.do");
	
	}
}
