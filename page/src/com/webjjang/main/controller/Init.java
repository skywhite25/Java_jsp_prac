package com.webjjang.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.service.BoardListService;

//import com.webjjang.board.dao.BoardDAO;
//import com.webjjang.board.service.BoardListService;

/**
 * Servlet implementation class init
 */
@WebServlet(value = "/init", loadOnStartup = 1)
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("jspProject2에서의 실행------------------>>");
		System.out.println("서버가 실행을 시작할 때 실행되는 처리-----------------------");

		// 게시판 객체를 생성 후 저장==============================================================
		// dao 생성 저장
		Beans.putDAO("boardDAO", new BoardDAO());
		
		// service 생성 저장
		Beans.put("/board/list.jsp", new BoardListService());
		
		// service에 dao 넣기 - 조립
		Beans.get("/board/list.jsp").setDAO(Beans.getDAO("boardDAO"));
	
		// 생성 저장이 잘 되었는지 확인
		System.out.println(Beans.get("/board/list.jsp"));
		System.out.println(Beans.getDAO("boardDAO"));

		
	
		
		// 오라클 드라이버와 필요한 메소드 로딩
		try {
			// class 안에있는 static 부분이 로딩되고 static 초기화블록이 실행된다.
			Class.forName("com.webjjang.util.db.DBInfo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("드라이버 확인하는 처리 중 오류 발생");
		}
	}

}
