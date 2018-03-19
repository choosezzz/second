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
 * Servlet implementation class DeleteSendMessageServlet
 */
@WebServlet("/files/deleteSendMessage.do")
public class DeleteSendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//通过get方法，根据id逻辑删除单个消息
		Integer id=Integer.valueOf(request.getParameter("sendId"));
		//调用业务逻辑
		ServiceFactory.getObject(MessageDaoImpl.class).deleteSendMessageById(id);
		//转发请求
		response.sendRedirect("listSendMessage.do");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//通过post请求批量删除
		String[] str=request.getParameterValues("sendId");
		if(str!=null){
			Integer[] ids=new Integer[str.length];
			for(int i=0;i<str.length;i++){
				ids[i]=Integer.valueOf(str[i]);
			}
			//调用业务逻辑
			ServiceFactory.getObject(MessageDaoImpl.class).batchDeleteSendMessage(ids);
		}
		response.sendRedirect("listSendMessage.do");
	
	}

}
