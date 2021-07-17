package com.OOTD.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OOTD.util.filter.AuthorityFilter;

/**
 * Servlet implementation class DispatcherServlet
 */
//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// /board/list.do - /board : substring(0, 6(->indexOf("/",1))
		// /qna/list.do - /qna : substring(0, 4(->indexOf("/",1))
		int endIndex = AuthorityFilter.url.indexOf("/", 1);
		String module = "/main";
		
		if (endIndex >= 0) module = AuthorityFilter.url.substring(0, endIndex);

		// 모듈에 포함이 안되어 있는 URL의 처리 -> siteMesh에 적용이 안되도록 만들어야 하므로
		if(AuthorityFilter.url.equals("/ajax/checkId.do"))
			module ="/member"; // MemberController가 선택
		
		System.out.println("DispatcherServlet.service().module : " + module);
		
		try {
			
			// 실행할 Controller를 선택
			Controller controller = Beans.getController(module);
			
			if(controller == null) 
			throw new Exception("DispatcherServlet.controller가 null : Error 404 - 요청하신 URL이 존재하지 않습니다.");
			
			
			String jspInfo = controller.execute(request);
			
			
			if(jspInfo.indexOf("redirect:") == 0) {
				
				jspInfo = jspInfo.substring("redirect:".length());
				response.sendRedirect(jspInfo);
		
			} else {
				request.getRequestDispatcher("/WEB-INF/views/" + jspInfo + ".jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("exception", e);
			// forward 시킨 내용의 url은 변경이 되지 않음
			request.getRequestDispatcher("/WEB-INF/views/error/error_page.jsp").forward(request, response);
			
		}
		
		
	}

}
