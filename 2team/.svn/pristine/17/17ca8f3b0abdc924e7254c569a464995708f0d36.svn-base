package com.webjjang.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.webjjang.board2.service.BoardListService;

/**
 * Servlet implementation class init
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
		System.out.println("Project0223에서의 실행------------------------");
		System.out.println("서버가 실행을 시작할 때 실행되는 처리");
		
		/* //board1
		Beans.putDAO("board1DAO", new com.webjjang.board1.dao.BoardDAO());
		Beans.put("/board1/list.jsp", new BoardListService());
		Beans.put("/board1/view.jsp", new BoardViewService());
		Beans.get("/board1/list.jsp").setDAO(Beans.getDAO("boardDAO"));
		Beans.get("/board1/view.jsp").setDAO(Beans.getDAO("boardDAO"));
		 */	
		
		 //board2
		Beans.putDAO("board2DAO", new com.webjjang.board2.dao.BoardDAO());
		Beans.put("/board2/list.jsp", new BoardListService());
		//Beans.put("/board2/view.jsp", new BoardViewService());
		Beans.get("/board2/list.jsp").setDAO(Beans.getDAO("board2DAO"));
		Beans.get("/board2/view.jsp").setDAO(Beans.getDAO("board2DAO"));
		
		
		//board3
		/*Beans.putDAO("board3DAO", new com.webjjang.board3.dao.BoardDAO());
		Beans.put("/board3/list.jsp", new BoardListService());
		Beans.put("/board3/view.jsp", new BoardViewService());
		Beans.get("/board3/list.jsp").setDAO(Beans.getDAO("boardDAO"));
		Beans.get("/board3/view.jsp").setDAO(Beans.getDAO("boardDAO"));
		*/
		
		/* //notice1
		Beans.putDAO("notice1DAO", new com.webjjang.notice3.dao.NoticeDAO());
		Beans.put("/notice1/list.jsp", new com.webjjang.notice.service.NoticeListService());
		Beans.put("/notice1/write.jsp", new com.webjjang.notice.service.NoticeWriteService());
		Beans.get("/notice1/list.jsp").setDAO(Beans.getDAO("noticeDAO"));
		Beans.get("/notice1/write.jsp").setDAO(Beans.getDAO("noticeDAO"));
		*/
		
		/* //notice2
		Beans.putDAO("notice2DAO", new com.webjjang.notice3.dao.NoticeDAO());
		Beans.put("/notice2/list.jsp", new com.webjjang.notice.service.NoticeListService());
		Beans.put("/notice2/write.jsp", new com.webjjang.notice.service.NoticeWriteService());
		Beans.get("/notice2/list.jsp").setDAO(Beans.getDAO("noticeDAO"));
		Beans.get("/notice2/write.jsp").setDAO(Beans.getDAO("noticeDAO"));
		 */
		

		Beans.putDAO("notice3DAO", new com.webjjang.notice3.dao.NoticeDAO());
		Beans.put("/notice3/list.jsp", new com.webjjang.notice3.service.NoticeListService());
		Beans.put("/notice3/write.jsp", new com.webjjang.notice3.service.NoticeWriteService());
		Beans.get("/notice3/list.jsp").setDAO(Beans.getDAO("notice3DAO"));
		Beans.get("/notice3/write.jsp").setDAO(Beans.getDAO("notice3DAO"));
		
		// 생성 저장이 잘 되어있는지 확인
		// System.out.println(Beans.get("/notice3/list.jsp"));
		// System.out.println(Beans.getDAO("noticeDAO"));
		
		// 오라클 드라이버와 필요한 메서드 로딩
		try { 
			// class 안에 있는 static 부분이 로딩되고 static{} 초기화 블록이 실행된다.
			Class.forName("com.webjjang.util.db.DBInfo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("드라이버 확인하는 처리 중 오류 발생");
		}
	}

}
