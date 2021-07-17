package com.webjjang.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class Init
 */
@WebServlet(value = "/Init", loadOnStartup = 1)
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
		System.out.println("project0223에서의 실행--------->>>");
		System.out.println("서버가 실행을 시작할때 실행되는 처리-----");
		
		// Board1 객체를 생성 후 저장 -------------
		// dao 생성 저장
		Beans.putDAO("board1DAO", new com.webjjang.board1.dao.BoardDAO1());
		
		// service 생성 저장
		Beans.put("/board1/list.jsp", new com.webjjang.board1.service.BoardListService());
		Beans.put("/board1/write.jsp", new com.webjjang.board1.service.BoardWriteService());
		
		// service에 dao 넣기 - 조립
		Beans.get("/board1/list.jsp").setDAO(Beans.getDAO("board1DAO"));
		Beans.get("/board1/write.jsp").setDAO(Beans.getDAO("board1DAO"));
		
		// Board2 객체를 생성 후 저장 -------------
		// dao 생성 저장
		Beans.putDAO("board2DAO", new com.webjjang.board2.dao.BoardDAO());
		
		// service 생성 저장
		Beans.put("/board2/list.jsp", new com.webjjang.board2.service.BoardListService());
		Beans.put("/board2/write.jsp", new com.webjjang.board2.service.BoardWriteService());
		
		// service에 dao 넣기 - 조립
		Beans.get("/board2/list.jsp").setDAO(Beans.getDAO("board2DAO"));
		Beans.get("/board2/write.jsp").setDAO(Beans.getDAO("board2DAO"));
		
		// Board3 객체를 생성 후 저장 -------------
		// dao 생성 저장
		Beans.putDAO("board3DAO", new com.webjjang.board3.dao.BoardDAO());
		
		// service 생성 저장
		Beans.put("/board3/list.jsp", new com.webjjang.board3.service.BoardListService());
		Beans.put("/board3/write.jsp", new com.webjjang.board3.service.BoardWriteService());
		
		// service에 dao 넣기 - 조립
		Beans.get("/board3/list.jsp").setDAO(Beans.getDAO("board3DAO"));
		Beans.get("/board3/write.jsp").setDAO(Beans.getDAO("board3DAO"));
		
		// 생성 저장이 잘되어 있는지 확인
		System.out.println(Beans.get("/board1/list.jsp"));
		System.out.println(Beans.getDAO("board1DAO"));
		
		// 오라클 드라이버와 필요한 메서드 로딩
		try {
			// class 안에 있는 static 부분이 로딩 되고 static{} 초기화 블록이 실행됨.
			Class.forName("com.webjjang.util.db.DBInfo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("드라이버 확인하는 처리 중 오류 발생");
		}
	}

}
