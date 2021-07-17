package com.OOTD.util.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class AuthorityFilter
 */
//@WebServlet("/AuthorityFilter")
public class AuthorityFilter implements Filter {
	
	//url에 대한 권한 정보를 저장하는 MAP
	private static Map<String, Integer> authMap = new HashMap<>();
	
//	static {
//		// 공지사항 - 등록, 수정, 삭제 - 관리자 : 9 -> 관리자만 가능
//		authMap.put("/notice/writeForm.do", 9);
//		authMap.put("/notice/write.do", 9);
//		authMap.put("/notice/updateForm.do", 9);
//		authMap.put("/notice/update.do", 9);
//		authMap.put("/notice/delete.do", 9);
//		authMap.put("/notice/view.do", 1);
//		// 질문답변 - 리스트, 질문하기, 답변하기, 수정, 삭제 : 1 -> 일반회원도 답변이 가능
//		authMap.put("/qna/list.do", 1);
//		authMap.put("/qna/view.do", 1);
//		authMap.put("/qna/questionForm.do", 1);
//		authMap.put("/qna/question.do", 1);
//		authMap.put("/qna/answerForm.do", 1);
//		authMap.put("/qna/answer.do", 1);
//		authMap.put("/qna/updateForm.do", 1);
//		authMap.put("/qna/update.do", 1);
//		authMap.put("/qna/delete.do", 1);
//		// 메시지 - 리스트, 보기, 보내기, 삭제 : 1 -> 일반회원도 답변이 가능
//		authMap.put("/message/list.do", 1);
//		authMap.put("/message/view.do", 1);
//		authMap.put("/message/write.do", 1);
//		authMap.put("/message/writeForm.do", 1);
//		authMap.put("/message/delete.do", 1);
//		authMap.put("/ajax/getMessageCnt.do", 1);
//		// 이미지게시판 - 등록, 수정, 삭제 - 회원 : 1 -> 회원만 가능
//		authMap.put("/image/writeForm.do", 1);
//		authMap.put("/image/write.do", 1);
//		authMap.put("/image/updateForm.do", 1);
//		authMap.put("/image/update.do", 1);
//		authMap.put("/image/updateFile.do", 1);
//		authMap.put("/image/delete.do", 1);
//		// 내정보보기
//		authMap.put("/member/view.do", 1);
//	}
	//요청한 URL 설정 
	public static String url;
	
	 /**
     * Default constructor. 
     */
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }
	
    
    /**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest )request;
		// TODO Auto-generated method stub
		System.out.println("Authority.dofilter() - 권한처리");
	
		url = ((HttpServletRequest)request).getServletPath();
		System.out.println("Authority.dofilter.url : " + url);
		
		

		//로그인 객체 꺼내기
		//로그인 정보는  session에 있는데 안보일 경우 -> request 에서 꺼낼 수 있음
		HttpSession session = req.getSession();
//		LoginVO vo = (LoginVO)session.getAttribute("login");
		
		// pass the request along the filter chain
				chain.doFilter(request, response);
		
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
