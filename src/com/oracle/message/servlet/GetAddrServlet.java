package com.oracle.message.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.empDao.EmpDaoImpl;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class GetAddrServlet
 */
@WebServlet("/files/getAddr.do")
public class GetAddrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAddrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		List<Emp> list=ServiceFactory.getObject(EmpDaoImpl.class).getAll();
		if(list!=null){
			//移除当前帐号的信息
			list.remove((Emp)request.getSession().getAttribute("emp"));
			 ObjectMapper mapper = new ObjectMapper(); 
			 String json=mapper.writeValueAsString(list);
			 response.setContentType("text/plain;charset=utf-8");
			 response.getWriter().append(json);
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
